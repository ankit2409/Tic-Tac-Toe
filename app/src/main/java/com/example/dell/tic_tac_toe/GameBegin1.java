package com.example.dell.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameBegin1 extends AppCompatActivity {
    String nameOfPlayer1;
    String nameOfPlayer2;
    TextView player1;
    TextView player2;
    int scoreOfPlayer1=0;
    int scoreOfPlayer2=0;
    boolean gameIsActive=true;
    int counter1=0;
    int[] activePlay = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public boolean winningFun(int tag)
    {
        for(int i=0;i<8;i++)
        {
            if(activePlay[winningPositions[i][0]]==activePlay[tag]&&
                    activePlay[winningPositions[i][1]]==activePlay[tag]&&
                    activePlay[winningPositions[i][2]]==activePlay[tag])
            {
                return true;
            }
        }
        return false;
    }
    public void dropIn(View view) {
        ImageView counter = (ImageView) view;


        int tag = Integer.parseInt(counter.getTag().toString());
        if (activePlay[tag] == 2&& gameIsActive) {
            activePlay[tag]=counter1%2;
            counter.setTranslationX(0f);

            if (counter1 % 2 == 0) {
                counter.setImageResource(R.drawable.cross);
            }
            else if (counter1 % 2 == 1) {
                counter.setImageResource(R.drawable.zero);
            }

            counter.animate().rotation(360).alpha(1f).setDuration(200);
            if(counter1>=4){
                if(winningFun(tag)){
                    String str;
                    if(counter1%2==0){

                        str=nameOfPlayer1;
                        /*TextView textView3=(TextView) findViewById(R.id.editText3);
                        textView3.setText(scoreOfPlayer1);
                        scoreOfPlayer1++;*/
                    }

                    else {
                        str = nameOfPlayer2;
                        /*TextView textView5=(TextView) findViewById(R.id.editText5);
                        textView5.setText(scoreOfPlayer2);
                        scoreOfPlayer2++;*/
                    }
                    Toast.makeText(this,str+" won!",Toast.LENGTH_LONG).show();

                    gameIsActive=false;
                }
                else if(counter1==8)
                    Toast.makeText(this,"Match Draw",Toast.LENGTH_LONG).show();
            }

            counter1++;
        }



    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_begin1);
        player1=(TextView) findViewById(R.id.textView4);
        player1.setText(getIntent().getExtras().getString("nameOfplayer1"));
        nameOfPlayer1=player1.getText().toString();
        player2=(TextView) findViewById(R.id.textView6);
        player2.setText(getIntent().getExtras().getString("nameOfplayer2"));
        String nameOfPlayer2=player2.getText().toString();

    }
}
