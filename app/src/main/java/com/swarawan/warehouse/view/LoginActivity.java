package com.swarawan.warehouse.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.swarawan.warehouse.R;
import com.swarawan.warehouse.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initData();
        findViewById(R.id.button_login).setOnClickListener(onLoginClicked);
    }

    private void initData() {
        users.add(new User("binar1", "12345678"));
        users.add(new User("binar2", "12345678"));
        users.add(new User("binar3", "12345678"));
        users.add(new User("binar4", "12345678"));
        users.add(new User("binar5", "12345678"));
    }

    public View.OnClickListener onLoginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            login();
        }
    };

    private void login() {
        if (!validateForm())
            Toast.makeText(LoginActivity.this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show();
        else validateCredentials();
    }

    private void validateCredentials() {
        String username = ((EditText) findViewById(R.id.input_username)).getText().toString();
        String password = ((EditText) findViewById(R.id.input_password)).getText().toString();

        for (User user : users) {
            if (username.equals(user.username) && password.equals(user.password)) {
                gotoMain();
                break;
            } else {
                Toast.makeText(this, "User tidak ditemukan", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void gotoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean validateForm() {
        return !(((EditText) findViewById(R.id.input_username)).getText().toString().equals("")
                && ((EditText) findViewById(R.id.input_password)).getText().toString().equals(""));
    }
}
