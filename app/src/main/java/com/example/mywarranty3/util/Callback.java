package com.example.mywarranty3.util;

/**
 * Created by ramizm_2 on 2015-11-28.
 */
public interface Callback<T> {
    void onSuccess(T result);;
    void onFailure();
}
