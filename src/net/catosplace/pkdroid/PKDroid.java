package net.catosplace.pkdroid;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

public class PKDroid extends TabActivity {
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Change the default title
        //String title = getString(R.string.title);
        //setTitle(title);
        
        Resources res = getResources(); 	// Resource object to get Drawables
        TabHost tabHost = getTabHost();		// The activity TabHost
        TabHost.TabSpec spec;				// Reusable TabSpec for each tab
        Intent intent;						// Reusable Intent for each tab
        
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, BacklogActivity.class);
        
        // Initialise a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("backlog").setIndicator("Backlog",
        				res.getDrawable(R.drawable.ic_tab_backlog))
        			.setContent(intent);
        tabHost.addTab(spec);
        
        // Do the same for the other tabs
        intent = new Intent().setClass(this, WIPActivity.class);
        spec = tabHost.newTabSpec("wip").setIndicator("WIP",
        				res.getDrawable(R.drawable.ic_tab_wip))
        			.setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, DoneActivity.class);
        spec = tabHost.newTabSpec("done").setIndicator("Done",
        				res.getDrawable(R.drawable.ic_tab_done))
        			.setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(1);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.task_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.add_task:
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}