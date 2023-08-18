package com.gtech.cab;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Password_Recovery extends Activity {
	EditText et1,et2;
	Button b1;
	TextView tv;
	MyDatabase mdb;
	String old_pwd,username;
	

	public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.recovery);
	 et1=(EditText) findViewById(R.id.editText1);
	 et2=(EditText) findViewById(R.id.editText2);
	 tv=(TextView) findViewById(R.id.textView1);
	 b1=(Button) findViewById(R.id.button1);
	 
	 mdb=new MyDatabase(this);
	 mdb.open();
	 Intent in=getIntent();
		Bundle b=in.getExtras();
		old_pwd=b.getString("p");
		username=b.getString("u");
	
	 tv.setText("Welcome "+username+" Enter New Password");
	 
	 b1.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			String new_pwd=et1.getText().toString();
			String confirm_pwd=et2.getText().toString();
			
			if(new_pwd.equals(confirm_pwd))
			{
			mdb.updatePwd(old_pwd,username,new_pwd);
			Intent in=new Intent(getApplicationContext(),Login.class);
			in.putExtra("key",username);
			mdb.close();
			startActivity(in);
			
			
			}
			else
			{
				et1.setText("");
				et2.setText("");
			Toast.makeText(getApplicationContext(), "Password not matching",0).show();
			}
			
		}
	});
	   
	}

}
