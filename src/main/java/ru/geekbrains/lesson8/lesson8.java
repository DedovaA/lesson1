package ru.geekbrains.lesson8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lesson8 {
    public static void main(String[] args) {

        List<Competitor> competitors = new ArrayList<>(Arrays.asList (
                new Cat(3,300),
                new Human(2, 100),
                new Robot(1, 50))
        );

        Obstacle[] obstacles = {
                new Wall(1), new Treadmill(50),
                new Wall(2), new Treadmill(100),
                new Wall(3), new Treadmill(150)
        };

        while (competitors.size() != 1) {
            int counter = 0;
            for (Obstacle obstacle: obstacles) {
                System.out.println("stage " + (++counter));
                for (int i = 0; i < competitors.size(); i++) {
                    if (!obstacle.overcome(competitors.get(i))) competitors.remove(competitors.get(i));
                }
            }
        }
        System.out.println("В эстафете победил " + competitors.get(0).toString());
    }
}


