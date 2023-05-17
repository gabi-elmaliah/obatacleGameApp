package com.example.hw1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hw1.Utilities.MySp;
import com.example.hw1.Utilities.SignalGenerator;
import com.example.hw1.logics.GameManager;
import com.example.hw1.models.Record;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;

import java.util.Random;
public class MainActivity extends AppCompatActivity {



    private ShapeableImageView[][] board;
    private FloatingActionButton arrow_left_btn;
    private FusedLocationProviderClient locationClient;
    private MaterialTextView main_LBL_score;
    private FloatingActionButton arrow_right_btn;
    private static int colNum=2;
    private ImageView[] heartArr;
    private int DELAY;
    private int heartArrayIndex=2;
    private final int COLS=5;
    private final int ROWS=8;
    private GameManager gameManager;

    private int counter;
    private Topten topten;
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("pttt","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        findViews();
        initViews();
        gameManager=new GameManager(heartArr.length);
    }
    private void findViews()
    {
        counter=0;
        heartArr=new ImageView[3];
        heartArr[0]=findViewById(R.id.heart_1);
        heartArr[1]=findViewById(R.id.heart_2);
        heartArr[2]=findViewById(R.id.heart_3);
        board=new ShapeableImageView[8][5];
        board[0][0]=findViewById(R.id.stone_0_0);
        board[0][1]=findViewById(R.id.stone_0_1);
        board[0][2]=findViewById(R.id.stone_0_2);
        board[0][3]=findViewById(R.id.stone_0_3);
        board[0][4]=findViewById(R.id.stone_0_4);
        board[1][0]=findViewById(R.id.stone_1_0);
        board[1][1]=findViewById(R.id.stone_1_1);
        board[1][2]=findViewById(R.id.stone_1_2);
        board[1][3]=findViewById(R.id.stone_1_3);
        board[1][4]=findViewById(R.id.stone_1_4);
        board[2][0]=findViewById(R.id.stone_2_0);
        board[2][1]=findViewById(R.id.stone_2_1);
        board[2][2]=findViewById(R.id.stone_2_2);
        board[2][3]=findViewById(R.id.stone_2_3);
        board[2][4]=findViewById(R.id.stone_2_4);
        board[3][0]=findViewById(R.id.stone_3_0);
        board[3][1]=findViewById(R.id.stone_3_1);
        board[3][2]=findViewById(R.id.stone_3_2);
        board[3][3]=findViewById(R.id.stone_3_3);
        board[3][4]=findViewById(R.id.stone_3_4);
        board[4][0]=findViewById(R.id.stone_4_0);
        board[4][1]=findViewById(R.id.stone_4_1);
        board[4][2]=findViewById(R.id.stone_4_2);
        board[4][3]=findViewById(R.id.stone_4_3);
        board[4][4]=findViewById(R.id.stone_4_4);
        board[5][0]=findViewById(R.id.stone_5_0);
        board[5][1]=findViewById(R.id.stone_5_1);
        board[5][2]=findViewById(R.id.stone_5_2);
        board[5][3]=findViewById(R.id.stone_5_3);
        board[5][4]=findViewById(R.id.stone_5_4);
        board[6][0]=findViewById(R.id.stone_6_0);
        board[6][1]=findViewById(R.id.stone_6_1);
        board[6][2]=findViewById(R.id.stone_6_2);
        board[6][3]=findViewById(R.id.stone_6_3);
        board[6][4]=findViewById(R.id.stone_6_4);
        board[7][0]=findViewById(R.id.car_7_0);
        board[7][1]=findViewById(R.id.car_7_1);
        board[7][2]=findViewById(R.id.car_7_2);
        board[7][3]=findViewById(R.id.car_7_3);
        board[7][4]=findViewById(R.id.car_7_4);
        arrow_left_btn=findViewById(R.id.left_btn);
        arrow_right_btn=findViewById(R.id.right_btn);
        main_LBL_score=findViewById(R.id.main_LBL_score);
    }



    private void initViews()
    {
        Intent prevIntent = getIntent();

        DELAY=prevIntent.getIntExtra(MenuActivity.KEY_DELAY,0);
        board[7][0].setVisibility(View.INVISIBLE);
        board[7][1].setVisibility(View.INVISIBLE);
        board[7][2].setVisibility(View.VISIBLE);
        board[7][3].setVisibility(View.INVISIBLE);
        board[7][4].setVisibility(View.INVISIBLE);
        for(int i=0;i<ROWS-1;i++)
        {
            for(int j=0;j<COLS;j++)
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
            board[7][3].setVisibility(View.INVISIBLE);
            board[7][4].setVisibility(View.INVISIBLE);
            gameManager.setState(GameManager.State.EMPTY,7,1);
            gameManager.setState(GameManager.State.CAR,7,0);
            colNum=0;
            return;
        }
        if(colNum==2)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.VISIBLE);
            board[7][2].setVisibility(View.INVISIBLE);
            board[7][3].setVisibility(View.INVISIBLE);
            board[7][4].setVisibility(View.INVISIBLE);
            gameManager.setState(GameManager.State.EMPTY,7,2);
            gameManager.setState(GameManager.State.CAR,7,1);
            colNum=1;
            return;
        }
        if(colNum==3)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.INVISIBLE);
            board[7][2].setVisibility(View.VISIBLE);
            board[7][3].setVisibility(View.INVISIBLE);
            board[7][4].setVisibility(View.INVISIBLE);
            gameManager.setState(GameManager.State.EMPTY,7,3);
            gameManager.setState(GameManager.State.CAR,7,2);
            colNum=2;
            return;
        }
        if(colNum==4)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.INVISIBLE);
            board[7][2].setVisibility(View.INVISIBLE);
            board[7][3].setVisibility(View.VISIBLE);
            board[7][4].setVisibility(View.INVISIBLE);
            gameManager.setState(GameManager.State.EMPTY,7,4);
            gameManager.setState(GameManager.State.CAR,7,3);
            colNum=3;
            return;
        }

        if(colNum==0)
        {
            return;
        }


    }
    private void moveRight()
    {

        if(colNum==0)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.VISIBLE);
            board[7][2].setVisibility(View.INVISIBLE);
            board[7][3].setVisibility(View.INVISIBLE);
            board[7][4].setVisibility(View.INVISIBLE);
            gameManager.setState(GameManager.State.EMPTY,7,0);
            gameManager.setState(GameManager.State.CAR,7,1);

            colNum = 1;
            return;
        }
        if(colNum==1)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.INVISIBLE);
            board[7][2].setVisibility(View.VISIBLE);
            board[7][3].setVisibility(View.INVISIBLE);
            board[7][4].setVisibility(View.INVISIBLE);
            gameManager.setState(GameManager.State.EMPTY,7,1);
            gameManager.setState(GameManager.State.CAR,7,2);
            colNum=2;
            return;
        }
        if(colNum==2)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.INVISIBLE);
            board[7][2].setVisibility(View.INVISIBLE);
            board[7][3].setVisibility(View.VISIBLE);
            board[7][4].setVisibility(View.INVISIBLE);
            gameManager.setState(GameManager.State.EMPTY,7,2);
            gameManager.setState(GameManager.State.CAR,7,3);
            colNum=3;
            return;
        }

        if(colNum==3)
        {
            board[7][0].setVisibility(View.INVISIBLE);
            board[7][1].setVisibility(View.INVISIBLE);
            board[7][2].setVisibility(View.INVISIBLE);
            board[7][3].setVisibility(View.INVISIBLE);
            board[7][4].setVisibility(View.VISIBLE);
            gameManager.setState(GameManager.State.EMPTY,7,3);
            gameManager.setState(GameManager.State.CAR,7,4);
            colNum=4;
            return;
        }
        if(colNum==4)
            return;


    }




     @Override
    protected void onStart() {
        Log.d("pttt","onStart");
        super.onStart();

    }

    @Override
    protected void onResume() {
        Log.d("pttt","onResume");
        super.onResume();
        startGame();
    }
    @Override
    protected void onPause() {
        Log.d("pttt","onPause");
        super.onPause();
        stopGame();
    }

    @Override
    protected void onStop() {
        Log.d("pttt","onStop");
        super.onStop();

    }
    final Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Log.d("ptt","DELAY is:"+DELAY+"\n");
            handler.postDelayed(this,DELAY);
            moveBoard();
            setRandomStoneOrCoin();
            main_LBL_score.setText(""+gameManager.getScore());
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



    private void setRandomStoneOrCoin()
    {
        Random rnd=new Random();
        int colIndex=rnd.nextInt(COLS);
        int isCoin=rnd.nextInt(4);
        Log.d("pttt","cIndex="+colIndex+"is coin:"+isCoin);
        if(isCoin==3)
        {
            board[0][colIndex].setImageResource(R.drawable.coin_ic);
            board[0][colIndex].setVisibility(View.VISIBLE);
            gameManager.setState(GameManager.State.COIN,0,colIndex);
        }
        else
        {
            board[0][colIndex].setImageResource(R.drawable.stone);
            board[0][colIndex].setVisibility(View.VISIBLE);
            gameManager.setState(GameManager.State.STONE,0,colIndex);
        }
    }


    private void cleanLastRaw()
    {
        board[6][0].setVisibility(View.INVISIBLE);
        board[6][1].setVisibility(View.INVISIBLE);
        board[6][2].setVisibility(View.INVISIBLE);
        board[6][3].setVisibility(View.INVISIBLE);
        board[6][4].setVisibility(View.INVISIBLE);
        gameManager.setState(GameManager.State.EMPTY,6,0);
        gameManager.setState(GameManager.State.EMPTY,6,1);
        gameManager.setState(GameManager.State.EMPTY,6,2);
        gameManager.setState(GameManager.State.EMPTY,6,3);
        gameManager.setState(GameManager.State.EMPTY,6,4);
    }

    @SuppressLint("MissingPermission")

    private void moveBoard()
    {
        if (gameManager.isCrash() == true) {
            SignalGenerator.getInstance().toast("you crashed", Toast.LENGTH_SHORT);
            SignalGenerator.getInstance().playSound();
            SignalGenerator.getInstance().vibrate(500);
            heartArr[heartArrayIndex].setVisibility(View.INVISIBLE);
            gameManager.increaseCrash();
            heartArrayIndex--;
        }
        if (gameManager.gameOver() == true)
        {
            locationClient = new FusedLocationProviderClient(this);
            locationClient.getLastLocation().addOnCompleteListener(task ->
            {
                if (task.isSuccessful())
                {
                    Location location = task.getResult();
                    if (location != null)
                    {
                        Record newRecord = new Record(gameManager.getScore(), location.getLatitude(), location.getLongitude());
                        topten.insertNewRecord(newRecord);
                        String recordToJson = new Gson().toJson(topten);
                        MySp.getInstance().putString("records",recordToJson);
                    }
                }
                else {
                    Log.d("taskException "," "+task.getException());
                }
            });
            openRecordActivity();
        }

        gameManager.increaseScore();
        cleanLastRaw();
        for (int i = ROWS - 1; i > 0; i--)
        {
            for (int j = 0; j < COLS; j++)
            {

                if (gameManager.getState(i - 1, j) == GameManager.State.STONE) {
                    board[i][j].setImageResource(R.drawable.stone);
                    board[i][j].setVisibility(View.VISIBLE);
                    board[i - 1][j].setVisibility(View.INVISIBLE);
                    gameManager.setState(GameManager.State.EMPTY, i - 1, j);
                    gameManager.setState(GameManager.State.STONE, i, j);
                } else {
                    if (gameManager.getState(i - 1, j) == GameManager.State.COIN) {
                        board[i][j].setImageResource(R.drawable.coin_ic);
                        board[i][j].setVisibility(View.VISIBLE);
                        board[i - 1][j].setVisibility(View.INVISIBLE);
                        gameManager.setState(GameManager.State.EMPTY, i - 1, j);
                        gameManager.setState(GameManager.State.COIN, i, j);
                    }
                }
            }
        }
    }
    public void openRecordActivity()
    {
        Intent intent = new Intent(this, RecordsActivity.class);
        startActivity(intent);
        finish();
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
   private void loadData()
   {
      String fromSp= MySp.getInstance().getString("records","");
      Log.d("Json:",fromSp);
      topten=new Gson().fromJson(fromSp,Topten.class);
      if(topten==null)
      {
          topten=new Topten();
      }
        topten.toString();
   }




}