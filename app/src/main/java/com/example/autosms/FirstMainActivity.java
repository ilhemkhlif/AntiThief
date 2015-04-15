package com.example.autosms;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class FirstMainActivity extends Activity {
    private Button btnDisplay;
    private TextView Code;
    private static String StrCode;
    private static boolean firstRun=false;

    public static String GetCode() {
        return StrCode;
    }



    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main_first);

            addListenerOnButton();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void addListenerOnButton() {

        btnDisplay = (Button) findViewById(R.id.button);

        Code = (TextView) findViewById(R.id.TxtCode);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.v("button", "test");
                if ((Code.getText().toString())!=null) {
                    StrCode = Code.getText().toString();
                    Toast.makeText(FirstMainActivity.this, "Registration successfully  ", Toast.LENGTH_SHORT).show();
                   /* firstRun=true;
                    Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                    startActivityForResult(myIntent, 0);*/
                }
                else {
                    Toast.makeText(FirstMainActivity.this, "Enter your secret code! ", Toast.LENGTH_SHORT).show();
                }



            }

        });

    }
}
