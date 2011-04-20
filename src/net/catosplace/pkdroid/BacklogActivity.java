package net.catosplace.pkdroid;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class BacklogActivity extends Activity {

	protected TaskData taskData;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	taskData = new TaskData(this);
    	
    	if (taskData.count() == 0) {
    	
    		TextView textView = new TextView(this);
    		textView.setText("This is the Backlog tab");
    		setContentView(textView);
    	
    	} else {
    		
            Cursor cursor = taskData.all(this);
            SimpleCursorAdapter taskCursorAdapter = 
            	new SimpleCursorAdapter(this,
            			R.layout.task_list_item,
            			cursor,
            			new String[] { TaskData.TASK },
            			new int[] { R.id.task_name }
            	);
            
    		ListView listView = new ListView(this);
    		listView.setAdapter(taskCursorAdapter);
    		setContentView(listView);
    	
    	}
    }
}
