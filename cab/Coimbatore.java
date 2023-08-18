package com.gtech.cab;

import java.util.ArrayList;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Coimbatore extends Activity {
	
	Button b1;
	ListView lv;
	ArrayList<String>al;
	ArrayAdapter<String>aa;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coimbatore);
		
		b1=(Button)findViewById(R.id.button1);
		lv=(ListView)findViewById(R.id.listView1);
		al=new ArrayList<String>();
		aa=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,al);
		lv.setAdapter(aa);
		al.add("OLA");
		al.add("PINK TAXI");
		al.add("RED TAXI");
		al.add("FRIENDS TRACK");
		al.add("GO TAXI");
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				switch (position) {
				case 0:
					Intent in1 = new Intent(getApplicationContext(),Cbeola.class);
					startActivity(in1);
					break;
				case 1:
					Intent in2 = new Intent(getApplicationContext(),Cbepinktaxi.class);
					startActivity(in2);
					break;
				case 2:
					Intent in3 = new Intent(getApplicationContext(),Cberedtaxi.class);
					startActivity(in3);
					break;
				case 3:
					Intent in4 = new Intent(getApplicationContext(),Cbefriendstrack.class);
					startActivity(in4);
					break;
				case 4:
					Intent in5 = new Intent(getApplicationContext(),Cbegotaxi.class);
					startActivity(in5);
					break;

				default:
					break;
				}
				
			}
		});
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent(getApplicationContext(),Place.class);
				startActivity(in);
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.coimbatore, menu);
		return true;
	}

}
