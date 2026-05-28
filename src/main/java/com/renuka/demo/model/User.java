package com.renuka.demo.model;
public class User {
    private String name;
    private String image;
    private String gender;
    private Integer id;
  public User() {
    }
    
    public User(String name, String image, String gender, Integer id) {
        this.name = name;
        this.image = image;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}