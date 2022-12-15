package org.example.sprint6;

public class Example {
    public static void main(String[] args) {
// чтобы заменить лампочку, достаточно вызвать new SuperLamp(),
// остальной код не изменится
        Lamp horizonLamp = new HorizonLamp();
        Fridge fridge = new Fridge(horizonLamp);
        fridge.openDoor();
    }
}



// Шаг 1. Создали общий интерфейс Lamp, который
// будут реализовывать классы HorizonLamp и SuperLamp
interface Lamp {
    void switchLightOn();
}

class HorizonLamp implements Lamp {
    // метод включает свет лампочкой «Горизонт»
    @Override
    public void switchLightOn() {
        System.out.println("Я включаю лампочку марки «Горизонт»");
    }
}

class SuperLamp implements Lamp {
    // метод включает свет лампочкой «Суперлампа»
    @Override
    public void switchLightOn() {
        System.out.println("Я включаю лампочку марки «Суперлампа» и сияю на ура!");
    }
}

class Fridge {
    // Шаг 2. Создали в классе Fridge приватное поле типа Lamp
    // теперь объект lamp — это поле класса Fridge
    private Lamp lamp;

    // Шаг 3. Объект horizonLamp передаётся в конструтор. Он создан извне класса
    public Fridge(Lamp lamp) {
        this.lamp = lamp; // объект попадает в переменную класса
    }

    public void openDoor() {
        // объект класса horizonLamp используют, чтобы включить свет
        lamp.switchLightOn();
        // дальше может быть код, который выполняется после открытия дверцы
    }
}