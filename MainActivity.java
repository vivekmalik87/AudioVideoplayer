package com.list.music;

import com.example.mymusic.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	Button mAudio, mVideo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mAudio = (Button) findViewById(R.id.btnAudio);
		mVideo = (Button) findViewById(R.id.btnVideo);
	
		
		mAudio.setOnClickListener(this);
		mVideo.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		if(v == mAudio) {
			startActivity(new Intent(MainActivity.this, AudioList.class));
		}
		if(v == mVideo) {
			startActivity(new Intent(MainActivity.this, VideoList.class));
		}
	}
}
