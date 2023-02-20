package be.thomasmore.party2023.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Random;

@Entity
public class Client {
    @Id


    private Integer id;
    private String clientName;
    private String birthDate;
    private String gender;
    private String startDate;

    public Client(String name, String birthdate, String gender, String startdate) {
        this.clientName = name;
        this.birthDate = birthdate;
        this.gender = gender;
        this.startDate = startdate;
    }

    public Client(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return clientName;
    }

    public void setName(String name) {
        this.clientName = name;
    }

    public String getBirthdate() {
        return birthDate;
    }

    public void setBirthdate(String birthdate) {
        this.birthDate = birthdate;
    }

    public String getGender() {
        if (gender == "M"){
            return "Meneer";
        }
        else {
            return "Mevrouw";
        }

    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStartdate() {
        return startDate;
    }

    public void setStartdate(String startdate) {
        this.startDate = startdate;
    }

    public String generateCode(){

        Random random = new Random();
        String[] birthdate = getBirthdate().split("-");
        int day = Integer.parseInt(birthdate[0]);
        int month = Integer.parseInt(birthdate[1]);
        int year = Integer.parseInt(birthdate[2]);

        return getName().substring(0,2) + getName().charAt(getName().length()-1) + birthdate[0] + random.nextInt(1,year);
    }





}
