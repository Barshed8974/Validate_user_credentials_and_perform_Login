package com.example.validate_user_credentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private Button mbtnLogin;
    private EditText mEdtEmail;
    private EditText mEdtPassword;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initviews();
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean emailValid=isEmailValid();
                boolean passwordvallid=isPassword();
                if(emailValid&&passwordvallid)
                {
                    Intent intent=new Intent(Login.this,Home.class);
                    startActivity(intent);
                }
            }
        });

    }
    private void initviews()
    {
        mEdtEmail=findViewById(R.id.etEmail);
        mEdtPassword=findViewById(R.id.etPassword);
        mbtnLogin=findViewById(R.id.btnLogin);
    }
    private boolean isEmailValid()
    {
        if(mEdtEmail.getText().toString().matches(emailValidation))
        {
            return true;
        }
        else
        {
            mEdtEmail.setError("Invalid format");
            return false;
        }
    }
    private boolean isPassword()
    {
        if(mEdtPassword.getText().length()>=6)
        {
            return true;
        }
        else
        {
            mEdtPassword.setError("Invalid format");
            return false;
        }
    }
}