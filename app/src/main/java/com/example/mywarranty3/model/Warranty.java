package com.example.mywarranty3.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ramizm_2 on 2015-11-30.
 */
public class Warranty {

    /**
     * id : LPP15002G
     * brand : 1
     * name : ROSETTE
     * image : http://image.lloydgift.com/Product/201501/LPP15002G_1_396.jpg
     * description : 중량	약 1.30g
     제조국: 베트남
     * defaultWarrantyPeriod : 365
     * createdAt : 2015-11-28T07:34:31.077Z
     * updatedAt : 2015-11-28T07:34:31.077Z
     */

    private Product product;
    /**
     * id : 1
     * name : LLOYD
     * tel : 123-456-7890
     * location : 서울
     * description : Gift for you
     * logoImage : https://scontent-icn1-1.xx.fbcdn.net/hprofile-xlp1/v/t1.0-1/p320x320/10603442_619451671502733_5577087642403228963_n.jpg?oh=8526af766e0ca75004ed2d066824f72d&oe=56E215B4
     * createdAt : 2015-11-28T07:34:31.005Z
     * updatedAt : 2015-11-28T07:34:31.017Z
     */

    private Brand brand;
    /**
     * id : 1
     * username : root
     * email : agsd@gmail.com
     * createdAt : 2015-11-28T07:34:30.968Z
     * updatedAt : 2015-11-28T09:44:24.414Z
     */

    private OwnerEntity owner;
    /**
     * product : {"id":"LPP15002G","brand":1,"name":"ROSETTE","image":"http://image.lloydgift.com/Product/201501/LPP15002G_1_396.jpg","description":"중량\t약 1.30g\n제조국: 베트남","defaultWarrantyPeriod":365,"createdAt":"2015-11-28T07:34:31.077Z","updatedAt":"2015-11-28T07:34:31.077Z"}
     * brand : {"id":1,"name":"LLOYD","tel":"123-456-7890","location":"서울","description":"Gift for you","logoImage":"https://scontent-icn1-1.xx.fbcdn.net/hprofile-xlp1/v/t1.0-1/p320x320/10603442_619451671502733_5577087642403228963_n.jpg?oh=8526af766e0ca75004ed2d066824f72d&oe=56E215B4","createdAt":"2015-11-28T07:34:31.005Z","updatedAt":"2015-11-28T07:34:31.017Z"}
     * owner : {"id":1,"username":"root","email":"agsd@gmail.com","createdAt":"2015-11-28T07:34:30.968Z","updatedAt":"2015-11-28T09:44:24.414Z"}
     * id : APXAVN2572
     * sellerName : LLOYD 동대점
     * sellerTel : 010-316-3624
     * sellerLocation : 충무로
     * memo : 방문구매
     * purchaseDate : 2015-11-26T13:19:03.517Z
     * expirationDate : 2016-11-26T13:19:03.517Z
     * createdAt : 2015-11-28T07:34:31.098Z
     * updatedAt : 2015-11-28T09:44:24.404Z
     */

    private String id;
    private String sellerName;
    private String sellerTel;
    private String sellerLocation;
    private String memo;
    private String purchaseDate;
    private String expirationDate;
    private String createdAt;
    private String updatedAt;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setSellerTel(String sellerTel) {
        this.sellerTel = sellerTel;
    }

    public void setSellerLocation(String sellerLocation) {
        this.sellerLocation = sellerLocation;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Product getProduct() {
        return product;
    }

    public Brand getBrand() {
        return brand;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public String getId() {
        return id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerTel() {
        return sellerTel;
    }

    public String getSellerLocation() {
        return sellerLocation;
    }

    public String getMemo() {
        return memo;
    }

    public Date getPurchaseDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            return dateFormat.parse(purchaseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date getExpirationDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            return dateFormat.parse(expirationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public static class OwnerEntity {
        private int id;
        private String username;
        private String email;
        private String createdAt;
        private String updatedAt;

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
    }
}
