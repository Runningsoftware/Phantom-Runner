package com.teamPhantomRunners.phantomrunner;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class PhantomRunner extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.PhantomRunner.MESSAGE";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		EditText editText = (EditText) findViewById(R.id.editText1);
		
		switch (item.getItemId()) {
		
		case R.id.menu_run:
			
			editText.setText("run");
			
			Intent intent = new Intent(PhantomRunner.this, MapRunner.class);
			
			intent.putExtra(EXTRA_MESSAGE, R.string.menu_run);

			startActivity(intent);

			return true;

		case R.id.menu_timer:

			editText.setText("timer");

			return true;

		case R.id.menu_challenge:

			editText.setText("challenge");

			return true;
		case R.id.menu_logs:

			editText.setText("logs");

			return true;
		case R.id.menu_instructions:

			editText.setText("instructions");

			return true;
		case R.id.menu_settings:

			editText.setText("settings");
			
			Intent intentUser = new Intent(PhantomRunner.this, UserInput.class);
			
			intentUser.putExtra(EXTRA_MESSAGE, R.string.menu_run);

			startActivity(intentUser);

			return true;

		case R.id.menu_unlocks:

			editText.setText("unlocks");

			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void runStart(View view)
	{
		Intent intent = new Intent(PhantomRunner.this, MapRunner.class);
		
		intent.putExtra(EXTRA_MESSAGE, R.string.menu_run);

		startActivity(intent);
	}
	
	public void runUserInput(View view)
	{
		Intent intentUser = new Intent(PhantomRunner.this, UserInput.class);
		
		intentUser.putExtra(EXTRA_MESSAGE, R.string.menu_run);

		startActivity(intentUser);
	}




}
