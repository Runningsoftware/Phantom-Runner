package com.teamPhantomRunners.phantomrunner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class UserInput extends Activity {
	
	private ApplicationPR appController; 			//Controller for global Application data

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        appController = (ApplicationPR)getApplicationContext();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_user_input, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void saveInput(View view)
    {
    	User tempUser = appController.getUserInfo();
    	DatabaseWorker database = appController.getDatabase();
    	
    	tempUser.set_name(((EditText)findViewById(R.id.nameInput)).getText().toString());
    	tempUser.set_email(((EditText)findViewById(R.id.emailInput)).getText().toString());
    	tempUser.set_password(((EditText)findViewById(R.id.passwordInput)).getText().toString());
    	tempUser.set_Weight(Integer.parseInt(((EditText)findViewById(R.id.weightInput)).getText().toString()));
    	int heightFt = Integer.parseInt(((EditText)findViewById(R.id.heightInputFt)).getText().toString());
    	int heightIn = Integer.parseInt(((EditText)findViewById(R.id.heightInputIn)).getText().toString());
    	tempUser.set_height(heightFt, heightIn);
    	tempUser.set_age(Integer.parseInt(((EditText)findViewById(R.id.ageInput)).getText().toString()));
    	
    	database.put_user_data(tempUser);
    	
    }

}
