package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        String[] defaultWords = getResources().getStringArray(R.array.default_phrases);
        String[] miwokWords = getResources().getStringArray(R.array.miwok_phrases);

        for (int i = 0; i < defaultWords.length; i++)
            words.add(new Word(defaultWords[i], miwokWords[i]));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
