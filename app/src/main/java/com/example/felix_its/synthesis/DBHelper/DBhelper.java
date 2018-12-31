package com.example.felix_its.synthesis.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "task.sqlite";  //made constant
    private static final int DB_VERSION = 1;
    private static final String TABLE = "task";
    private static final String ID = "id";
    private static final String TASK_NAME = "name";

    private static final String ROOM = "room";
    private static final String APPLIANCE = "appliance";

    private  static  final  String TIME="time";


    public DBhelper(Context context) {    //
        super( context, DB_NAME, null, DB_VERSION );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " create table " + TABLE
                +  "  ( " + ID + " integer primary key autoincrement , "

                + TASK_NAME + " name ,  " + ROOM  + " room , " + APPLIANCE + " appliance, " + TIME + " time)";
        Log.e( " DBQuery " , "==========" + query );
        db.execSQL( query );

    }

    public boolean addTask(Task task) {//database get
        SQLiteDatabase db = getWritableDatabase( );
        ContentValues values = new ContentValues( );

        values.put( TASK_NAME, task.getName( ) );
        values.put( ROOM, task.getRoom( ) );
        values.put( APPLIANCE, task.getAppliance( ) );
        values.put(TIME,task.getTime());

        long no = db.insert( TABLE, null, values );
        if (no == 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<Task> getAllTask() {
        List<Task> tasks = new ArrayList<>( );
        SQLiteDatabase db = getReadableDatabase( );

        String query = "select * from " + TABLE;
        Cursor cursor = db.rawQuery( query, null );
        while (cursor.moveToNext( )) {
            int id = cursor.getInt( cursor.getColumnIndex( ID ) );
            String name = cursor.getString( cursor.getColumnIndex( TASK_NAME) );
            String room = cursor.getString( cursor.getColumnIndex( ROOM) );
            String appliance = cursor.getString( cursor.getColumnIndex( APPLIANCE) );
            String time=cursor.getString(cursor.getColumnIndex(TIME));




            Task task = new Task(name,room,appliance,time);
            task.setId(id);
            tasks.add(task);
        }
        if (cursor != null && !cursor.isClosed( )) {
            cursor.close( );
        }
        db.close();
        return tasks;
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
