package com.example.hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private ShapeableImageView[][] board;
    private FloatingActionButton arrow_left_btn;
    private FloatingActionButton arrow_right_btn;
    private static int colNum=1;
    private ImageView[] heartArr;
    final int DELAY=1000;
    private int heartArrayIndex=2;


    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("pttt","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initViews();
    }
    private void findViews()
    {
        heartArr=new ImageView[3];
        heartArr[0]=findViewById(R.id.heart_1);
        heartArr[1]=findViewById(R.id.heart_2);
        heartArr[2]=findViewById(R.id.heart_3);
        board=new ShapeableImageView[8][3];
        board[0][0]=findViewById(R.id.stone_0_0);
        board[0][1]=findViewById(R.id.stone_0_1);
        board[0][2]=findViewById(R.id.stone_0_2);
        board[1][0]=findViewById(R.id.stone_1_0);
        board[1][1]=findViewById(R.id.stone_1_1);
        board[1][2]=findViewById(R.id.stone_1_2);
        board[2][0]=findViewById(R.id.stone_2_0);
        board[2][1]=findViewById(R.id.stone_2_1);
        board[2][2]=findViewById(R.id.stone_2_2);
        board[3][0]=findViewById(R.id.stone_3_0);
        board[3][1]=findViewById(R.id.stone_3_1);
        board[3][2]=findViewById(R.id.stone_3_2);
        board[4][0]=findViewById(R.id.stone_4_0);
        board[4][1]=findViewById(R.id.stone_4_1);
        board[4][2]=findViewById(R.id.stone_4_2);
        board[5][0]=findViewById(R.id.stone_5_0);
        board[5][1]=findViewById(R.id.stone_5_1);
        board[5][2]=findViewById(R.id.stone_5_2);
        board[6][0]=findViewById(R.id.stone_6_0);
        board[6][1]=findViewById(R.id.stone_6_1);
        board[6][2]=findViewById(R.id.stone_6_2);
        board[7][0]=findViewById(R.id.car_7_0);
        board[7][1]=findViewById(R.id.car_7_1);
        board[7][2]=findViewById(R.id.car_7_2);
        arrow_left_btn=findViewById(R.id.left_btn);
        arrow_right_btn=findViewById(R.id.right_btn);


    }
    private void initViews()
    {
        board[7][0].setVisibility(View.INVISIBLE);
        board[7][1].setVisibility(View.VISIBLE);
        board[7][2].setVisibility(View.INVISIBLE);
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j].setVisibility(View.INVISIBLE);
            }
        }
        arrow_left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveLeft();
            }
        });
        arrow_right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveRight();
            }
        });

    }

    private void moveLeft()
    {
        if(colNum==1)
        {
            board[7][0].setVisibility(View.VISIBLE);
            board[7][1].setVisibility(View.INVISIBLE);
            board[7][2].setVisibility(View.INVISIBLE);
            colNum=0;
            return;
        }
        if(colNum==2)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.VISIBLE);
            board[7][2].setVisibility(View.INVISIBLE);
            colNum=1;
            return;
        }
        if(colNum==0)
        {
            return;
        }


    }
    private void moveRight()
    {
        if(colNum==1)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.INVISIBLE);
            board[7][2].setVisibility(View.VISIBLE);
            colNum=2;
            return;
        }
        if(colNum==0)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.VISIBLE);
            board[7][2].setVisibility(View.INVISIBLE);
            colNum=1;
            return;
        }
        if(colNum==2)
            return;

    }


    @Override
    protected void onStart() {
        Log.d("pttt","onStart");
        super.onStart();
        startGame();
    }
    @Override
    protected void onResume() {
        Log.d("pttt","onResume");
        super.onResume();
    }
    @Override
    protected void onPause() {
        Log.d("pttt","onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("pttt","onStop");
        super.onStop();
        stopGame();
    }
    final Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this,DELAY);
            helper();
        }
    };
    private void startGame()
    {
        handler.postDelayed(runnable,DELAY);
    }
    private void stopGame()
    {
        handler.removeCallbacks(runnable);
    }
    private void setRandomStone()
    {
        Random rnd=new Random();
        int colIndex=rnd.nextInt(3);
        board[0][colIndex].setVisibility(View.VISIBLE);
    }
    boolean flag=true;
    private void helper()
    {
        if(flag==true)
        {
            setRandomStone();
            moveStones();
            flag=false;
        }
        else {
            moveStones();
            flag=true;
        }

    }


    private void moveStones()
    {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        for(int i=6;i>0;i--)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i-1][j].getVisibility()==View.VISIBLE)
                {
                    Log.d("ggg","row:"+i+" cols:"+j);
                    board[i][j].setVisibility(View.VISIBLE);
                    board[i-1][j].setVisibility(View.INVISIBLE);
                }
            }
        }
        if(heartArrayIndex<0)
        {
            heartArr[0].setVisibility(View.VISIBLE);
            heartArr[1].setVisibility(View.VISIBLE);
            heartArr[2].setVisibility(View.VISIBLE);
            heartArrayIndex=2;
        }
        if(board[7][0].getVisibility()==View.VISIBLE && board[6][0].getVisibility()==View.VISIBLE)
        {
            Toast.makeText(MainActivity.this, "you crached ", Toast.LENGTH_SHORT).show();
            heartArr[heartArrayIndex].setVisibility(View.INVISIBLE);
            vibrate();
            heartArrayIndex--;
        }
        if(board[7][1].getVisibility()==View.VISIBLE && board[6][1].getVisibility()==View.VISIBLE)
        {
            vibrator.vibrate(1000);
            Toast.makeText(MainActivity.this, "you crached ", Toast.LENGTH_SHORT).show();
            heartArr[heartArrayIndex].setVisibility(View.INVISIBLE);
            vibrate();
            heartArrayIndex--;
        }
        if(board[7][2].getVisibility()==View.VISIBLE && board[6][2].getVisibility()==View.VISIBLE)
        {
            vibrator.vibrate(1000);
            Toast.makeText(MainActivity.this, "you crached ", Toast.LENGTH_SHORT).show();
            heartArr[heartArrayIndex].setVisibility(View.INVISIBLE);
            vibrate();
            heartArrayIndex--;
        }
        board[6][0].setVisibility(View.INVISIBLE);
        board[6][1].setVisibility(View.INVISIBLE);
        board[6][2].setVisibility(View.INVISIBLE);

    }
    private void vibrate()
    {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(1000);
        }
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("pttt","onState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        Log.d("pttt","onDestroy");
        super.onDestroy();
    }





}