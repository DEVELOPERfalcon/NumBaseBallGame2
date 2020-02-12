package kr.co.taksoft.numbaseballgame2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView ball1;
    ImageView ball2;
    ImageView ball3;
    Button remove1;
    Button remove2;
    Button remove3;
    Button fight;
    ScrollView sv;
    TextView result;

    Toast t;

    ImageButton button0;
    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;
    ImageButton button6;
    ImageButton button7;
    ImageButton button8;
    ImageButton button9;

    Drawable drawable;
    Bitmap bitmap;

    Drawable drawableBall0;
    Bitmap bitmapBall0;
    Drawable drawableBall1;
    Bitmap bitmapBall1;
    Drawable drawableBall2;
    Bitmap bitmapBall2;
    Drawable drawableBall3;
    Bitmap bitmapBall3;
    Drawable drawableBall4;
    Bitmap bitmapBall4;
    Drawable drawableBall5;
    Bitmap bitmapBall5;
    Drawable drawableBall6;
    Bitmap bitmapBall6;
    Drawable drawableBall7;
    Bitmap bitmapBall7;
    Drawable drawableBall8;
    Bitmap bitmapBall8;
    Drawable drawableBall9;
    Bitmap bitmapBall9;

    Random rand;
    int num1, num2, num3;
    int[] answer = new int[3];

    int strike, ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rand = new Random();
        for(int i=0;i<3;i++){
            do {
                answer[i] = rand.nextInt(10);
            }while ((i==0 && answer[0]==0) || (i==1 && answer[0]==answer[1]) || (i==2 && answer[0]==answer[2]) || (i==2 && answer[1]==answer[2]));
        }

        drawable = getResources().getDrawable(R.drawable.empty);
        bitmap = ((BitmapDrawable)drawable).getBitmap();

        drawableBall0 = getResources().getDrawable(R.drawable.ballzero);
        bitmapBall0 = ((BitmapDrawable)drawableBall0).getBitmap();
        drawableBall1 = getResources().getDrawable(R.drawable.ballone);
        bitmapBall1 = ((BitmapDrawable)drawableBall1).getBitmap();
        drawableBall2 = getResources().getDrawable(R.drawable.balltwo);
        bitmapBall2 = ((BitmapDrawable)drawableBall2).getBitmap();
        drawableBall3 = getResources().getDrawable(R.drawable.ballthree);
        bitmapBall3 = ((BitmapDrawable)drawableBall3).getBitmap();
        drawableBall4 = getResources().getDrawable(R.drawable.ballfour);
        bitmapBall4 = ((BitmapDrawable)drawableBall4).getBitmap();
        drawableBall5 = getResources().getDrawable(R.drawable.ballfive);
        bitmapBall5 = ((BitmapDrawable)drawableBall5).getBitmap();
        drawableBall6 = getResources().getDrawable(R.drawable.ballsix);
        bitmapBall6 = ((BitmapDrawable)drawableBall6).getBitmap();
        drawableBall7 = getResources().getDrawable(R.drawable.ballseven);
        bitmapBall7 = ((BitmapDrawable)drawableBall7).getBitmap();
        drawableBall8 = getResources().getDrawable(R.drawable.balleight);
        bitmapBall8 = ((BitmapDrawable)drawableBall8).getBitmap();
        drawableBall9 = getResources().getDrawable(R.drawable.ballnine);
        bitmapBall9 = ((BitmapDrawable)drawableBall9).getBitmap();

        ball1 = findViewById(R.id.ball1);
        ball2 = findViewById(R.id.ball2);
        ball3 = findViewById(R.id.ball3);
        remove1 = findViewById(R.id.remove1);
        remove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                if(bitmap.equals(bitmap1)) {
                    return;
                }
                else {
                    ball1.setImageResource(R.drawable.empty);
                }
            }
        });
        remove2 = findViewById(R.id.remove2);
        remove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball2.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                if(bitmap.equals(bitmap1)) return;
                else ball2.setImageResource(R.drawable.empty);
            }
        });
        remove3 = findViewById(R.id.remove3);
        remove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball3.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                if(bitmap.equals(bitmap1)) return;
                else ball3.setImageResource(R.drawable.empty);
            }
        });
        fight = findViewById(R.id.fight);
        fight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap.equals(bitmap1) || bitmap.equals(bitmap2) || bitmap.equals(bitmap3)) {
                    if(t != null){
                        t.cancel();
                        t = null;
                    }
                    t=Toast.makeText(MainActivity.this, "3개를 선택해야 합니다.", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    return;
                }
                else {
                    if(bitmap1.equals(bitmapBall1)) num1=1;
                    else if(bitmap1.equals(bitmapBall2)) num1=2;
                    else if(bitmap1.equals(bitmapBall3)) num1=3;
                    else if(bitmap1.equals(bitmapBall4)) num1=4;
                    else if(bitmap1.equals(bitmapBall5)) num1=5;
                    else if(bitmap1.equals(bitmapBall6)) num1=6;
                    else if(bitmap1.equals(bitmapBall7)) num1=7;
                    else if(bitmap1.equals(bitmapBall8)) num1=8;
                    else if(bitmap1.equals(bitmapBall9)) num1=9;

                    if(bitmap2.equals(bitmapBall0)) num2=0;
                    else if(bitmap2.equals(bitmapBall1)) num2=1;
                    else if(bitmap2.equals(bitmapBall2)) num2=2;
                    else if(bitmap2.equals(bitmapBall3)) num2=3;
                    else if(bitmap2.equals(bitmapBall4)) num2=4;
                    else if(bitmap2.equals(bitmapBall5)) num2=5;
                    else if(bitmap2.equals(bitmapBall6)) num2=6;
                    else if(bitmap2.equals(bitmapBall7)) num2=7;
                    else if(bitmap2.equals(bitmapBall8)) num2=8;
                    else if(bitmap2.equals(bitmapBall9)) num2=9;

                    if(bitmap3.equals(bitmapBall0)) num3=0;
                    else if(bitmap3.equals(bitmapBall1)) num3=1;
                    else if(bitmap3.equals(bitmapBall2)) num3=2;
                    else if(bitmap3.equals(bitmapBall3)) num3=3;
                    else if(bitmap3.equals(bitmapBall4)) num3=4;
                    else if(bitmap3.equals(bitmapBall5)) num3=5;
                    else if(bitmap3.equals(bitmapBall6)) num3=6;
                    else if(bitmap3.equals(bitmapBall7)) num3=7;
                    else if(bitmap3.equals(bitmapBall8)) num3=8;
                    else if(bitmap3.equals(bitmapBall9)) num3=9;

                    ball1.setImageResource(R.drawable.empty);
                    ball2.setImageResource(R.drawable.empty);
                    ball3.setImageResource(R.drawable.empty);

                    if(num1==answer[0]) strike++;
                    else if(num1==answer[1] || num1==answer[2]) ball++;
                    if(num2==answer[1]) strike++;
                    else if(num2==answer[0] || num2==answer[2]) ball++;
                    if(num3==answer[2]) strike++;
                    else if(num3==answer[0] || num3==answer[1]) ball++;

                    result.setText(result.getText().toString()+strike+"Strike "+ball+"Ball\n");
                    if(strike==3 && ball==0){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("클리어!!\n한번 더 하시겠습니까?");
                        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                strike=0;
                                ball=0;
                                rand = new Random();
                                for(int k=0;k<3;k++){
                                    do {
                                        answer[k] = rand.nextInt(10);
                                    }while ((k==0 && answer[0]==0) || (k==1 && answer[0]==answer[1]) || (k==2 && answer[0]==answer[2]) || (k==2 && answer[1]==answer[2]));
                                }
                                result.setText("");
                            }
                        });
                        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setCancelable(false);
                        dialog.show();
                }
                    strike=0;
                    ball=0;
                    sv.fullScroll(ScrollView.FOCUS_DOWN);
                }
            }
        });
        sv = findViewById(R.id.sv);
        result = findViewById(R.id.result);

        button0 = findViewById(R.id.zero_button);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) return;
                else if(bitmap2.equals(bitmap)) {
                    ball2.setImageResource(R.drawable.ballzero);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall0) || bitmap2.equals(bitmapBall0)) return;
                    ball3.setImageResource(R.drawable.ballzero);
                }
                else return;
            }
        });
        button1 = findViewById(R.id.one_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) ball1.setImageResource(R.drawable.ballone);
                else if(bitmap2.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall1)) return;
                    ball2.setImageResource(R.drawable.ballone);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall1) || bitmap2.equals(bitmapBall1)) return;
                    ball3.setImageResource(R.drawable.ballone);
                }
                else return;
            }
        });
        button2 = findViewById(R.id.two_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) ball1.setImageResource(R.drawable.balltwo);
                else if(bitmap2.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall2)) return;
                    ball2.setImageResource(R.drawable.balltwo);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall2) || bitmap2.equals(bitmapBall2)) return;
                    ball3.setImageResource(R.drawable.balltwo);
                }
                else return;
            }
        });
        button3 = findViewById(R.id.three_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) ball1.setImageResource(R.drawable.ballthree);
                else if(bitmap2.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall3)) return;
                    ball2.setImageResource(R.drawable.ballthree);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall3) || bitmap2.equals(bitmapBall3)) return;
                    ball3.setImageResource(R.drawable.ballthree);
                }
                else return;
            }
        });
        button4 = findViewById(R.id.four_button);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) ball1.setImageResource(R.drawable.ballfour);
                else if(bitmap2.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall4)) return;
                    ball2.setImageResource(R.drawable.ballfour);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall4) || bitmap2.equals(bitmapBall4)) return;
                    ball3.setImageResource(R.drawable.ballfour);
                }
                else return;
            }
        });
        button5 = findViewById(R.id.five_button);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) ball1.setImageResource(R.drawable.ballfive);
                else if(bitmap2.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall5)) return;
                    ball2.setImageResource(R.drawable.ballfive);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall5) || bitmap2.equals(bitmapBall5)) return;
                    ball3.setImageResource(R.drawable.ballfive);
                }
                else return;
            }
        });
        button6 = findViewById(R.id.six_button);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) ball1.setImageResource(R.drawable.ballsix);
                else if(bitmap2.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall6)) return;
                    ball2.setImageResource(R.drawable.ballsix);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall6) || bitmap2.equals(bitmapBall6)) return;
                    ball3.setImageResource(R.drawable.ballsix);
                }
                else return;
            }
        });
        button7 = findViewById(R.id.seven_button);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) ball1.setImageResource(R.drawable.ballseven);
                else if(bitmap2.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall7)) return;
                    ball2.setImageResource(R.drawable.ballseven);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall7) || bitmap2.equals(bitmapBall7)) return;
                    ball3.setImageResource(R.drawable.ballseven);
                }
                else return;
            }
        });
        button8 = findViewById(R.id.eight_button);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) ball1.setImageResource(R.drawable.balleight);
                else if(bitmap2.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall8)) return;
                    ball2.setImageResource(R.drawable.balleight);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall8) || bitmap2.equals(bitmapBall8)) return;
                    ball3.setImageResource(R.drawable.balleight);
                }
                else return;
            }
        });
        button9 = findViewById(R.id.nine_button);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable1 = ball1.getDrawable();
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                Drawable drawable2 = ball2.getDrawable();
                Bitmap bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
                Drawable drawable3 = ball3.getDrawable();
                Bitmap bitmap3 = ((BitmapDrawable)drawable3).getBitmap();
                if(bitmap1.equals(bitmap)) ball1.setImageResource(R.drawable.ballnine);
                else if(bitmap2.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall9)) return;
                    ball2.setImageResource(R.drawable.ballnine);
                }
                else if(bitmap3.equals(bitmap)) {
                    if(bitmap1.equals(bitmapBall9) || bitmap2.equals(bitmapBall9)) return;
                    ball3.setImageResource(R.drawable.ballnine);
                }
                else return;
            }
        });

        button0.setBackgroundColor(Color.TRANSPARENT);
        button1.setBackgroundColor(Color.TRANSPARENT);
        button2.setBackgroundColor(Color.TRANSPARENT);
        button3.setBackgroundColor(Color.TRANSPARENT);
        button4.setBackgroundColor(Color.TRANSPARENT);
        button5.setBackgroundColor(Color.TRANSPARENT);
        button6.setBackgroundColor(Color.TRANSPARENT);
        button7.setBackgroundColor(Color.TRANSPARENT);
        button8.setBackgroundColor(Color.TRANSPARENT);
        button9.setBackgroundColor(Color.TRANSPARENT);

    }
}
