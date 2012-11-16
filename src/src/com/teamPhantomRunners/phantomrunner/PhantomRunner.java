package com.teamPhantomRunners.phantomrunner;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PhantomRunner extends Activity {

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
	    
	    public void openMap(View view)
	    {
	    	Intent intent = new Intent(PhantomRunner.this, MapRunner.class);
	    	intent.putExtra("Run", "Run");
	    	
	    	startActivity(intent);
	    }
	    
	    public void runMap(View view)
	    {
	    	Intent intent = new Intent(PhantomRunner.this, MapRunner.class);
	    	intent.putExtra("Run", "Run");
	    	
	    	startActivity(intent);
	    }
	    public void timedMap(View view)
	    {
	    	Intent intent = new Intent(PhantomRunner.this, MapRunner.class);
	    	intent.putExtra("Run", "Run");
	    	
	    	startActivity(intent);
	    }
	    
    
	    
	    
	    
	    
	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        //switch (item.getItemId()) {
	          //  case 
	             //   return true;
	            //default:
	                return super.onOptionsItemSelected(item);
	        //}
	    }
	    
	    
	    
   
}
