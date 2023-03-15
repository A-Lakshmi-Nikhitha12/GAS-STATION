package com.Nikhitha.StationProjectFullStack.Model;


import jakarta.persistence.*;

@Entity
public class StationModel {

    @jakarta.persistence.Id
    @GeneratedValue
    private Long Id;
    private String Name;
    @Lob
    private byte[] imageData;
    private Long price;
    private String Address;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
