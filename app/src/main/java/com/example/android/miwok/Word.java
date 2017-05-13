package com.example.android.miwok;

/**
 * Created by Alex on 5/10/2017.
 */

public class Word {
    private String defaultTranslation;
    private String miwokTranslation;
    private int imageResourceId;
    private int audioResourceId;

    public Word(String defaultWord, String miwokWord, int imageId, int audioId) {
        miwokTranslation = miwokWord;
        defaultTranslation = defaultWord;
        imageResourceId = imageId;
        audioResourceId = audioId;
    }

    public Word(String defaultWord, String miwokWord, int audioId) {
        miwokTranslation = miwokWord;
        defaultTranslation = defaultWord;
        audioResourceId = audioId;
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

    public int getAudioResourceId() {
        return audioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "defaultTranslation='" + defaultTranslation + '\'' +
                ", miwokTranslation='" + miwokTranslation + '\'' +
                ", imageResourceId=" + imageResourceId +
                ", audioResourceId=" + audioResourceId +
                '}';
    }
}
