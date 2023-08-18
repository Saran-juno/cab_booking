package com.gtech.cab;






import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	EditText et1,et2,et3,et4,et5;
	Button b1,b2;
	MyDatabase mdb;
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.register);
	    mdb=new MyDatabase(this);
	    mdb.open();
	    et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		et3=(EditText) findViewById(R.id.editText3);
		et4=(EditText) findViewById(R.id.editText4);
		et5=(EditText) findViewById(R.id.editText5);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
	
		b1.setOnClickListener(new OnClickListener() {
	
			public void onClick(View v) {
				
				String username=et1.getText().toString();
				String password=et2.getText().toString();
				String confirm_password=et3.getText().toString();
				long mobile=Long.parseLong(et4.getText().toString());
				String email=et5.getText().toString();
				
				
				if(password.equals(confirm_password) )
				{
					mdb.insertRegiserUser(username,password,mobile,email);
					Intent in=new Intent(getApplicationContext(),Login.class);
					mdb.close();
					startActivity(in);
				
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Password not matching",Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent in=new Intent(getApplicationContext(),Login.class);
				mdb.close();
				startActivity(in);
				
			}
		});
		
	}
	@Override
	protected void onDestroy() {
		mdb.close();
		super.onDestroy();
	}

}
