package com.example.languageapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.languageapp.R;

//instead of LoginMainPage the first program of the next part of the application should start here.
public class LogoutActivity extends AppCompatActivity {
    Button view, logo;
    int k = 0;
    DBHelper dbHelper;
    TextView show;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        dbHelper = new DBHelper(this);

        view = (Button) findViewById(R.id.view);
        logo = (Button) findViewById(R.id.logout);
        show = (TextView) findViewById(R.id.showAll);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.password);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = dbHelper.getData();
                StringBuilder stringB = new StringBuilder();
                if (res != null && res.getCount() > 0) {
                    while (res.moveToNext()) {
                        stringB.append("Name: " + res.getString(0) + "\n");
                        stringB.append("Username: " + res.getString(1) + "\n");
                        stringB.append("Password: " + res.getString(2) + "\n");
                    }
                    show.setText(stringB.toString());
                    Toast.makeText(LogoutActivity.this, "Data showed", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LogoutActivity.this, "Data N/A", Toast.LENGTH_LONG).show();
                }
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LogoutActivity.this);
                builder.setTitle("Info");
                builder.setMessage("Are you sure you want to logout ??");
                builder.setPositiveButton("Yes I'm sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


    public void onBackPressed() {
        k++;
        if (k == 1) {
            Toast.makeText(LogoutActivity.this, "Press again to go previous activity.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
            startActivity(intent);
        } else {
            finish();
        }
    }
}