package org.example.sprint5.finalTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AnimalFarm {
    private ArrayList<String> farmAnimals;

    public AnimalFarm(ArrayList<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    public ArrayList<String> getFarmAnimals() {
        return farmAnimals;
    }

    public void setFarmAnimals(ArrayList<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    public HashMap<String, Integer> countedAnimals(){
        HashMap<String, Integer> farmAnimalsMap = new HashMap<>();

        for (String str: farmAnimals){
            String[] split = str.split(" ");
            try {
               Animal.valueOf(split[0]);
               farmAnimalsMap.put(str, (int) (Math.random()*10));
            } catch (IllegalArgumentException exception){
                System.out.println("Please correct string [Здесь вывести полностью ошибочную строку]. Incorrect input data.");
            }
        }
        return farmAnimalsMap;
    }

    public HashSet<String> uniqueNames(){
        HashSet<String> uniqueAnimalsNames = new HashSet<>();
        for (String str: farmAnimals){
            String[] split = str.split(" ");
            try {
                uniqueAnimalsNames.add(split[1]);
            } catch (ArrayIndexOutOfBoundsException exception){
                System.out.println("Please correct string [Здесь вывести полностью ошибочную строку]. Incorrect input data.");
            }
        }
        return uniqueAnimalsNames;
    }

    public void add(Animal type, String name){
        farmAnimals.add(String.join(" ",type.name(), name));
    }
    public void add(Animal type){
        farmAnimals.add(String.join(" ",type.name(),  "N"));
    }
    public void add(String name){
        farmAnimals.add(String.join(" ", Animal.NOT_DEFINED.name(), name));
    }

    public String toString(String name){
        String[] split = name.split(" ");
        return String.format("%C%s %C%s ", split[0].charAt(0), split[0].substring(1).toLowerCase(), split[1].charAt(0), split[1].substring(1).toLowerCase());
    }
}
