package Charecters;

import com.example.rou.Map;
import javafx.scene.shape.Rectangle;

public abstract class TA extends Hero{

    public static double OfficeHealth = 500;
    public TA(int power, int speed, int health) {
        super(power, speed, health);
    }

    public void Play(int x, int y, int Line, Rectangle TA_Character)
    {
        Thread thread = new Thread(() -> {
            double StartX;
            double StartY;
            synchronized (Map.Synchronized) {
                StartX = TA_Character.getLayoutX();
                StartY = TA_Character.getLayoutY();

                Character_Hero = TA_Character;
                Hero.TALine[Line].add(TA.this);

                TA_Character.setLayoutX(x);
                TA_Character.setLayoutY(y);
            }
            double Time = (double) System.currentTimeMillis() / 1000;
            boolean t = true;
            while (true) {
                double CurrentTime = (double) System.currentTimeMillis() / 1000;
                if (TA_Character.getLayoutX() <= 907 && t)
                {
                    synchronized (Map.Synchronized) {
                        TA_Character.setLayoutX(TA_Character.getLayoutX() + ((CurrentTime - Time) * getSpeed()));
                    }
                }
                else if (TA_Character.getLayoutX() >= 907) {
                    synchronized (Map.Synchronized) {
                        TA_Character.setY(0);
                        TA_Character.setY(Math.sin(6 * CurrentTime) * 10);
                        OfficeHealth -= getPower() * (CurrentTime - Time);
                        if (OfficeHealth <= 0)
                        {
//                                gameOver.setVisible(true);
                            System.out.println("---{Game over}---");
                            System.exit(1);
                        }
                    }
                }

                synchronized (Map.Synchronized) {
                    t = true;
                    for (int i = 0; i < Hero.StudentLine[Line].size(); i++) {
                        if (Math.abs(TA_Character.getLayoutX() - Hero.StudentLine[Line].get(i).Character_Hero.getLayoutX()) <= 50) {
                            TA_Character.setY(Math.sin(6 * CurrentTime) * 10);

                            Hero.StudentLine[Line].get(i).HealthInBattle -= getPower() * (CurrentTime - Time);
                            if (Hero.StudentLine[Line].get(i).HealthInBattle > 0)
                                t = false;
                        }
                    }

                    if (HealthInBattle <= 0)
                    {
                        Character_Hero.setLayoutY(StartY);
                        Character_Hero.setLayoutX(StartX);
                        break;
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Time = CurrentTime;
}
            synchronized (Map.Synchronized) {
                TA_Character.setY(0);
                for (int i = 0; i < TALine[Line].size(); i++) {
                    if (TALine[Line].get(i) == TA.this) {
                        TALine[Line].get(i).HealthInBattle = TALine[Line].get(i).Health;
                        TALine[Line].remove(i);
                    }
                }
            }
        });
        thread.start();

    }
}
