package com.example.subscriber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAndType();
        initAndSubscribe();
        showButtons();
        vanish();
    }

    public void initAndType() {
        Button typeButton = (Button) findViewById(R.id.typeButton);
        final LinearLayout buttonPanel = (LinearLayout) findViewById(R.id.buttonPanel);

        typeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPanel.setVisibility(View.GONE);
            }
        });
    }

    public void initAndSubscribe() {
        Button subscribeButton = (Button) findViewById(R.id.subscribeButton);
        final EditText userName = (EditText) findViewById(R.id.nameField);
        final EditText userPassword = (EditText) findViewById(R.id.passwordField);
        final TextView outputField = (TextView) findViewById(R.id.outputField);
        String name;
        String password;

        name = userName.getText().toString();
        password = userPassword.getText().toString();

        if ("" == name | "" == password) {
            subscribeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    outputField.setText("Fill all fields!");
                }
            });
        }
        else {
            subscribeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    outputField.setText("Subscribed as " + userName.getText() +
                            " " + userPassword.getText());
                }
            });
        }
    }

    public void showButtons() {
        ConstraintLayout field = (ConstraintLayout) findViewById(R.id.field);
        final LinearLayout buttonPanel = (LinearLayout) findViewById(R.id.buttonPanel);

        field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPanel.setVisibility(View.VISIBLE);
            }
        });
    }

    public void vanish() {
        Button vanishButton = (Button) findViewById(R.id.vanishButton);
        final EditText userName = (EditText) findViewById(R.id.nameField);
        final EditText userPassword = (EditText) findViewById(R.id.passwordField);

        vanishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName.setText("");
                userPassword.setText("");
            }
        });
    }

}