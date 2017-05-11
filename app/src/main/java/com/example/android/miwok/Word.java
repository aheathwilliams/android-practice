package com.example.android.miwok;

/**
 * Created by Alex on 5/10/2017.
 */

public class Word {
    private String defaultTranslation;
    private String miwokTranslation;
    private int imageResourceId;

    public Word(String defaultWord, String miwokWord, int imageId) {
        miwokTranslation = miwokWord;
        defaultTranslation = defaultWord;
        imageResourceId = imageId;
    }

    public Word(String defaultWord, String miwokWord) {
        miwokTranslation = miwokWord;
        defaultTranslation = defaultWord;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
