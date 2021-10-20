package com.example.languageapp.model;

public class Word {

    //Default Translation for word
    private final String mDefaultTranslation;

    // Arabic Translation for word
    private final String mArabicTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    //Audio resource id for the word
    private final int mAudioResourceId;


    // create a new word object

    public Word(String defaultTranslation, String arabicTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mArabicTranslation = arabicTranslation;
        mAudioResourceId = audioResourceId;

    }


    public Word(String defaultTranslation, String arabicTranslation, int imageResourceId,int audioResourceId) {
                mDefaultTranslation = defaultTranslation;
                mArabicTranslation = arabicTranslation;
                mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
            }

    // get the default translation of word
    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }


    // get the arabic translation for word
    public String getmArabicTranslation() {
        return mArabicTranslation;
    }


    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
         * Returns whether or not there is an image for this word.
         */
     public boolean hasImage() {
               return mImageResourceId != NO_IMAGE_PROVIDED;
            }

            //return the audio resource id of the word

            public int getmAudioResourceId(){

                return mAudioResourceId;
            }
}


