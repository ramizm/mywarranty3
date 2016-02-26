package com.example.mywarranty3.model;

/**
 * Created by ramizm_2 on 2015-11-26.
 */
public class Brand {

    /**
     * id : 1
     * name : LLOYD
     * tel : 123-456-7890
     * location : 서울
     * description : Gift for you
     * logoImage : https://scontent-icn1-1.xx.fbcdn.net/hprofile-xlp1/v/t1.0-1/p320x320/10603442_619451671502733_5577087642403228963_n.jpg?oh=8526af766e0ca75004ed2d066824f72d&oe=56E215B4
     * createdAt : 2015-11-26T15:09:49.437Z
     * updatedAt : 2015-11-26T15:09:49.448Z
     */

    private int id;
    private String name;
    private String tel;
    private String location;
    private String description;
    private String logoImage;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getLogoImage() {
        return logoImage;
    }

}
