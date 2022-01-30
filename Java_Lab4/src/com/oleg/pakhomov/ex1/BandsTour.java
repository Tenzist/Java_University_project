package com.oleg.pakhomov.ex1;

public class BandsTour extends TourTrip{

    public BandsTour(String groupName, String headSurname, String city, int concertAmount, int year) {
        super(groupName, headSurname, city, concertAmount, year);
    }

    @Override
    public String toString() {
        return "\nBandsTour = Group: " + getGroupName() + " | Leader: " + getHeadSurname() +
        " | City: " + getCity() + " | Year: " + getYear() + " | Concert amount: " + getConcertAmount() + "";
    }
}
