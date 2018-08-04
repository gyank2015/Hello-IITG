package com.example.helloiitg;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;
import com.gt.helloiitg.R;

public class MainActivity extends Activity {

	WebView map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(
						android.R.color.transparent)));
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		map = (WebView) findViewById(R.id.wvMap);
		map.getSettings().setBuiltInZoomControls(true);
		map.getSettings().setLoadWithOverviewMode(true);
		map.getSettings().setUseWideViewPort(true);
		map.loadUrl("file:///android_asset/map.html");

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		map.loadUrl("about:blank");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		map.loadUrl("file:///android_asset/map.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mapmenu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.mapDownload:
			Intent i = new Intent(
					Intent.ACTION_VIEW,
					Uri.parse("http://www.iitg.ac.in/aa/pages/campusmap/images/layer4.png"));
			Toast t = Toast.makeText(this, "Opening...", Toast.LENGTH_LONG);
			t.show();
			startActivity(i);
			return false;
		case R.id.about_map:
			Intent j = new Intent("com.helloiitg.about");
			startActivity(j);
			return false;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
