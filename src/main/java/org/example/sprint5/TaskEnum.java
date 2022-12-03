package org.example.sprint5;

import java.util.Locale;

public class TaskEnum {

    public static void main(String[] args) {

        System.out.println("Налоги бывают 3 видов: ");
        // добавь вызов метода для перечисления
        for (TaxType value : TaxType.values()) {
            System.out.println(printType(value));
        }

        String[] parsedText = {
                "                                               I                                                   ",
                "           – Еh bien, mon prince. Gênes et Lucques ne sont plus que des apanages, des поместья, de ",
                "            la famille Buonaparte. Non, je vous préviens que si vous ne me dites pas que nous avons",
                "   la guerre, si vous vous permettez encore de pallier toutes les infamies, toutes les atrocités   ",
                "        de cet Antichrist (ma parole, j’y crois) — je ne vous connais plus, vous n’êtes plus mon   ",
                "          ami, vous n’êtes plus мой верный раб, comme vous dites[1]. Ну, здравствуйте,             ",
                "здравствуйте. Je vois que je vous fais peur[2], садитесь и рассказывайте.                          ",
                "",
                "Так говорила в июле 1805 года известная Анна Павловна Шерер, фрейлина и приближенная               ",
                "императрицы Марии Феодоровны, встречая важного и чиновного князя Василия, первого                  ",
                "приехавшего на ее вечер. Анна Павловна кашляла несколько дней, у нее был грипп, как она говорила   ",
                "(грипп был тогда новое слово, употреблявшееся только редкими). В записочках, разосланных утром     ",
                "с красным лакеем, было написано без различия во всех:                                              ",
                "                                                                                                   "
        };
        for (String str: parsedText) {
            strCleaner(str);
        }
    }

    public static String printType(TaxType type) {
        if (TaxType.FEDERAL == type) {
            return "Федеральные налоги и сборы";
        }
        if (TaxType.REGIONAL == type) {
            return "Региональные налоги и сборы";
        }
        if (TaxType.LOCAL == type) {
            return "Местные налоги и сборы";
        }
        return "Такого вида налогов нет";
    }

    public static void strCleaner(String str) {
        if (!str.isBlank()){
            System.out.println(str.toUpperCase());
            System.out.println(str.trim());
        }
    }
}


// добавь перечисление трёх видов налогов
enum TaxType{
    FEDERAL,
    REGIONAL,
    LOCAL
}
