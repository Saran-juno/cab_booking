package com.gtech.cab;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDatabase 
{
private MyHelper mh;
private SQLiteDatabase sdb;

public MyDatabase(Context con)
{
	mh=new MyHelper(con,"UserDetails",null,1);
}
public void open()
{   try{
	sdb=mh.getWritableDatabase();
}
catch(Exception e)
{
	
}
}
public void insertRegiserUser(String Username,String password,long mobile,String e_mail) 
{
	ContentValues cv=new ContentValues();
	cv.put("uname",Username);
	cv.put("pwd",password);
	cv.put("mob", mobile);
	cv.put("email",e_mail);
    sdb.insert("login", null,cv);
}

public void updatePwd(String old_pwd,String username,String new_pwd)
{
	ContentValues cv=new ContentValues();
	cv.put("pwd",new_pwd);
	sdb.update("login", cv,"pwd=? AND uname=?",new String[]{old_pwd,username});
}

public Cursor getAllUser()
{   Cursor c=sdb.query("login",null,null,null,null,null,null);
	return c;
	
}
class MyHelper extends SQLiteOpenHelper
{ 
	

	public MyHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("Create table login(_id integer primary key, uname text unique, pwd text, mob long, email text);");
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}
public void close(){
	sdb.close();
}
}
