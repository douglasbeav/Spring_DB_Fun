package com.spring_boot.spring_db_fun.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*entity class for table "users" @Entity
* the attributes for User class
* are to be the same as * the attributes
* in the "users" table*/
@Entity
public class User {

    //marks a field in the model class User @Id
    @Id
    private int usrID;
    private String usrName;
    private String password;
    private String favTeacher;

    public User() {
    }

    //getter methods for User
    public int getUsrID()           { return usrID; }

    public String getUsrName()      { return usrName; }

    public String getPassword()     { return password; }

    public String getFavTeacher()   { return favTeacher; }

    //setter methods for User
    public void setUsrID(int usrID)                 { this.usrID = usrID; }

    public void setUsrName(String usrName)          { this.usrName = usrName; }

    public void setPassword(String password)        { this.password = password; }

    public void setFavTeacher(String favTeacher)    { this.favTeacher = favTeacher; }
}
