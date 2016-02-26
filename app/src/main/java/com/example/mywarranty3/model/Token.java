package com.example.mywarranty3.model;

/**
 * Created by ramizm_2 on 2015-11-28.
 */
public class Token {

    /**
     * user : 1
     * expiredAt : 2015-12-05T05:48:09.671Z
     * access_token : b84ca678237262bbf979907ace46f63b91e801b9a82e6f83073c58b43f533a29
     */

    private int user;
    private String expiredAt;
    private String access_token;

    public void setUser(int user) {
        this.user = user;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getUser() {
        return user;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public String getAccess_token() {
        return access_token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "user=" + user +
                ", expiredAt='" + expiredAt + '\'' +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}
