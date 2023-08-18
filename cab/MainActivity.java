package com.gtech.cab;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView t1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t1=(TextView)findViewById(R.id.textView1);
		Thread mt=new Thread()
		{
			public void run()
			{
				try
				{
					sleep(6000);
					Intent i=new Intent(getApplicationContext(),Login.class);
					startActivity(i);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		mt.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
