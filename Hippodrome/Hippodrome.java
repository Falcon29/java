package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        
        game.getHorses().add(new Horse("Burka", 3.0, 0.0));
        game.getHorses().add(new Horse("Juja", 3.0, 0.0));
        game.getHorses().add(new Horse("Alena", 3.0, 0.0));

        game.run();
        game.printWinner();
    }
    
    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        return horses.stream()
                .max(Comparator.comparingDouble(Horse::getDistance))
                .get();
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}

