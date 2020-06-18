package tw.com.tse.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class gamePage extends AppCompatActivity {
    private int count = 0,ans,score=0;

    private MediaPlayer mper = new MediaPlayer();
    private ImageButton a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        a = (ImageButton) findViewById(R.id.imageButton);
        b = (ImageButton) findViewById(R.id.imageButton2);

        start();
    }
    private void start(){
        setGame(a,b);
        if(count<=3) {
            if(ans==1) {
                a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(gamePage.this,"答對了",Toast.LENGTH_SHORT).show();
                        score++;
                        start();
                    }
                });
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(gamePage.this,"答錯了",Toast.LENGTH_SHORT).show();
                        start();
                    }
                });
            }else{
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(gamePage.this,"答對了",Toast.LENGTH_SHORT).show();
                        score++;
                        start();
                    }
                });
                a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(gamePage.this,"答錯了",Toast.LENGTH_SHORT).show();
                        start();
                    }
                });
            }
        }else{
            gameOver();
        }
    }
    private void gameOver(){
        AlertDialog.Builder bd = new AlertDialog.Builder(this);
        bd.setTitle("遊戲結束了喔").setMessage("您答對"+score+"題唷!").setPositiveButton("回首頁", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent it = new Intent(gamePage.this,MainActivity.class);
                startActivity(it);
            }
        }).setNegativeButton("關閉遊戲", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        bd.show();

    }
    private void setGame(ImageButton x,ImageButton y){
        switch (count){
            case 0:
                x.setBackgroundResource(R.drawable.forest);
                y.setBackgroundResource(R.drawable.river);
                ans=1;
                mper.reset();
                mper = MediaPlayer.create(this, R.raw.cricket);
                mper.setLooping(true);
                mper.start();
                break;
            case 1:
                x.setBackgroundResource(R.drawable.river);
                y.setBackgroundResource(R.drawable.windy);
                ans=1;
                mper.reset();
                mper = MediaPlayer.create(this, R.raw.river);
                mper.setLooping(true);
                mper.start();
                break;
            case 2:
                x.setBackgroundResource(R.drawable.forest);
                y.setBackgroundResource(R.drawable.thunder);
                ans=0;
                mper.reset();
                mper = MediaPlayer.create(this, R.raw.thunder);
                mper.setLooping(true);
                mper.start();
                break;
        }
        count++;
    }
}