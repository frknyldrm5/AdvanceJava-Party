package be.thomasmore.party2023.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Client {
    @Id


    private Integer id;
    private String name;
    private Date birthdate;
    private char gender;
    private Date startdate;

    public Client(String name, Date birthdate, char gender, Date startdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.startdate = startdate;
    }

    public Client(){

    }













}
