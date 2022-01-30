package com.oleg.pakhomov.ex1;

import java.util.*;
import java.util.stream.Collectors;

public class Sorting extends Comparable {

    ArrayList<BandsTour> bandtour = new ArrayList<>();

    public void defaultBands() {
        bandtour.add(createBand("SUS", "Zeus", "Amsterdam", 25, 2021));
        bandtour.add(createBand("Ninjas", "Adren", "Berlin", 26, 2022));
        bandtour.add(createBand("Avangard", "Niko", "Kiev", 11, 2010));
        //        bandtour.add(createBand("Polus", "Inf", "Kiev", 17, 2017));
    }

    public BandsTour createBand(String groupName, String headSurname, String city, int concertAmount, int year) {
        return new BandsTour(groupName, headSurname, city, concertAmount, year);
    }

    @Override
    public ArrayList<BandsTour> Default() {
        return bandtour;
    }

    @Override
    public ArrayList<BandsTour> SortByConcert() {
        bandtour.sort(Comparator.comparing(BandsTour::getConcertAmount));
        return bandtour;
    }

    @Override
    public ArrayList<BandsTour> SortByName() {
        bandtour.sort(Comparator.comparing(BandsTour::getCity));
        return bandtour;
    }

    @Override
    public List<BandsTour> FindLetter(String city) {
        return bandtour.stream().filter(bandsTour -> bandsTour.getCity().equals(city)).collect(Collectors.toList());
    }
}
