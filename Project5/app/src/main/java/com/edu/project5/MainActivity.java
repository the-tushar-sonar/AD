package com.edu.project5;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Add TextChangedListeners to validate input
        editTextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // No action needed here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                validateInputs();
            }

            @Override
            public void afterTextChanged(android.text.Editable editable) {
                // Optional: Add logic if needed
            }
        });

        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // No action needed here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                validateInputs();
            }

            @Override
            public void afterTextChanged(android.text.Editable editable) {
                // Optional: Add logic if needed
            }
        });

        // Set up click listener for login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle login logic here (e.g., authenticate user)
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (validateLogin(username, password)) {
                    // Proceed with the login process
                    showMessage("Login Successful!");
                } else {
                    showMessage("Invalid credentials!");
                }
            }
        });
    }

    private void validateInputs() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        // Enable login button only if both fields are non-empty
        buttonLogin.setEnabled(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password));
    }

    private boolean validateLogin(String username, String password) {
        // This is a placeholder logic for validation.
        // You can replace it with actual login logic.
        return username.equals("user") && password.equals("password");
    }

    private void showMessage(String message) {
        // Display a simple message (you can replace this with Toast or other UI elements)
        android.widget.Toast.makeText(MainActivity.this, message,
                android.widget.Toast.LENGTH_SHORT).show();
    }
}
