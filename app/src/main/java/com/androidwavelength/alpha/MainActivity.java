package com.androidwavelength.alpha;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    private TextView txtCompanyName;
    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private LinearLayout mainContainer;
    public TextView txtMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainContainer = new LinearLayout(this);
        mainContainer.setOrientation(LinearLayout.VERTICAL);
        mainContainer.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        mainContainer.setGravity(Gravity.CENTER_HORIZONTAL);
        mainContainer.setPadding(30,0,30,0);

        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        txtMessage = new TextView(this);
        txtMessage.setLayoutParams(layoutParams);
        txtMessage.setGravity(Gravity.CENTER_HORIZONTAL);
        mainContainer.addView(txtMessage);


        txtCompanyName = new TextView(this);
        txtCompanyName.setText("Bitcode");
        txtCompanyName.setTextSize(40);
        txtCompanyName.setTextColor(Color.RED);
        txtCompanyName.setGravity(Gravity.CENTER_HORIZONTAL);
        txtCompanyName.setLayoutParams(layoutParams);
        mainContainer.addView(txtCompanyName);

        edtUsername = new EditText(this);
        edtUsername.setHint("Username");
        edtUsername.setLayoutParams(layoutParams);
        mainContainer.addView(edtUsername);

        edtPassword = new EditText(this);
        edtPassword.setHint("Password");
        edtPassword.setLayoutParams(layoutParams);
        mainContainer.addView(edtPassword);


        btnLogin = new Button(this);
        btnLogin.setLayoutParams(layoutParams);
        btnLogin.setText("Login");
        mainContainer.addView(btnLogin);

        View.OnClickListener onClickListener = new BtnLoginClickListener();
        btnLogin.setOnClickListener(onClickListener);
        txtMessage.setOnClickListener(onClickListener);

        setContentView(mainContainer);

    }
    private class BtnLoginClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view == btnLogin) {
                if(edtUsername.getText().toString().equals("bitcode") &&
                     edtPassword.getText().toString().equals("bitcode")) {
                    txtMessage.setText("Success");
                }
                    else{
                        txtMessage.setText("Failed");
                    }
                Toast.makeText(
                        MainActivity.this,
                        "I am clicked...",
                        Toast.LENGTH_SHORT
                ).show();
                }
            if(view == txtMessage) {
                txtMessage.setText(" ");
            }
        }
    }

    class BtnLoginKeyListener implements View.OnKeyListener{
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (
                    edtUsername.getText().toString().equals("bitcode") &&
                            edtPassword.getText().toString().equals("bitcode")
            ) {
                txtMessage.setText("Success");
            } else {
                txtMessage.setText("Failed");
            }
            Toast.makeText(
                    MainActivity.this,
                    "I am clicked...",
                    Toast.LENGTH_SHORT
            ).show();
            return false;
        }
    }
}
