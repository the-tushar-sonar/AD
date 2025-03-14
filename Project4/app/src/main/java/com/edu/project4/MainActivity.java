package com.edu.project4;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Example: Accessing the ScrollView programmatically
        ScrollView verticalScrollView = findViewById(R.id.verticalScrollView);
// You can add listeners or modify properties here if needed
    }
}