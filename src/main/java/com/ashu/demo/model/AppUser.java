package com.ashu.demo.model;




import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser {

  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

   @NotEmpty
   @NotNull
    private String username;

    @NotEmpty
    @NotNull
    private String firstName;

    @NotEmpty
    public String password;

    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> appRoles;

   @ManyToMany(mappedBy = "appUsers")
    private List<PotLuck> potLucks;



   public List<PotLuck> getPotLucks() {
        return potLucks;
    }



    public void addPotLuck(PotLuck p){
        potLucks.add(p);
    }

    public void setPotLucks(List<PotLuck> potLucks) {
        this.potLucks = potLucks;
    }

    public AppUser(){

        appRoles = new HashSet<>();
        potLucks = new ArrayList<>();

    }

    public void addRole(AppRole role) {
        appRoles.add(role);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<AppRole> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(Set<AppRole> appRoles) {
        this.appRoles = appRoles;
    }
}
