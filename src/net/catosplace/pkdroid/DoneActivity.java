package net.catosplace.pkdroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DoneActivity extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	TextView textView = new TextView(this);
    	textView.setText("This is the Done tab");
    	setContentView(textView);
    }
	
}
