package com.example.android.miwok;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    AudioManager am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
    AudioManager.OnAudioFocusChangeListener afChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        String[] defaultWords = getResources().getStringArray(R.array.default_numbers);
        String[] miwokWords = getResources().getStringArray(R.array.miwok_numbers);
        TypedArray images = getResources().obtainTypedArray(R.array.image_numbers);
        TypedArray audio = getResources().obtainTypedArray(R.array.audio_numbers);

        for (int i = 0; i < defaultWords.length; i++) {
            words.add(new Word(defaultWords[i], miwokWords[i], images.getResourceId(i, 0), audio.getResourceId(i, 0)));
        }

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word currentWord = (Word) adapterView.getItemAtPosition(i);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(NumbersActivity.this, currentWord.getAudioResourceId());
                mediaPlayer.setOnCompletionListener(completionListener);

                mediaPlayer.start();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
