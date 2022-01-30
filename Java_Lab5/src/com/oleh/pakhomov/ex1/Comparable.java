package com.oleh.pakhomov.ex1;

import java.util.ArrayList;
import java.util.List;

public abstract class Comparable {

    public abstract ArrayList<BandsTour> SortByName();

    public abstract ArrayList<BandsTour> SortByConcert();

    public abstract List<BandsTour> FindLetter(String city);

    public abstract ArrayList<BandsTour> Default();
}
