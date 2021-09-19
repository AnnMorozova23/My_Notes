package com.example.my_notes.domain;

public interface Callback<T> {
    void onSuccess(T data);
}
