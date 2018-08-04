package com.example.helloiitg;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import com.gt.helloiitg.R;

public class BrowSet extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(
						android.R.color.transparent)));
		setContentView(R.layout.browset);
		
		TabHost th = (TabHost) findViewById(R.id.tabhost);
		th.setup();
		
		TabSpec ts = th.newTabSpec("tag1");
		ts.setContent(R.id.tab1);
		ts.setIndicator("Chrome");
		th.addTab(ts);
		
		ts = th.newTabSpec("tag2");
		ts.setContent(R.id.tab2);
		ts.setIndicator("Firefox");
		th.addTab(ts);
	}
}
