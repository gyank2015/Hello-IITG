package com.example.helloiitg;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.gt.helloiitg.R;

public class ContactDetails extends Activity implements OnItemSelectedListener,
		OnClickListener {

	TextView GTitle, GName, GEmail, GPhone, GRoom, WTitle, WName, WEmail,
			WPhone, WRoom, TTitle, TName, TEmail, TPhone, TRoom, CTitle, CName, CEmail, CPhone, CRoom,
			STitle,SName,SEmail,SPhone,SRoom, Disclaimer;
	CardView GCard, WCard , TCard , CCard ,SCard;
	int position;
	Spinner spinner;
	String[] hostels = { "Select Hostel", "Barak", "Brahmaputra", "Dhansiri",
			"Dibang", "Dihing", "Kameng", "Kapili", "Lohit", "Manas", "Siang",
			"Subansiri", "Umiam" };

	String[] GNames = { "", "Uttam Singh", "Parth Gorakhiya",
			"Rutuja Dungarwal", "Pyarimohan Dehury", "Somya Parasar",
			"Mukkoti Anil Kumar", "Ishan Grover", "Saurav Chaudhary",
			"Shaurya Gupta", "Shivam Kumar", "Swati Sarkar",
			"Sarthak Triphati" };
	String[] GEmails = { "", "u.manojsingh", "parth.gorakhiya", "dungurwal", "d.pyarimohan", "s.parasar",
			"mukkoti", "ishan.grover", "chokker", "shaurya.gupta", "shivam.civ",
			"swati.sarkar", "sarthak.triphati" };
	String[] GPhones = { "", "9954247445", "8638310118", "9531126269", "7002596060", "8840409856",
			"7989593980", "9954249674", "9897492831", "7664003625", "9435664011",
			"9435083681", "7086835035" };
	String[] GRooms = { "", "B-322", "T-193", "", "H-106", "160", "B1-302","327","c-310", "A-207",
			"240", "", "A-122" };

	String[] WNames = { "", "Abhinav Paigwar", "Rohit Gupta", "Namrata Gupta", "Saikat Pal",
			"Sapavat Venkatesh", "Abhishek Kumar",
			"Arcot Yashwanth", "Subhanker Jauhari", "Chetan Manda", "Sahil Chaturvedi",
			"Deepika Bishnoi", "Anil Shyam Manohar Rathour" };
	String[] WEmails = { "", "abhinav.paigwar", "rohitmm", "namrata.gupta", "saikat.pal",
			"sapavat.venkatesh", "abhk.cse","arcot.yashwanth", "subhankerjauhari",
			"chetan.m", "c.sahil", "deepika2016", "a.rathour" };
	String[] WPhones = { "", "7577045235", "7000951251", "9424703047", "7664013288", "9954246798",
			"9430941922", "9954342050", "9401157144", "9957991877", "7972500294", "8882172228", "7664972109" };
	String[] WRooms = { "", "B-228", "G-157", "", "H-306", "231", "B1-315", "282",
			"A-017", "B-116", "225", "", "A-218" };

	String[] TNames = {"","Jithendra Roy","Vinaykumar Dubey","Nikita Tambe","Bikash Shah","Siddharth Chandan"
			,"Akshay Rao","Prateek Manocha","Pavan Kumar","Ishu Kalra","Daman Tekchandani","Shalini","Apoorva Kumar"};
	String[] TEmails = {"","aj_roy9","vinay.dubey0990","nikita.tambe","bikash.2015","siddharthchandan.1997","Akshayrao",
			"prateek.manocha","pavan71198","kalra","daman","halini19","kr17apoorva"};
	String[] TPhones = {"","9957992189","9029898438","9957956700","9863057512","9439505162","9957966927","9957940421",
			"8309329731","7571822522","9126874508","8130947907","9523595093"};
	String[] TRooms = {"","B-319","T-195","","L-302","351","B3-107","202","B-033","C-117","25","","A-251"};

	String[] CNames = {"","Chiranjiv Goyal","Tushar Yadav","Nishita Sudhir","Subrata Debnath","Pankaj Kumar",
			"Darshan Patil","Piyush Mandavi","Sahil Garhwal","D.Bedadeep","Kartikey Kant","Menan Leichombam","Vishesh Arora"};
	String[] CEmails = {"","chiranjiv","tusharyadav","nishitasudhir09","d.subrata","chandravanshi.pankaj",
			"darshanpatil1998","p.iyush_420","garhwalsahil007","pupun_bedadeep","kartikeykant","menan.lc","vishesharora100"};
	String[] CPhones = {"","8133036886","9435685762","8486798646","9957836965","9126873113","9767290647",
			"9126867055","9957997123","9957995665","7577994159","8119061552","9957999408"};
	String[] CRooms = {"","A-319","G-176","","","302","B2-024","342","A-013","C-111","59","","A-240"};

	String[] SNames ={"","Sharan Rao","Abhishek Kumar","Deepa Kumari","Anirban Bhowal","K.Uday","Yashpal Singh",
			"Subham Prasad","Tarique Sayeed","Rajat Dhanotiya","Ishan Azad","Kamakshi Manjari","Shivank Shridhar"};
	String[] SEmails={"","sharanrao","abhishek.2589","deepa.kumari","a.bhowal","udaykadavakollu","yaspal",
			"psubham1501","tarique","rajat.dhanotiya","ishan.azad","kamakshi","shivankshridhar"};
	String[] SPhones={"","8753828069","9958694992","9957954807","7086867372","9476615818","7002943057",
			"7896225209","9424275370","9957958848","9127512324","9085817933","9957987070"};
	String[] SRooms={"","B-321","T-197","","K-003","137","B3-117","211","C-105","C-115","143","","A-259"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(
						android.R.color.transparent)));
		setContentView(R.layout.contactdetails);
		initialize();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(ContactDetails.this,
				android.R.layout.simple_spinner_dropdown_item, hostels);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);

		GPhone.setOnClickListener(this);
		WPhone.setOnClickListener(this);
		TPhone.setOnClickListener(this);
		GPhone.setOnClickListener(this);
		SPhone.setOnClickListener(this);


	}

	private void initialize() {
		// TODO Auto-generated method stub
		spinner = (Spinner) findViewById(R.id.spinContact);

		GTitle = (TextView) findViewById(R.id.tvGTitle);
		GName = (TextView) findViewById(R.id.tvGName);
		GEmail = (TextView) findViewById(R.id.tvGEmail);
		GPhone = (TextView) findViewById(R.id.tvGPhone);
		GRoom = (TextView) findViewById(R.id.tvGRoom);
		WTitle = (TextView) findViewById(R.id.tvWTitle);
		WName = (TextView) findViewById(R.id.tvWName);
		WEmail = (TextView) findViewById(R.id.tvWEmail);
		WPhone = (TextView) findViewById(R.id.tvWPhone);
		WRoom = (TextView) findViewById(R.id.tvWRoom);
		TTitle = (TextView) findViewById(R.id.tvTTitle);
		TName = (TextView) findViewById(R.id.tvTName);
		TEmail = (TextView) findViewById(R.id.tvTEmail);
		TPhone = (TextView) findViewById(R.id.tvTPhone);
		TRoom = (TextView) findViewById(R.id.tvTRoom);
		CTitle = (TextView) findViewById(R.id.tvCTitle);
		CName = (TextView) findViewById(R.id.tvCName);
		CEmail = (TextView) findViewById(R.id.tvCEmail);
		CPhone = (TextView) findViewById(R.id.tvCPhone);
		CRoom = (TextView) findViewById(R.id.tvCRoom);
		STitle = (TextView) findViewById(R.id.tvSTitle);
		SName = (TextView) findViewById(R.id.tvSName);
		SEmail = (TextView) findViewById(R.id.tvSEmail);
		SPhone = (TextView) findViewById(R.id.tvSPhone);
		SRoom = (TextView) findViewById(R.id.tvSRoom);
		Disclaimer = (TextView) findViewById(R.id.tvDisclaimer);

		GCard = (CardView)findViewById(R.id.cvGen);
		WCard = (CardView)findViewById(R.id.cvWel);
		TCard = (CardView)findViewById(R.id.cvTec);
		CCard = (CardView)findViewById(R.id.cvCul);
		SCard = (CardView)findViewById(R.id.cvSpo);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
							   long arg3) {
		// TODO Auto-generated method stub
		position = pos;
		if (position != 0)
			Disclaimer.setVisibility(TextView.VISIBLE);
		else
			Disclaimer.setVisibility(TextView.GONE);

		GName.setText("Name: " + GNames[pos]);
		GEmail.setText("Email: " + GEmails[pos]);
		GPhone.setText("Phone No: " + GPhones[pos]);
		GRoom.setText("Room No: " + GRooms[pos]);
		WName.setText("Name: " + WNames[pos]);
		WEmail.setText("Email: " + WEmails[pos]);
		WPhone.setText("Phone No: " + WPhones[pos]);
		WRoom.setText("Room No: " + WRooms[pos]);
		TName.setText("Name: " + TNames[pos]);
		TEmail.setText("Email: " + TEmails[pos]);
		TPhone.setText("Phone No: " + TPhones[pos]);
		TRoom.setText("Room No: " + TRooms[pos]);
		CName.setText("Name: " + CNames[pos]);
		CEmail.setText("Email: " + CEmails[pos]);
		CPhone.setText("Phone No: " + CPhones[pos]);
		CRoom.setText("Room No: " + CRooms[pos]);
		SName.setText("Name: " + SNames[pos]);
		SEmail.setText("Email: " + SEmails[pos]);
		SPhone.setText("Phone No: " + SPhones[pos]);
		SRoom.setText("Room No: " + SRooms[pos]);


		if (!GNames[pos].contentEquals("")) {
			GCard.setVisibility(CardView.VISIBLE);
			GTitle.setVisibility(TextView.VISIBLE);
			GName.setVisibility(TextView.VISIBLE);
			GEmail.setVisibility(TextView.VISIBLE);
		} else {
			GCard.setVisibility(CardView.GONE);
			GTitle.setVisibility(TextView.GONE);
			GName.setVisibility(TextView.GONE);
			GEmail.setVisibility(TextView.GONE);
		}

		if (!WNames[pos].contentEquals("")) {
			WCard.setVisibility(CardView.VISIBLE);
			WTitle.setVisibility(TextView.VISIBLE);
			WName.setVisibility(TextView.VISIBLE);
			WEmail.setVisibility(TextView.VISIBLE);
		} else {
			WCard.setVisibility(CardView.GONE);
			WTitle.setVisibility(TextView.GONE);
			WName.setVisibility(TextView.GONE);
			WEmail.setVisibility(TextView.GONE);
		}

		if (!TNames[pos].contentEquals("")) {
			TCard.setVisibility(CardView.VISIBLE);
			TTitle.setVisibility(TextView.VISIBLE);
			TName.setVisibility(TextView.VISIBLE);
			TEmail.setVisibility(TextView.VISIBLE);
		} else {
			TCard.setVisibility(CardView.GONE);
			TTitle.setVisibility(TextView.GONE);
			TName.setVisibility(TextView.GONE);
			TEmail.setVisibility(TextView.GONE);
		}

		if (!CNames[pos].contentEquals("")) {
			CCard.setVisibility(CardView.VISIBLE);
			CTitle.setVisibility(TextView.VISIBLE);
			CName.setVisibility(TextView.VISIBLE);
			CEmail.setVisibility(TextView.VISIBLE);
		} else {
			CCard.setVisibility(CardView.GONE);
			CTitle.setVisibility(TextView.GONE);
			CName.setVisibility(TextView.GONE);
			CEmail.setVisibility(TextView.GONE);
		}
		if (!SNames[pos].contentEquals("")) {
			SCard.setVisibility(CardView.VISIBLE);
			STitle.setVisibility(TextView.VISIBLE);
			SName.setVisibility(TextView.VISIBLE);
			SEmail.setVisibility(TextView.VISIBLE);
		} else {
			SCard.setVisibility(CardView.GONE);
			STitle.setVisibility(TextView.GONE);
			SName.setVisibility(TextView.GONE);
			SEmail.setVisibility(TextView.GONE);
		}


		if (!GPhones[pos].contentEquals(""))
			GPhone.setVisibility(TextView.VISIBLE);
		else
			GPhone.setVisibility(TextView.GONE);
		if (!WPhones[pos].contentEquals(""))
			WPhone.setVisibility(TextView.VISIBLE);
		else
			WPhone.setVisibility(TextView.GONE);
		if (!TPhones[pos].contentEquals(""))
			TPhone.setVisibility(TextView.VISIBLE);
		else
			TPhone.setVisibility(TextView.GONE);
		if (!CPhones[pos].contentEquals(""))
			CPhone.setVisibility(TextView.VISIBLE);
		else
			CPhone.setVisibility(TextView.GONE);
		if (!SPhones[pos].contentEquals(""))
			SPhone.setVisibility(TextView.VISIBLE);
		else
			SPhone.setVisibility(TextView.GONE);

		if (!GRooms[pos].contentEquals(""))
			GRoom.setVisibility(TextView.VISIBLE);
		else
			GRoom.setVisibility(TextView.GONE);
		if (!WRooms[pos].contentEquals(""))
			WRoom.setVisibility(TextView.VISIBLE);
		else
			WRoom.setVisibility(TextView.GONE);
		if (!TRooms[pos].contentEquals(""))
			TRoom.setVisibility(TextView.VISIBLE);
		else
			TRoom.setVisibility(TextView.GONE);
		if (!CRooms[pos].contentEquals(""))
			CRoom.setVisibility(TextView.VISIBLE);
		else
			CRoom.setVisibility(TextView.GONE);
		if (!WRooms[pos].contentEquals(""))
			WRoom.setVisibility(TextView.VISIBLE);
		else
			WRoom.setVisibility(TextView.GONE);
		if (!SRooms[pos].contentEquals(""))
			SRoom.setVisibility(TextView.VISIBLE);
		else
			SRoom.setVisibility(TextView.GONE);


	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		GTitle.setVisibility(TextView.GONE);
		GName.setVisibility(TextView.GONE);
		GEmail.setVisibility(TextView.GONE);
		GPhone.setVisibility(TextView.GONE);
		GRoom.setVisibility(TextView.GONE);
		WTitle.setVisibility(TextView.GONE);
		WName.setVisibility(TextView.GONE);
		WEmail.setVisibility(TextView.GONE);
		WPhone.setVisibility(TextView.GONE);
		WRoom.setVisibility(TextView.GONE);
		TTitle.setVisibility(TextView.GONE);
		TName.setVisibility(TextView.GONE);
		TEmail.setVisibility(TextView.GONE);
		TPhone.setVisibility(TextView.GONE);
		TRoom.setVisibility(TextView.GONE);
		CTitle.setVisibility(TextView.GONE);
		CName.setVisibility(TextView.GONE);
		CEmail.setVisibility(TextView.GONE);
		CPhone.setVisibility(TextView.GONE);
		CRoom.setVisibility(TextView.GONE);
		STitle.setVisibility(TextView.GONE);
		SName.setVisibility(TextView.GONE);
		SEmail.setVisibility(TextView.GONE);
		SPhone.setVisibility(TextView.GONE);
		SRoom.setVisibility(TextView.GONE);
		Disclaimer.setVisibility(TextView.GONE);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
			case R.id.tvGPhone:
				Intent i = new Intent(Intent.ACTION_DIAL);
				i.setData(Uri.parse("tel: +91" + GPhones[position]));
				startActivity(i);
				break;
			case R.id.tvWPhone:
				Intent j = new Intent(Intent.ACTION_DIAL);
				j.setData(Uri.parse("tel: +91" + WPhones[position]));
				startActivity(j);
				break;
			case R.id.tvTPhone:
				Intent k = new Intent(Intent.ACTION_DIAL);
				k.setData(Uri.parse("tel: +91" + TPhones[position]));
				startActivity(k);
				break;
			case R.id.tvCPhone:
				Intent l = new Intent(Intent.ACTION_DIAL);
				l.setData(Uri.parse("tel: +91" + CPhones[position]));
				startActivity(l);
				break;
			case R.id.tvSPhone:
				Intent m = new Intent(Intent.ACTION_DIAL);
				m.setData(Uri.parse("tel: +91" + CPhones[position]));
				startActivity(m);
				break;
		}
	}
}
