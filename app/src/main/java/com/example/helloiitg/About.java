package com.example.helloiitg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;

import com.gt.helloiitg.R;

import org.w3c.dom.Text;

public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		TextView tv = (TextView)findViewById(R.id.tvAboutSIL);
		tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(About.this, R.style.AlertDialogCustom));
				builder.setMessage(R.string.SIL);
				builder.setTitle("SIL OPEN FONT LICENSE Version 1.1");
				builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {

					}
				});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		TextView feedBack = (TextView) findViewById(R.id.tvSendFeedback);
		feedBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
				try {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
				} catch (android.content.ActivityNotFoundException anfe) {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
				}
			}
		});
	}
}
