package com.oleg.pakhomov.ex1;

public class MusicBand {
    private String groupName;
    private String headSurname;

    public void setBand(String groupName, String headSurname) {
        this.groupName = groupName;
        this.headSurname = headSurname;
    }
    public String getGroupName() {
        return groupName;
    }

    public String getHeadSurname() {
        return headSurname;
    }
}

