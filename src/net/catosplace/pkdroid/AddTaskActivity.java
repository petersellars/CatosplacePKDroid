package net.catosplace.pkdroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddTaskActivity extends Activity
	implements OnClickListener {

	/** Properties **/
	protected EditText taskName;
	protected Button done;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_task);
		
		// Connect interface elements to properties
		taskName = (EditText) findViewById(R.id.task_name);
		done = (Button) findViewById(R.id.done);
		
		// Set up click listeners
		done.setOnClickListener(this);
	}

	public void onClick(View view) {
		if (view == done) {
			TaskData taskData = new TaskData(this);
			taskData.insert(taskName.getText().toString(), 0);
			taskData.close();
			finish();
		}
	}
}
