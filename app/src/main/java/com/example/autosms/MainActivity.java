package com.example.autosms;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnDisplay;



    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
	 
		btnDisplay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Log.v("button", "test");
				boolean activated=SmsReceiver.changeStatus();
	 
				Toast.makeText(MainActivity.this, (activated)?"On" : "Off", Toast.LENGTH_SHORT).show();
				
			}
	 
		});
	 
	  }
}
