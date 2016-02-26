package com.example.mywarranty3.util;

import android.util.Log;

import com.example.mywarranty3.SharedApplication;
import com.example.mywarranty3.model.Token;
import com.example.mywarranty3.model.User;
import com.example.mywarranty3.model.UserWarranty;
import com.example.mywarranty3.model.Warranty;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by ramizm_2 on 2015-11-28.
 */
public class ApiCaller {

    private static AsyncHttpClient client = new AsyncHttpClient();

    static {
        client.setLoggingEnabled(true);
    }

    private static String getAccessToken() {
        Token token = SharedApplication.getInstance().getToken();
        if (token != null) {
            return token.getAccess_token();
        }
        return "";
    }

    public static void authenticate(String username, String password, final Callback<Token> callback) {
        String url = "http://mywarranty.elasticbeanstalk.com/auth/";

        try {
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("username", username);
            jsonParams.put("password", password);
            StringEntity entity = new StringEntity(jsonParams.toString());
            client.post(SharedApplication.getInstance(), url, entity, "application/json", new TextHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    Gson gson = new Gson();
                    Token token = gson.fromJson(responseString, Token.class);
                    callback.onSuccess(token);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    callback.onFailure();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void getUserData(int id, final Callback<User> callback) {
        String url = String.format("http://mywarranty.elasticbeanstalk.com/user/%d/warranties?access_token=%s", id, getAccessToken());

        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                User user = gson.fromJson(responseString, User.class);
                callback.onSuccess(user);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                callback.onFailure();
            }
        });
    }

    public static void addWarranty(User user, String warrantyId, final Callback<Boolean> callback) {
        String url = String.format("http://mywarranty.elasticbeanstalk.com/user/%d?access_token=%s", user.getId(), getAccessToken());

        RequestParams params = new RequestParams();

        List<String> updatingWarrantyList = new ArrayList<>();
        List<UserWarranty> warranties = user.getWarranties();

        StringBuilder builder = new StringBuilder().append("{ \"warranties\" : [");
        if (warranties != null) {
            for (UserWarranty userWarranty : warranties) {
                builder.append("\"").append(userWarranty.getId()).append("\",");
            }
        }

        builder.append("\"").append(warrantyId).append("\"]}");

        try {
            StringEntity entity = new StringEntity(builder.toString());
            client.put(SharedApplication.getInstance(), url, entity, "application/json", new TextHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    callback.onSuccess(true);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    Log.e("ApiCaller", responseString);
                    callback.onFailure();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            callback.onFailure();
        }
    }


    public static void getWarranty(String warrantyId, final Callback<Warranty> callback) {
        String url = String.format("http://mywarranty.elasticbeanstalk.com/warranty/%s?access_token=%s", warrantyId, getAccessToken());

        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                Warranty warranty = gson.fromJson(responseString, Warranty.class);
                callback.onSuccess(warranty);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                callback.onFailure();
            }
        });
    }

    public static void addUser(String username, String password, String email, final Callback<User> callback) {
        String url = "http://mywarranty.elasticbeanstalk.com/user/";

        try {
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("username", username);
            jsonParams.put("password", password);
            jsonParams.put("email", email);
            StringEntity entity = new StringEntity(jsonParams.toString());
            client.post(SharedApplication.getInstance(), url, entity, "application/json", new TextHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    Gson gson = new Gson();
                    User user = gson.fromJson(responseString, User.class);
                    callback.onSuccess(user);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    callback.onFailure();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteWarranty(String warrantyId){
        String url = String.format("http://mywarranty.elasticbeanstalk.com/warranty/%s?access_token=%s", warrantyId, getAccessToken());

        client.delete(url, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }
        });
    }
}
