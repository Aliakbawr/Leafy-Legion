package Charecters;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class Hero extends Node {
    public void setHealthInBattle(int healthInBattle) {
        HealthInBattle = healthInBattle;
    }

    public void setCharacter_Hero(Rectangle character_Hero) {
        Character_Hero = character_Hero;
    }

    public static void setStudentLine(ArrayList<Student>[] studentLine) {
        StudentLine = studentLine;
    }

    public static void setTALine(ArrayList<TA>[] TALine) {
        Hero.TALine = TALine;
    }

    final int Power;
    final int Speed;
    final int Health;
    int HealthInBattle;

    Rectangle Character_Hero;
    static ArrayList<Student>[] StudentLine = new ArrayList[] { new ArrayList<Student>(), new ArrayList<Student>(), new ArrayList<Student>() };
    static ArrayList<TA>[] TALine = new ArrayList[] { new ArrayList<TA>(), new ArrayList<TA>(), new ArrayList<TA>()};

    public Hero(int power, int speed, int health) {
        this.Power = power;
        this.Speed = speed;
        this.Health = health;
    }

    public int getPower() {
        return Power;
    }
    public int getSpeed() {
        return Speed;
    }
}
