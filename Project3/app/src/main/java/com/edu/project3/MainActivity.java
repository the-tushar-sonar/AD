package com.edu.project3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvLoginResult;
    // Dummy credentials
    private static final String VALID_USERNAME = "user123";
    private static final String VALID_PASSWORD = "password123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Initialize the views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvLoginResult = findViewById(R.id.tvLoginResult);
// Set a click listener for the login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Get the entered values
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
// Validate the username and password
                if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
// If credentials are correct, show "Login Successful"
                    tvLoginResult.setText("Login Successful");
                    tvLoginResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                } else {
// If credentials are incorrect, show a Toast message
                    tvLoginResult.setText("");
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}