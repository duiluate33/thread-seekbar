package kr.ac.yeonsung.seoj.mobileproject_1206_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seek1, seek2;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seek1 = findViewById(R.id.seek1);
        seek2 = findViewById(R.id.seek2);
        Button btnStart = findViewById(R.id.btn_start);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread() {
                    public void run() {
                        for (int i = seek1.getProgress(); i < 100; i = i + 2) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    seek1.setProgress(seek1.getProgress() + 2);
                                    text1.setText("1번 진행률: "+seek1.getProgress()+"%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                new Thread() {
                    public void run() {
                        for (int i = seek2.getProgress(); i < 100; i = i ++) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    seek2.setProgress(seek2.getProgress() + 1);
                                    text2.setText("2번 진행률: "+seek2.getProgress()+"%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

            }
        });
    }
}