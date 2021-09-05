package com.example.my_notes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Note implements Parcelable {

    protected Note(Parcel in) {
        name = in.readInt();
        description = in.readInt();
        createData = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getCreateData() {
        return createData;
    }

    public void setCreateData(int createData) {
        this.createData = createData;
    }

    @StringRes
    private int name;

    @StringRes
    private int description;

    private int createData;

    public Note(int name) {
        this.name = name;
        this.description = description;
        this.createData = createData;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(name);
        parcel.writeInt(description);
        parcel.writeInt(createData);
    }
}
