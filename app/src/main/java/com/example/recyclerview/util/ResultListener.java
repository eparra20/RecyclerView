package com.example.recyclerview.util;

public interface ResultListener<T> {
    public void onFinish(T result);
    public void onError(String message);
}
