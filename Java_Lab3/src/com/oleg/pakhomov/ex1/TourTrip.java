package com.oleg.pakhomov.ex1;

public class TourTrip  extends MusicBand{
    private String city;
    private int year;
    private int concertAmount;

    public TourTrip(String groupName, String headSurname, String city, int concertAmount, int year) {
        super(groupName ,headSurname);
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

    public String toString() {
        return "TourTrip = " +
                "city: " + city +
                ", year: " + year +
                ", concertAmount: " + concertAmount;
    }
}
