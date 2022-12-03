package org.example.sprint5;

import java.util.ArrayList;

public class TaskString {
    public static int numberOfSubstrings(String initialString, String substring) {
        int i = initialString.indexOf(substring);
        int count = 0;
        while (i != -1) {
            //System.out.println(initialString.indexOf(substring, i + 1));
            i = initialString.indexOf(substring, i + 1);
            count += 1;
        }
        return count;
    }

    public boolean search(String name, String subName) {
       return name.toLowerCase().indexOf(subName.toLowerCase()) != -1;
    }
    public String maskPhoneNumber(String phoneNumber) {
	       if (phoneNumber.startsWith("+")) {
                return  phoneNumber.replace(phoneNumber.substring(2, 10), "******");
           }
        return  phoneNumber.replace(phoneNumber.substring(1, 9), "******");
    }
    public String fixText(String text) {
//        System.out.println(text.substring(19, 23));
//        text = text.substring(19).replaceFirst("ю", "есу").replaceFirst("по", "");;
//        //text = text.substring(19, 25).replace("по", "");
//        System.out.println(text);
//
//        text.substring(101, 111).replace("зозл", "ссерд");
//
//        text.substring(122, 126).replace("хл", "т");
        text = text.replace("полю", "лесу").replace("разозлился", "рассердился").replace("хлоп", "топ");
        return text;
    }

    public static boolean isPalindromeText(String str) {
        StringBuilder sb = new StringBuilder(str);
        String asString = sb.toString().toLowerCase();
        String newString = sb.reverse().toString().toLowerCase();
        return  asString.replaceAll("\\s+", "").equals(newString.replaceAll("\\s+", ""));
    }

    public static void printHarvest() {
        String[] items = {"Картошка, мешки, 8", "Яблоки, ящики, 11.5", "Клубника, кг, 5.75"};
        for (String item: items){
            String[] split = item.split(", ");
            split[0] = String.format("%-8s", split[0]);
            split[1] = String.format("%-5s", split[1]);
            split[2] = String.format("%-4s", split[2]);
            String harvests = String.join("  ", split);
            System.out.printf("%-" + harvests.length() + "s\n", harvests);
            //System.out.printf("%-17s\n", harvests);
        }
    }

    public static void main(String[] args) {
//        System.out.println(TaskString.search("Раз два, раз два, раз два", "раз"));
//        System.out.println(TaskString.numberOfSubstrings("два", "раз"));
//        System.out.println(TaskString.numberOfSubstrings("раз два", "раз"));
//        System.out.println(TaskString.numberOfSubstrings("раз два, раз два", "раз"));
//        System.out.println(TaskString.numberOfSubstrings("Pаз два, Pаз два, раз два", "раз"));
//        TaskString masker = new TaskString();
//        System.out.println(masker.maskPhoneNumber("8(123)4567890"));
//        System.out.println(masker.maskPhoneNumber("+7(123)4567890"));
//        String text = "Мишка косолапый по полю идёт, шишки собирает, песенки поёт. Шишка отскочила прямо мишке в лоб. Мишка разозлился и ногою - хлоп!";
//
//        var textFixer = new TaskString();
//        var fixedText = textFixer.fixText(text);
//        System.out.println(fixedText);
//        System.out.println(TaskString.isPalindromeText("А роза упала на лапу Азора"));
        String[] arrayOfDishes = new String[]{
                "борщ",
                "котлета",
                "компот"
        };

        // Вместо StringBuilder и цикла можно использовать один вызов String.join(", ", arrayOfDishes);
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(", ", arrayOfDishes));
        for (int i = 0; i < arrayOfDishes.length; i++) {
            sb.append(arrayOfDishes[i]);
            if (i != arrayOfDishes.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
        TaskString.printHarvest();

        ArrayList<String> kittenNames = new ArrayList<>();
        kittenNames.add("Пушок");
        kittenNames.add("Ушастик");
        kittenNames.add("Рыжик");
        kittenNames.add(1,"Снежок");
        // добавь кличку Черныш на третье место в списке
        kittenNames.add(2, "Черныш");
        // выведи на экран последнюю кличку в списке
        System.out.println(kittenNames.get(kittenNames.size() - 1));
        // выведи на экран предпоследнюю кличку в списке
        System.out.println(kittenNames.get(kittenNames.size() - 2));
        // выведи на экран третью кличку в списке
        System.out.println(kittenNames.get(2));


        ArrayList<Double> kittenWeights = new ArrayList<>();
        // добавь в список вес каждого котёнка
        kittenWeights.add(1.62);
        kittenWeights.add(1.91);
        kittenWeights.add(1.76);
        kittenWeights.add(2.02);
        kittenWeights.add(1.88);
        // определи максимальный вес в списке
        double max = 0;
        for (Double kittenWeight: kittenWeights) {
            if (kittenWeight > max) {
                max = kittenWeight;
            }
        }
        // вывод самого большого веса
        System.out.println("Максимальный вес: " + max + " кг");

        // рассчитай сумму весов всех котят
        double sum = 0;
        for (Double weight: kittenWeights) {
            // сложи значения в списке
            sum=sum+weight;
        }
        // рассчитай средний вес котёнка
        double averageWeight = sum/(kittenWeights.size());
        // выведи результат на экран
        System.out.println("Средний вес котёнка: " + averageWeight + " кг");
    }

}


//0 9 18 i=18 c =1
//