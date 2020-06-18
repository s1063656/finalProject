package tw.com.tse.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void play(View view){
        Intent it = new Intent(this,gamePage.class);
        startActivity(it);
        finish();
    }

    public void instruction(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle("遊戲說明");
        builder.setMessage("聽聲音點選相關背景的圖片，\n幫助使用者體驗大自然的美妙．");
        builder.setPositiveButton("確定",null);
        AlertDialog ad = builder.create();
        ad.show();
        TextView msg = (TextView) ad.findViewById(android.R.id.message);
        msg.setGravity(Gravity.CENTER_HORIZONTAL);
        msg.setTextSize(28);


    }
}