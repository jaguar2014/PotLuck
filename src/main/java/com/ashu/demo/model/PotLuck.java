package com.ashu.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PotLuck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String item;

    private int servingSize;

    private String itemType;


    @ManyToMany
    private List<AppUser> appUsers;



    public void addAppUser(AppUser u){
        appUsers.add(u);
    }

    public PotLuck(){
        appUsers = new ArrayList<>();
    }


    public List<AppUser> getAppUser() {
        return appUsers;
    }

    public void setAppUser(List<AppUser> appUser) {
        this.appUsers = appUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
