package com.example.hw1.logics;

import android.util.Log;

public class GameManager {
    private int crash;
    private int life;
    private int score;
    public  enum State {EMPTY,STONE,COIN,CAR}
    private State [][] stateMat;
    private final int COLS=5;
    private final int ROWS=8;

    public GameManager(int life)
    {
        this.crash=0;
        this.score=0;
        this.life=life;
        initStateMat();
    }
    public void initStateMat()
    {
        this.stateMat=new State[ROWS][COLS];
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLS;j++)
            {
                    stateMat[i][j]=State.EMPTY;
            }
        }
        stateMat[7][2]=State.CAR;
    }

    public State getState(int rowIndex,int colIndex)
    {
        return stateMat[rowIndex][colIndex];
    }
    public void setState(State state,int rIndex,int cIndex)
    {
        this.stateMat[rIndex][cIndex]=state;
    }



    public int getCrash()
    {
        return crash;
    }
    public int getLife()
    {
        return life;
    }
    public int getScore()
    {
        return score;
    }
    public void setScore(int score)
    {
        this.score=score;
    }
    public void setCrash(int crash)
    {
        this.crash=crash;
    }
    public void setLife(int life)
    {
        this.life=life;
    }
    public void increaseCrash()
    {
        this.crash++;
    }
    public boolean gameOver()
    {
        Log.d("pt","Score");
        if(this.getCrash()==3)
            return true;
        else
            return false;
    }
    public boolean IsCrashWithCoin()
    {
        for(int i=0;i<COLS;i++)
        {
            if(stateMat[ROWS-1][i]==State.CAR && stateMat[ROWS-2][i]==State.COIN)
                return true;
        }
        return false;
    }
    public boolean isCrash()
    {
        for(int i=0;i<COLS;i++)
        {
            if(stateMat[ROWS-1][i]==State.CAR && stateMat[ROWS-2][i]==State.STONE)
                return true;
        }
        return false;

    }
    public void increaseScore()
    {
        if(IsCrashWithCoin()==true)
        {
            this.score+=10;
        }
        else
            this.score++;
    }
}
