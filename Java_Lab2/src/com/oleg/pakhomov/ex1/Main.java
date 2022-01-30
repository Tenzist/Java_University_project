package com.oleg.pakhomov.ex1;

public class Main {

    public static void main(String[] args) {
        TourTrip t1 = new TourTrip();
        MusicBand mb1 = new MusicBand();
        TourTrip t2 = new TourTrip();
        MusicBand mb2 = new MusicBand();
        TourTrip t3 = new TourTrip();
        MusicBand mb3 = new MusicBand();
        mb1.setBand("Avangard","Niko");
        t1.setTrip("Kiev", 111, 2010);
        mb2.setBand("AMOGUS","Adren");
        t2.setTrip("Kharkiv", 24, 2017);
        mb3.setBand("SUS","Zeus");
        t3.setTrip("Berlin", 25, 2021);

        System.out.println("(1)");
        if(t1.getConcertAmount() >= t2.getConcertAmount() && t1.getConcertAmount() >= t3.getConcertAmount()){
            System.out.println("Band:" + mb1.getGroupName() + "\nLeader:" + mb1.getHeadSurname()
                    + "\nCity:" + t1.getCity() + "\nYear:" + t1.getYear() + "\nAmount:" + t1.getConcertAmount());
        }
        else if(t2.getConcertAmount() >= t1.getConcertAmount() && t2.getConcertAmount() >= t3.getConcertAmount()){
            System.out.println("Band:" + mb2.getGroupName() + "\nLeader:" + mb2.getHeadSurname()
                    + "\nCity:" + t2.getCity() + "\nYear:" + t2.getYear() + "\nAmount:" + t2.getConcertAmount());
        }
        else{
            System.out.println("Band:" + mb3.getGroupName() + "\nLeader:" + mb3.getHeadSurname()
                    + "\nCity:" + t3.getCity() + "\nYear:" + t3.getYear() + "\nAmount:" + t3.getConcertAmount());
        }
        System.out.println("(2)");
        System.out.println(t1.getCity() + " : "  + t1.getConcertAmount());
        System.out.println(t2.getCity() + " : "  + t2.getConcertAmount());
        System.out.println(t3.getCity() + " : "  + t3.getConcertAmount());
        System.out.println("(3)");
        System.out.println(mb1.getHeadSurname().substring(mb1.getHeadSurname().length() - 1));
    }
}
