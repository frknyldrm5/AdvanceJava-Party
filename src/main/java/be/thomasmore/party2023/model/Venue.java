package be.thomasmore.party2023.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Venue {

    @Id
    private Integer Id;
    private String venueName;
    private String linkMoreInfo;

    private int capacity;
    private boolean foodProvided;
    private boolean indoor;
    private boolean outdoor;
    private boolean freeParkingAvailable;
    private String city;
    private double distanceFromPublicTransportInKm;

    public Venue(String venueName, String linkMoreInfo) {
        this.venueName = venueName;
        this.linkMoreInfo = linkMoreInfo;
    }

    public Venue() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getLinkMoreInfo() {
        return linkMoreInfo;
    }

    public void setLinkMoreInfo(String linkMoreInfo) {
        this.linkMoreInfo = linkMoreInfo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFoodProvided() {
        return foodProvided;
    }

    public void setFoodProvided(boolean foodProvided) {
        this.foodProvided = foodProvided;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    public boolean isOutdoor() {
        return outdoor;
    }

    public void setOutdoor(boolean outdoor) {
        this.outdoor = outdoor;
    }

    public boolean isFreeParkingAvailable() {
        return freeParkingAvailable;
    }

    public void setFreeParkingAvailable(boolean freeParkingAvailable) {
        this.freeParkingAvailable = freeParkingAvailable;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getDistanceFromPublicTransportInKm() {
        return distanceFromPublicTransportInKm;
    }

    public void setDistanceFromPublicTransportInKm(double distanceFromPublicTransportInKm) {
        this.distanceFromPublicTransportInKm = distanceFromPublicTransportInKm;
    }
}