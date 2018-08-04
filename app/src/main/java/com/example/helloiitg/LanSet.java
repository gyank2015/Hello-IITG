package com.example.helloiitg;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gt.helloiitg.R;

public class LanSet extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getActionBar().setIcon(
                new ColorDrawable(getResources().getColor(
                        android.R.color.transparent)));
        setContentView(R.layout.lanset);
        TextView IPsettings = (TextView) findViewById(R.id.tvIPsettings);
        IPsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				Intent i = new Intent("com.helloiitg.ipsettings");
                startActivity(i);
            }
        });

//		MatchFilter matchFilter = new MatchFilter() {
//			public final boolean acceptMatch(CharSequence s, int start, int end) {
//				return s.toString()
//						.equals("http://www.iitg.ernet.in/interiitsports/hostelNetSettings.htm");
//			}
//		};
//
//		TransformFilter transformFilter = new TransformFilter() {
//			public final String transformUrl(final Matcher match, String url) {
//				return "http://www.iitg.ernet.in/interiitsports/hostelNetSettings.htm";
//			}
//		};
//
//		Pattern pattern = Pattern
//				.compile("http://www.iitg.ernet.in/interiitsports/hostelNetSettings.htm");
//		String scheme = "http://";
//		Linkify.addLinks(LinkPara, pattern, scheme, matchFilter,
//				transformFilter);

    }
}
