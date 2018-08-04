package com.example.helloiitg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Taxi extends Activity implements OnClickListener {

	String[] titles = { "OLA Cabs", "Green Cab", "Mini Taxi", "Pristine Cabs",
			"Swiss Cabs", "MyTaxi", "Prime Cabs", "Assam On Wheels",
			"Cherry Cabs", "Elite Cab", "Geo Cabs Northeast", "Highway Cabs",
			"My Trip Mate", "R.T. Cab", "Taxi Guide", "Xcell cabs" };
	String[] phones = { "+91 02233553355", "+91 361 7 15 15 15",
			"+91 361 263 8888", "+91 361 7 18 18 18", "+91 96 13 13 13 13",
			"+91 361 222 8888", "+91 361 2222233", "+91 9435192570",
			"+91 8876222288", "+91 9707266966", "+91 361 222 2727",
			"+91 8011991101", "+91 9435338100", "+91 361 222 8822",
			"+91 88802 34455", "+91 97070 97070" };
	String[] fares = { "14", "15", "15", "17", "17", "18", "18" };
	String[] websites = { "https://www.olacabs.com/car-rentals/guwahati",
			"http://7151515.com/PriceList.aspx",
			"http://www.minitaxi.in/support.html",
			"http://www.pristinecabs.com/fares.php", "http://bit.ly/1elwnnV",
			"http://mytaxitrip.com/fare.html",
			"http://www.primecabz.com/fares.php",
			"http://www.assamonwheels.com/", "http://bit.ly/1LJBKf0",
			"http://bit.ly/1FU7W6Y", "http://geocabsnortheast.webs.com/",
			"http://bit.ly/1dzQRZt", "http://bit.ly/1H2CJCG",
			"http://rtcab.com/",
			"http://www.taxiguide.in/TourPackages/Guwahati_Car_Rental.aspx",
			"http://www.xcellcabs.com/Rate.html" };

	ScrollView scroll;
    CardView card;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//getActionBar().setIcon(
				//new ColorDrawable(getResources().getColor(
				//		android.R.color.transparent)));
		setUpLayout();
		setContentView(scroll);
	}

	private void setUpLayout() {
		// TODO Auto-generated method stub

		LinearLayout myLayout = new LinearLayout(this);
		myLayout.setOrientation(LinearLayout.VERTICAL);
		int pad = (int) (6 * getResources().getDisplayMetrics().density + 0.5f);
		myLayout.setPadding(2*pad, 2*pad, 2*pad, 2*pad);

		for (int i = 0; i < 16; i++) {

            LinearLayout cardlinear = new LinearLayout(this);
            cardlinear.setOrientation(LinearLayout.VERTICAL);
            cardlinear.setPadding(pad, pad, pad, pad);

            card = new CardView(this);
            card.setRadius(0);
            card.addView(cardlinear);
            myLayout.addView(card);

			if (i == 6) {
                TextView space = new TextView(this);
                space.setText("");
                myLayout.addView(space);

				TextView ptitle = new TextView(this);
				ptitle.setText("Package Based Cabs");
				ptitle.setTypeface(Typeface.DEFAULT_BOLD);
				ptitle.setGravity(Gravity.CENTER_HORIZONTAL);
				ptitle.setTextSize(20);
				myLayout.addView(ptitle);
			}

			TextView title = new TextView(this);
			title.setText(titles[i]);
			title.setTypeface(Typeface.DEFAULT_BOLD);
			title.setTextSize(18);
			cardlinear.addView(title);

			TextView phone = new TextView(this);
			phone.setText("Phone No: " + phones[i]);
			phone.setTextSize(16);
			phone.setTextColor(Color.parseColor("#009688"));
			phone.setPadding(pad * 5, 0, 0, 0);
			phone.setOnClickListener(this);
			phone.setId(i + 100);
			cardlinear.addView(phone);

			if (i < 7) {
				TextView fare = new TextView(this);
				fare.setText("Fare: Rs. " + fares[i] + "/km");
				fare.setTextSize(16);
				fare.setPadding(pad * 5, 0, 0, 0);
				cardlinear.addView(fare);
			}

			TextView website = new TextView(this);
			website.setText("Website");
			website.setTextSize(16);
			website.setTextColor(Color.parseColor("#009688"));
			website.setPadding(pad * 5, 0, 0, 0);
			website.setOnClickListener(this);
			website.setId(i + 200);
			cardlinear.addView(website);

            TextView space = new TextView(this);
            myLayout.addView(space);
			
			if(i>=7){
                card.setCardBackgroundColor(Color.rgb(225,225,225));
			}
		}

		scroll = new ScrollView(this);
		scroll.addView(myLayout);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
		if (id < 200) {
			id -= 100;
			Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
					+ phones[id]));
			startActivity(i);
		} else {
			id -= 200;
			Intent j = new Intent(Intent.ACTION_VIEW, Uri.parse(websites[id]));
			startActivity(j);
		}
	}
}
