package com.online.ltbook.models;

import javax.persistence.*;

@Entity
@Table(name="cartTable")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idUser;
    private String accessToken;
    private String code;
    private Double amount;
    private Double total;
    private String status;
    private String nameCustomer;
    private String phoneCustomer;
    private String addressCustomer;

    public Cart(){}

    public Cart(Long idUser,String accessToken, String code, Double amount, Double total, String status, String nameCustomer, String phoneCustomer, String addressCustomer) {
        this.idUser = idUser;
        this.accessToken = accessToken;
        this.code = code;
        this.amount = amount;
        this.total = total;
        this.status = status;
        this.nameCustomer = nameCustomer;
        this.phoneCustomer = phoneCustomer;
        this.addressCustomer = addressCustomer;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", code='" + code + '\'' +
                ", amount=" + amount +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", phoneCustomer='" + phoneCustomer + '\'' +
                ", addressCustomer='" + addressCustomer + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }
}
