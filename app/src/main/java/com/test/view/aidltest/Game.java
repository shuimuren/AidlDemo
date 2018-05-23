package com.test.view.aidltest;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable{
    @Override
    public String toString() {
        return "Game{" +
                "gameName='" + gameName + '\'' +
                ", gameDescribe='" + gameDescribe + '\'' +
                '}';
    }

    private String gameName;
    private String gameDescribe;
    public Game(String gameName, String gameDescribe) {
        this.gameName = gameName;
        this.gameDescribe = gameDescribe;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.gameName);
        dest.writeString(this.gameDescribe);
    }

    public Game() {
    }

    protected Game(Parcel in) {
        this.gameName = in.readString();
        this.gameDescribe = in.readString();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel source) {
            return new Game(source);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}
