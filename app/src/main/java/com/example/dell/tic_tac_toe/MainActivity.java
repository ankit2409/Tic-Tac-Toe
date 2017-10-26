package com.example.dell.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText player1;
    EditText player2;
    public void gameStart(View view)
    {
        String namePlayer1=player1.getText().toString();
        String namePlayer2=player2.getText().toString();
        Intent intent=new Intent(this, GameBegin1.class);
        intent.putExtra("nameOfplayer1",namePlayer1);
        intent.putExtra("nameOfplayer2",namePlayer2);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1=(EditText) findViewById(R.id.editText);
        player2=(EditText) findViewById(R.id.editText2);

    }
}
