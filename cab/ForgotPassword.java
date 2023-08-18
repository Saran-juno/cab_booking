package com.gtech.cab;





import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends Activity {
	EditText et1,et2,et3;
	Button b1,b2;
	MyDatabase mdb;
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.forgot);
	    et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		et3=(EditText) findViewById(R.id.editText3);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		mdb=new MyDatabase(this);
		mdb.open();
		b1.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				String username=et1.getText().toString();
				long mobile=Long.parseLong(et2.getText().toString());
				String e_mail=et3.getText().toString();
				Cursor c = mdb.getAllUser();
				if(c != null){
					while(c.moveToNext()==true)
					{ 
						String uname = c.getString(1);
						String pwd=c.getString(2);
						long mob=c.getLong(3);
						String email = c.getString(4);
						
						if(username.equals(uname)&&mobile==mob&&e_mail.equals(email))
						{
						Intent in=new Intent(getApplicationContext(),Password_Recovery.class);
						in.putExtra("p",pwd);
						in.putExtra("u",uname);
						mdb.close();
						c.close();
						startActivity(in);
						return;
						}
						else
						{
							
						}
					}
					Toast.makeText(getApplicationContext(), "Data Not Matching",0).show();
					et1.setText("");
					et2.setText("");
					et3.setText("");
					c.close();
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

}
