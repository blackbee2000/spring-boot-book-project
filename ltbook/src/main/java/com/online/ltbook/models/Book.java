package com.online.ltbook.models;

import javax.persistence.*;

@Entity
@Table(name="bookTable")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private Integer rating;
    private Integer sold;
    private String description;
    private String artistAvatar;
    private String artistName;
    private String artistBornDay;
    private String type;
    private String status;
    private String createBy;
    private String createAt;
    private String updateBy;
    private String updateAt;

    public Book() {}

    public Book(String name, Double price, Integer rating, Integer sold, String description, String artistAvatar, String artistName, String artistBornDay, String type, String status, String createBy, String createAt, String updateBy, String updateAt) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.sold = sold;
        this.description = description;
        this.artistAvatar = artistAvatar;
        this.artistName = artistName;
        this.artistBornDay = artistBornDay;
        this.type = type;
        this.status = status;
        this.createBy = createBy;
        this.createAt = createAt;
        this.updateBy = updateBy;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", sold=" + sold +
                ", description='" + description + '\'' +
                ", artistAvatar='" + artistAvatar + '\'' +
                ", artistName='" + artistName + '\'' +
                ", artistBornDay='" + artistBornDay + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createAt='" + createAt + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateAt='" + updateAt + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtistAvatar() {
        return artistAvatar;
    }

    public void setArtistAvatar(String artistAvatar) {
        this.artistAvatar = artistAvatar;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistBornDay() {
        return artistBornDay;
    }

    public void setArtistBornDay(String artistBornDay) {
        this.artistBornDay = artistBornDay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
