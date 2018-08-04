package com.example.helloiitg;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.gt.helloiitg.R;

public class InternetSettings extends Activity implements OnItemClickListener {

	ListView listview;
	String[] classes = { "lansettings", "browsettings", "skypesettings",
			"dcsettings", "ipsettings" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(
						android.R.color.transparent)));
		setContentView(R.layout.internetsettings);
		listview = (ListView) findViewById(R.id.lvINTERNET);
		String[] items = { "LAN settings for PC", "Browser Settings",
				"Skype Settings", "DC++ Settings", "Hostel IP calculator" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, items);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent j = new Intent("com.helloiitg." + classes[arg2]);
		startActivity(j);
	}
}
