package Charecters;

import com.example.rou.Map;
import javafx.scene.shape.Rectangle;

public abstract class Student extends Hero {
    int RefreshTime;

    public Student(int power, int speed, int health, int refreshTime) {
        super(power, speed, health);
        RefreshTime = refreshTime;
    }

    public void Play(int x, int y, int Line, Rectangle Us_Character) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                double StartX;
                double StartY;
                synchronized (Map.Synchronized) {
                    Character_Hero = Us_Character;
                    StartX = Us_Character.getLayoutX();
                    StartY = Us_Character.getLayoutY();

                    Hero.StudentLine[Line].add(Student.this);

                    Us_Character.setLayoutX(x);
                    Us_Character.setLayoutY(y);
                }
                boolean t = true;
                double Time = (double) System.currentTimeMillis() / 1000;
                while (true) {
                    double CurrentTime = (double) System.currentTimeMillis() / 1000;
                    if (t) {
                        synchronized (Map.Synchronized) {
                            Us_Character.setY(0);
                            Us_Character.setLayoutX(Us_Character.getLayoutX() - ((CurrentTime - Time) * getSpeed()));
                        }
                    }

                    synchronized (Map.Synchronized) {
                        t = true;
                        for (int i = 0; i < Hero.TALine[Line].size(); i++) {
                            if (Math.abs(Us_Character.getLayoutX() - Hero.TALine[Line].get(i).Character_Hero.getLayoutX()) <= 50) {
                                Us_Character.setY(Math.sin(6 * CurrentTime) * 10);

                                Hero.TALine[Line].get(i).HealthInBattle -= getPower() * (CurrentTime - Time);
                                if (Hero.TALine[Line].get(i).HealthInBattle > 0)
                                    t = false;
                            }
                        }
                        if (HealthInBattle <= 0 || Us_Character.getLayoutX() <= 10) {
                            Character_Hero.setLayoutX(StartX);
                            Character_Hero.setLayoutY(StartY);
                            break;
                        }
                    }

                    Time = CurrentTime;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (Map.Synchronized) {
                    Us_Character.setY(0);
                    for (int i = 0; i < StudentLine[Line].size(); i++) {
                        if (StudentLine[Line].get(i) == Student.this) {
                            StudentLine[Line].get(i).HealthInBattle = (int) StudentLine[Line].get(i).Health;
                            StudentLine[Line].remove(i);
                        }
                    }
                }
            }
        });

        thread.start();
    }
}