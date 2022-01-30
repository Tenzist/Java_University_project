package com.oleg.pakhomov.ex1;


public class TourTrip {
    private String city;
    private int year;
    private int concertAmount;

    public void setTrip(String city, int concertAmount, int year) {
        this.city = city;
        this.concertAmount = concertAmount;
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public int getYear() {
        return year;
    }


    public int getConcertAmount() {
        return concertAmount;
    }


}
