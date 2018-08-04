package com.example.helloiitg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.gt.helloiitg.R;

public class Places extends Activity implements AdapterView.OnItemClickListener {

    String[] items = {"ATMs and Banks", "Food Court", "Guest House","Hostel Canteen", "Hostel Juice Center", "Hostel Stationery", "Khokha Market", "Lecture Halls", "Library", "Market Complex", "New SAC", "Sports", "Silver Dine", "Subhansiri Bus Stop", "Temporary Market", "Veg Canteen", "Viewpoint","24 hours open Restaurant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setIcon(
                new ColorDrawable(getResources().getColor(
                        android.R.color.transparent)));

        ListView view = new ListView(this);
        setContentView(view);
        ArrayAdapter<String>
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
        view.setAdapter(adapter);
        view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Resources res = getResources();
        String[] description = res.getStringArray(R.array.places_description);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(description[i]);
        builder.setTitle(items[i]);
        builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
