package com.example.mywarranty3.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mywarranty3.R;
import com.example.mywarranty3.model.User;
import com.example.mywarranty3.util.ApiCaller;
import com.example.mywarranty3.util.Callback;

public class SignUpActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editUsername;
    EditText editPassword;

    String email = "";
    String username = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);

        TextView txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText(R.string.title_activity_sign_up);

        editEmail = (EditText) findViewById(R.id.edit_sign_up_email);
        editUsername = (EditText) findViewById(R.id.edit_sign_up_username);
        editPassword = (EditText) findViewById(R.id.edit_sign_up_pw);

        Button btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSignUp();
            }
        });
    }

    private void attemptSignUp() {

        // Reset errors.
        editEmail.setError(null);
        editUsername.setError(null);
        editPassword.setError(null);

        // Store values at the time of the login attempt.
        email = editEmail.getText().toString();
        username = editUsername.getText().toString();
        password = editPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            editPassword.setError(getString(R.string.error_invalid_password));
            focusView = editPassword;
            cancel = true;
        }

        // Check for a valid username, if the user entered one.
        if(TextUtils.isEmpty(username)){
            editUsername.setError(getString(R.string.error_field_required));
            focusView = editUsername;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            editEmail.setError(getString(R.string.error_field_required));
            focusView = editEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            editEmail.setError(getString(R.string.error_invalid_email));
            focusView = editEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            ApiCaller.addUser(username, password, email, new Callback<User>() {
                @Override
                public void onSuccess(User result) {
                    Toast.makeText(SignUpActivity.this, "회원가입이 되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure() {
                    Toast.makeText(SignUpActivity.this, "회원가입에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
}
