package com.edu.project2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText etUsername, etEmail, etPassword;
    private CheckBox cbAgree;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Initialize the views
        etUsername = findViewById(R.id.setUsername);
        etEmail = findViewById(R.id.setEmail);
        etPassword = findViewById(R.id.setPassword);
        cbAgree = findViewById(R.id.cbAgree);
        btnRegister = findViewById(R.id.btnRegister);
// Set a click listener for the register button
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Get the entered values
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                boolean isAgreeChecked = cbAgree.isChecked();
// Validate the input
                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "All fields are required",
                            Toast.LENGTH_SHORT).show();
                } else if (!isAgreeChecked) {
                    Toast.makeText(MainActivity.this, "You must agree to the terms and conditions",
                            Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(MainActivity.this, "Invalid email address",
                            Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    Toast.makeText(MainActivity.this, "Password must be at least 8 characters long",
                            Toast.LENGTH_SHORT).show();
                } else {
// Proceed with registration (for now, just show a toast)
                    Toast.makeText(MainActivity.this, "Registration successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        return email.matches(emailRegex);
    }
}