package com.teamPhantomRunners.phantomrunner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class RunLogActivity extends Activity {
	
	private ApplicationPR appController; 			//Controller for global Application data

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_log);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_run_log, menu);
        appController = (ApplicationPR)getApplicationContext();
        setTextFields();
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
    
    public void setTextFields()
    {
    	Run currentRun = appController.getCurrentRun();
    	
    	((TextView)findViewById(R.id.date2_text)).setText(currentRun.getDate());
    	
    	((TextView)findViewById(R.id.dist_text)).setText(Double.toString(currentRun.getDistance()));
    	
    	String time = Integer.toString(currentRun.getTime_hours()) + ":" + 
    			Integer.toString(currentRun.getTime_min()) + ":" + 
    			Integer.toString(currentRun.getTime_sec());
    	((TextView)findViewById(R.id.time_txt)).setText(time);
    	
    	((TextView)findViewById(R.id.avgSpd_text)).setText(Double.toString(currentRun.getAverage_speed()) + " m/s");
    	
    	((TextView)findViewById(R.id.calories_text)).setText(Integer.toString(currentRun.getCalories()) + " cal");
    }

}
