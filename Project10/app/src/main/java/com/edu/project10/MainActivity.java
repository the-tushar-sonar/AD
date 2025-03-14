package com.edu.project10;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Button startButton;
    private int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProgress();
            }
        });
    }
    private void startProgress() {
// Reset progress if it's already completed
        if (progress >= progressBar.getMax()) {
            progress = 0;
            progressBar.setProgress(progress);
        }
// Simulate progress update
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < progressBar.getMax()) {
                    try {
                        Thread.sleep(50); // Update every 50 milliseconds
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                            progress++;
                        }
                    });
                }
            }
        });
        thread.start();
    }
}