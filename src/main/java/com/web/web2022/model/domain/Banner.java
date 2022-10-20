package com.web.web2022.model.domain;

public class Banner {
    private Integer id;
    private String image;
    private Merchandise product = new Merchandise();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Merchandise getProduct() {
        return product;
    }

    public void setProduct(Merchandise product) {
        this.product = product;
    }
}
