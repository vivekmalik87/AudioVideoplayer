package com.list.music;

import java.io.File;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ListView;

import com.example.mymusic.R;

public class VideoList extends ListActivity {

	ListView mList;
	private String currentFile = "";
	private VideoAdapter mVideoAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitivty_list);

		Cursor cursor = getContentResolver().query(
				MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null,
				null);
		if (null != cursor) {
			cursor.moveToFirst();
			mVideoAdapter = new VideoAdapter(VideoList.this,
					R.layout.activity_musiclist, cursor);
			setListAdapter(mVideoAdapter);
		}
	}

	@Override
	protected void onListItemClick(ListView list, View view, int position,
			long id) {
		super.onListItemClick(list, view, position, id);

		// IT will Return the Data of the type of the song to be played as its
		// setTag method is called in adapter
		currentFile = (String) view.getTag();
		startPlay(currentFile);
	}

	// Function for playing the VIDEO FILE BY DEFAULT ANDROID PLAYER
	private void startPlay(String mCurrentFile) {

		Intent intent = new Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		File file = new File(mCurrentFile);
		intent.setDataAndType(Uri.fromFile(file), "video/*");
		startActivity(intent);

	}

}
