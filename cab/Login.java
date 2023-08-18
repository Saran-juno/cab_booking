package com.gtech.cab;









import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
EditText et1,et2;
Button b;
TextView tv1,tv2,tv3;
MyDatabase mdb;
int count=1;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		tv1=(TextView) findViewById(R.id.textView1);
		tv2=(TextView) findViewById(R.id.textView2);
		tv3=(TextView) findViewById(R.id.textView3);
		b=(Button) findViewById(R.id.button1);
		
		mdb = new MyDatabase(this);
		mdb.open();
		
		
		b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				String username=et1.getText().toString();
				String password=et2.getText().toString();
				
				Cursor c = mdb.getAllUser();
				
				if(c != null){
					while(c.moveToNext()==true)
					{   int id=c.getInt(0);
						String uname = c.getString(1);
						String pwd = c.getString(2);
						long mob=c.getLong(3);
						String email = c.getString(4);
						
						//Toast.makeText(getApplicationContext(),""+id+","+uname+","+pwd+","+mob+","+email,0).show();
						
						if(count<=3)
						{
							
						if(username.equals(uname)&&password.equals(pwd))
						{
						Intent in=new Intent(getApplicationContext(),Place.class);
						in.putExtra("key",uname);
						
						mdb.close();
						c.close();
						startActivity(in);
						
						return;
						}
						else
						{
							
						}
						}
						else
						{
							Toast.makeText(getApplicationContext(), "Account Blocked",0).show();	
						}
						
					}
				
				}
				
			}
		});
tv1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in=new Intent(getApplicationContext(),Register.class);
				mdb.close();
			    startActivity(in);
				
			}
		});
tv2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		Intent in=new Intent(getApplicationContext(),ForgotPassword.class);
		mdb.close();
		startActivity(in);
		
	}
});
	}
	@Override
		protected void onDestroy() {
			mdb.close();
			Toast.makeText(getApplicationContext(), "destroyed",0).show();
			super.onDestroy();
		}

}




