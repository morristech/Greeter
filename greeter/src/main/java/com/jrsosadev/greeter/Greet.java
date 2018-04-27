package com.jrsosadev.greeter;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class Greet implements Parcelable {

    private String title, subtitle, imgUrl;

    public Greet(String title, String subtitle, String imgUrl) {
        this.title = title;
        this.subtitle = subtitle;
        this.imgUrl = imgUrl;
    }

    protected Greet(Parcel in) {
        title = in.readString();
        subtitle = in.readString();
        imgUrl = in.readString();
    }

    public static final Creator<Greet> CREATOR = new Creator<Greet>() {
        @Override
        public Greet createFromParcel(Parcel in) {
            return new Greet(in);
        }

        @Override
        public Greet[] newArray(int size) {
            return new Greet[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public void validate() {
        if (TextUtils.isEmpty(title))
            throw new IllegalArgumentException("Title must have value");

        if (TextUtils.isEmpty(subtitle))
            throw new IllegalArgumentException("SubTitle must have value");


        if (TextUtils.isEmpty(imgUrl))
            throw new IllegalArgumentException("An image url was not supplied.");

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeString(imgUrl);
    }
}
