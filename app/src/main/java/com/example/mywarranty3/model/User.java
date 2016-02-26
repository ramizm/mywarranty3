package com.example.mywarranty3.model;

import java.util.List;

/**
 * Created by ramizm_2 on 2015-11-26.
 */
public class User {


    /**
     * warranties : [{"id":"APXAVN2572","product":"1_LPP15002G","sellerName":"LLOYD 동대점","sellerTel":"010-316-3624","sellerLocation":"충무로","memo":"방문구매","purchaseDate":"2015-11-26T13:19:03.517Z","expirationDate":"2016-11-26T13:19:03.517Z","createdAt":"2015-11-26T15:09:49.525Z","updatedAt":"2015-11-28T05:55:18.517Z","owner":1}]
     * id : 1
     * username : root
     * email : agsd@gmail.com
     * createdAt : 2015-11-26T15:09:49.404Z
     * updatedAt : 2015-11-28T05:55:18.534Z
     */

    private int id;
    private String username;
    private String email;
    private String createdAt;
    private String updatedAt;
    /**
     * id : APXAVN2572
     * product : 1_LPP15002G
     * sellerName : LLOYD 동대점
     * sellerTel : 010-316-3624
     * sellerLocation : 충무로
     * memo : 방문구매
     * purchaseDate : 2015-11-26T13:19:03.517Z
     * expirationDate : 2016-11-26T13:19:03.517Z
     * createdAt : 2015-11-26T15:09:49.525Z
     * updatedAt : 2015-11-28T05:55:18.517Z
     * owner : 1
     */

    private List<UserWarranty> warranties;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setWarranties(List<UserWarranty> warranties) {
        this.warranties = warranties;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public List<UserWarranty> getWarranties() {
        return warranties;
    }

}
