package com.example.helloiitg;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.text.DecimalFormat;
import java.util.Calendar;

public class BusTimings extends Activity implements View.OnClickListener ,AdapterView.OnItemSelectedListener {

    String[] ToCamp = {"6.75", "7.75", "8.25", "10", "12", "13", "14", "15", "16", "17.25", "18.75", "19.5", "20", "20.5", "20.9167"};
    String[] ToCampFri = {"6.75", "7.75", "8.25", "9", "10", "12", "13", "14", "14.5", "15", "16", "17.25", "18.75", "19.5", "20", "20.5", "20.75", "20.9167"};
    String[] ToCampHol = {"6.75", "7.75", "8.25", "10", "11", "13", "14", "15","16", "17", "18", "18.5", "19.25", "20", "20.5", "20.75","20.9167","21"};
    String[] ToCity = {"8", "9", "10", "12", "13", "14", "15", "17", "17.25", "17.667", "18.75", "20", "20.667", "21", "21.5", "21.5834"};
    String[] ToCityFri = {"8", "9", "10", "11", "12", "13", "14", "15", "17", "17.25", "17.667", "18.75", "20", "20.667", "21", "21.25", "21.5", "21.5834"};
    String[] ToCityHol ={"8", "9", "10", "10.5", "12", "13", "14", "15", "15.5", "16", "17", "17.667", "18.75", "20", "20.667", "21", "21.25", "21.5"};
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday","Sunday"};
    //Custom for Jalukbari!! Check below!!

    int pad,day=0;
    boolean CamShow = false, CitShow = false;
    Button bCam, bCit;
    LinearLayout myLayout;
    Spinner spinner;
    ScrollView scroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_WEEK);
        switch(currentDay){
            case Calendar.MONDAY:
                day = 0;
                break;
            case Calendar.TUESDAY:
                day = 1;
                break;
            case Calendar.WEDNESDAY:
                day = 2;
                break;
            case Calendar.THURSDAY:
                day = 3;
                break;
            case Calendar.FRIDAY:
                day = 4;
                break;
            case Calendar.SATURDAY:
                day = 5;
                break;
            case Calendar.SUNDAY:
                day = 6;
                break;
        }


        pad = (int) (6 * getResources().getDisplayMetrics().density + 0.5f);
        scroll = new ScrollView(this);
        myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        myLayout.setPadding(2 * pad, 2 * pad, 2 * pad, 2 * pad);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, days);
        spinner = new Spinner(this);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        myLayout.addView(spinner);
        spinner.setSelection(day);

        setUp(false,0);
        TextView blank = new TextView(this);blank.setText("");myLayout.addView(blank);
        setUp(true,0);
        TextView blank1 = new TextView(this);blank1.setText("");myLayout.addView(blank1);
        TextView Disclaimer = new TextView(this);Disclaimer.setText("*Till Jalukbari");myLayout.addView(Disclaimer);
        TextView Disclaimer2 = new TextView(this);Disclaimer2.setText("^3 buses from Sixmile, Beltola and Noonmati");myLayout.addView(Disclaimer2);
        TextView Disclaimer3 = new TextView(this);Disclaimer3.setText("#Bus Timing for Institute Holidays is same as that of Saturday and Sunday");myLayout.addView(Disclaimer3);
        scroll.addView(myLayout);
        setContentView(scroll);

    }

    //false -> to campus, true -> to city
    private void setUp(boolean to, int day) {
        CardView card = new CardView(this);
        card.setRadius(0);
        LinearLayout cardlinear = new LinearLayout(this);
        cardlinear.setOrientation(LinearLayout.VERTICAL);
        cardlinear.setPadding(pad, pad, pad, pad);

        TextView To = new TextView(this);
        if (to == false)
            To.setText("To Subansiri Hostel/Guest House");
        if (to == true)
            To.setText("To City (Pan Bazar)");
        To.setTextSize(18);
        To.setTypeface(Typeface.DEFAULT_BOLD);
        cardlinear.addView(To);

        TextView From = new TextView(this);
        if (to == false)
            From.setText("From City (Pan Bazar)");
        if (to == true)
            From.setText("From Subansiri Hostel/Guest House");
        From.setTextSize(16);
        From.setTextColor(Color.parseColor("#607D8B"));
        From.setPadding(pad * 5, 0, 0, 0);
        cardlinear.addView(From);

        //Blank
        TextView tvBlank = new TextView(this);
        tvBlank.setText("");
        cardlinear.addView(tvBlank);

        timeCam(cardlinear, to, day);

        card.addView(cardlinear);
        myLayout.addView(card);
    }

    private void timeCam(LinearLayout cardlinear, boolean to,int day) {

        Calendar c = Calendar.getInstance();
        float time = (float) c.get(Calendar.MINUTE);
        time /= 60;
        time += c.get(Calendar.HOUR_OF_DAY);

        String[] s = {};
        if (to == false) {
            if (day==4)
                s = ToCampFri;
            else if (day==5 | day==6)
                s = ToCampHol;
            else
                s = ToCamp;
        }
        if (to == true) {
            if (day==4)
                s = ToCityFri;
            else if (day==5 |day==6)
                s = ToCityHol;
            else
                s = ToCity;
        }

        int Cam = 0;
        while (Cam < s.length) {
            Float f = Float.parseFloat(s[Cam]);
            if (time <= f)
                break;
            Cam++;
        }

        int CamStringLength = s.length / 3;
        CamStringLength *= 3;
        if (s.length % 3 != 0)
            CamStringLength += 3;
        int CamRow = Cam / 3;

        TableLayout table = new TableLayout(this);
        table.setGravity(Gravity.CENTER_HORIZONTAL);
        TableRow row = new TableRow(this);


        for (int i = 0; i < CamStringLength; i++) {
            if (i % 3 == 0) {
                table.addView(row);
                row = new TableRow(this);
                row.setGravity(Gravity.CENTER_HORIZONTAL);
                if (to == false)
                    if (CamShow == false)
                        row.setVisibility(View.GONE);
                if (to == true)
                    if (CitShow == false)
                        row.setVisibility(View.GONE);
                int CurrRow = i / 3;
                if ((CurrRow == CamRow) | (CurrRow == CamRow + 1))
                    row.setVisibility(View.VISIBLE);
            }

            TextView tvTime = new TextView(this);
            tvTime.setTextSize(16);
            tvTime.setGravity(Gravity.CENTER_HORIZONTAL);
            tvTime.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT,1.0f));
            tvTime.setTextColor(Color.parseColor("#757575"));

            if (i < s.length) {
                if (s[i].equals("21.25") && s[i].equals("21.5") && s[i].equals("21.5834"))
                    tvTime.setText(ToFormatTime(s[i]) + "*");
                else if(s[i].equals("7.75") & ((c.get(Calendar.DAY_OF_WEEK)>=2) & (c.get(Calendar.DAY_OF_WEEK)<=6)))
                    tvTime.setText(ToFormatTime(s[i]) + "^");
                else
                    tvTime.setText(ToFormatTime(s[i]));
            }

            if (i == Cam) {
                tvTime.setTypeface(Typeface.DEFAULT_BOLD);
                tvTime.setTextSize(18);
                tvTime.setTextColor(Color.BLACK);
            }

            row.addView(tvTime);
        }
        table.addView(row);

        cardlinear.addView(table);

        if (to == false) {
            bCam = new Button(this);
            if (CamShow == false)
                bCam.setText("SHOW ALL");
            else
                bCam.setText("SHOW CURRENT");
            bCam.setId(0 + 123);
            bCam.setTextColor(Color.parseColor("#009688"));
            bCam.setBackgroundColor(Color.TRANSPARENT);
            bCam.setOnClickListener(this);
            cardlinear.addView(bCam);
        }

        if (to == true) {
            bCit = new Button(this);
            if (CitShow == false)
                bCit.setText("SHOW ALL");
            else
                bCit.setText("SHOW CURRENT");
            bCit.setId(0 + 124);
            bCit.setTextColor(Color.parseColor("#009688"));
            bCit.setBackgroundColor(Color.TRANSPARENT);
            bCit.setOnClickListener(this);
            cardlinear.addView(bCit);
        }
    }

    private String ToFormatTime(String s) {
        String time = "";
        float f = Float.parseFloat(s);
        DecimalFormat formatter = new DecimalFormat("00");
        if (f <= 12) {
            int hour = (int) f;
            int minutes = (int) ((f - hour) * 60);
            if (f < 12)
                time += formatter.format(hour) + ":" + formatter.format(minutes) + " AM";
            if (f == 12)
                time += formatter.format(hour) + ":" + formatter.format(minutes) + " PM";

        } else {
            int hour = (int) f;
            hour -= 12;
            int minutes = (int) ((f - hour - 12) * 60);
            time += formatter.format(hour) + ":" + formatter.format(minutes) + " PM";
        }
        return time;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case 123:
                CamShow = !CamShow;
//                if (CamShow == false)
//                    CamShow = true;
//                else
//                    CamShow = false;
                break;
            case 124:
                CitShow = !CitShow;
//                if (CitShow == false)
//                    CitShow = true;
//                else
//                    CitShow = false;
                break;
        }

        refreshContent(true);
    }

    private void refreshContent(boolean ifRetainShow) {
        myLayout.removeAllViews();

        if(!ifRetainShow){
            CamShow = false;
            CitShow = false;
        }
        spinner.setSelection(day);

        myLayout.addView(spinner);
        setUp(false, day);
        TextView blank = new TextView(this);blank.setText("");myLayout.addView(blank);
        setUp(true, day);
        TextView blank1 = new TextView(this);blank1.setText("");myLayout.addView(blank1);
        TextView Disclaimer = new TextView(this);Disclaimer.setText("*Till Jalukbari");myLayout.addView(Disclaimer);
        TextView Disclaimer2 = new TextView(this);Disclaimer2.setText("^3 buses from Sixmile, Beltola and Noonmati");myLayout.addView(Disclaimer2);
        TextView Disclaimer3 = new TextView(this);Disclaimer3.setText("#Bus timing for institute holidays is same as that of Saturday and Sunday");myLayout.addView(Disclaimer3);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        day=i;
        refreshContent(false);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        day=0;
    }
}