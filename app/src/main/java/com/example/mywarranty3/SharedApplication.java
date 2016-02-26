package com.example.mywarranty3;

import android.app.Application;
import android.content.Context;

import com.example.mywarranty3.model.Token;
import com.example.mywarranty3.model.User;

/**
 * Created by ramizm_2 on 2015-11-28.
 */
public class SharedApplication extends Application {

    private User currentUser;
    private Token currentToken;
    private static SharedApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static SharedApplication getInstance() {
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Token getToken() {
        return currentToken;
    }

    public void setToken(Token token) {
        this.currentToken = token;
    }
}
