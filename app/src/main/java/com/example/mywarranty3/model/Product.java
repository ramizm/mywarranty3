package com.example.mywarranty3.model;

/**
 * Created by ramizm_2 on 2015-11-26.
 */
public class Product {

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

    private String id;
    private int brand;
    private String name;
    private String image;
    private String description;
    private int defaultWarrantyPeriod;

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDefaultWarrantyPeriod(int defaultWarrantyPeriod) {
        this.defaultWarrantyPeriod = defaultWarrantyPeriod;
    }

    public String getId() {
        return id;
    }

    public int getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getDefaultWarrantyPeriod() {
        return defaultWarrantyPeriod;
    }
}
