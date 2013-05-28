package com.example.caculate;

import com.example.caculate.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	String numberResult = "";
	char op = '\0';
	TextView tv = null;
	//String buttonString;
	Caculate mycaculate = new Caculate();
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("MainActivity","on create");
		tv = (TextView) findViewById(R.id.resultText);
	}
	
	public void digitPress(View v)
	{
		Button digitButton = (Button) findViewById(v.getId());
		mycaculate.addDigit(digitButton.getText().charAt(0));
		numberResult = mycaculate.getValue();
		tv.setText(this.numberResult);
		Log.i("MainActivity","digitPress");
	}
	
	
	public void operatePress(View v)
	{
		Button operateButton = (Button) findViewById(v.getId());
		op = operateButton.getText().charAt(0);
		mycaculate.compute(op);
		numberResult = mycaculate.getValue();
		tv.setText(this.numberResult);
		Log.i("MainActivity","operatePress");
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
