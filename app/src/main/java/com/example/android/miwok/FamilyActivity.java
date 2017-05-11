package com.example.android.miwok;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        String[] defaultWords = getResources().getStringArray(R.array.default_family);
        String[] miwokWords = getResources().getStringArray(R.array.miwok_family);
        TypedArray images = getResources().obtainTypedArray(R.array.image_family);


        for (int i = 0; i < defaultWords.length; i++) {
            words.add(new Word(defaultWords[i], miwokWords[i], images.getResourceId(i, 0)));
        }

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
