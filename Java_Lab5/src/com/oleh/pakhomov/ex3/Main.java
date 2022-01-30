package com.oleh.pakhomov.ex3;

        import java.util.HashMap;
        import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();
        countries.put("Admin", "p");
        countries.put("Bublik", "passwo");
        countries.put("Amigo", "passw");
        countries.put("Creeper2007", "password");
        for (Map.Entry<String, String> logins : countries.entrySet())
            if(logins.getValue().length() >= 6){
                System.out.println(logins.getKey() + " " + logins.getValue());
            }
    }
}
