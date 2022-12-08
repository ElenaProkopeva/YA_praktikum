package org.example.sprint5.finalTask;

import java.util.ArrayList;

public class FinalTaskSprint5 {
    public static void main(String[] args) {
        ArrayList<String> animalsList = new ArrayList<>();
        animalsList.add(String.join(" ", Animal.valueOf("CAT").toString(), "Пушок"));
        animalsList.add(String.join(" ", Animal.valueOf("CAT").toString(), "Пушок"));
        animalsList.add(String.join(" ", Animal.valueOf("CAT").toString(), "ушастик"));
        animalsList.add(String.join(" ", Animal.valueOf("DOG").toString(), "Дружок"));
        animalsList.add(String.join(" ", Animal.valueOf("HORSE").toString(), "Чемпион"));
        animalsList.add(String.join(" ", Animal.valueOf("COW").toString(), "Буренка"));
        animalsList.add(String.join(" ", Animal.valueOf("NOT_DEFINED").toString(), "ХЗ"));

        AnimalFarm animalFarm = new AnimalFarm(animalsList);
        //System.out.println(animalFarm.getFarmAnimals());
        System.out.println(animalFarm.countedAnimals());
        System.out.println(animalFarm.uniqueNames());
        animalFarm.add("Мышка");
        animalFarm.add(Animal.DOG, "Мышка");
        animalFarm.add(Animal.DOG);
        System.out.println(animalFarm.getFarmAnimals());
        for (String str: animalFarm.getFarmAnimals()){
            System.out.println(animalFarm.toString(str));
        }
        ResultTask animalFarm1 = new ResultTask(animalsList);
        System.out.println(animalFarm1.countedAnimals());
        System.out.println(animalFarm1.uniqueNames());
        for (String str: animalFarm1.getFarmAnimals()){
            System.out.println(animalFarm.toString(str));
        }

    }
}
