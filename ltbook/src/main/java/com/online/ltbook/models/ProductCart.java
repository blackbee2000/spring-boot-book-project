package com.online.ltbook.models;


import javax.persistence.*;

@Entity
@Table(name="productCartTable")
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idCard;
    private Integer amount;
    private Double price;
    private Double total;
    private String name;
    private Integer rating;
    private String imgUrl;

    public ProductCart(){}

    public ProductCart(Long idCard, Integer amount, Double price, Double total, String name, Integer rating, String imgUrl) {
        this.idCard = idCard;
        this.amount = amount;
        this.price = price;
        this.total = total;
        this.name = name;
        this.rating = rating;
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "ProductCart{" +
                "id=" + id +
                ", idCard=" + idCard +
                ", amount=" + amount +
                ", price=" + price +
                ", total=" + total +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}


