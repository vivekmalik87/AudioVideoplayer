package com.list.music;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymusic.R;

public class AudioAdapter extends SimpleCursorAdapter{

// THIS FUNCTION will give the details of the file like display name, title, duration
	public AudioAdapter(Context context, int layout, Cursor c) {
		super(context, layout, c,new String[] { MediaStore.MediaColumns.DISPLAY_NAME},
                new int[] { R.id.textView1});
	}
	
	
// Retrieved data from the returned cursor is retrieved here and is set in the list which is displayed
	 @Override
     public void bindView(View view, Context context, Cursor cursor) {
             TextView name = (TextView)view.findViewById(R.id.textView1);
             name.setText(cursor.getString(
                             cursor.getColumnIndex(MediaStore.MediaColumns.DISPLAY_NAME)));
             view.setTag(cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA)));
     }

	 // This function is responsible for seting the UI for Custom list as activity_musiclist is attached here.
     @Override
     public View newView(Context context, Cursor cursor, ViewGroup parent) {
             LayoutInflater inflater = LayoutInflater.from(context);
             View v = inflater.inflate(R.layout.activity_musiclist, parent, false);
             
             bindView(v, context, cursor);
             
             return v;
     }

}
