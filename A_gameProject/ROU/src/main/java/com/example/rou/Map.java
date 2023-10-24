package com.example.rou;

import Charecters.TAs.Angry;
import Charecters.TAs.Kind;
import Charecters.TAs.Boring;
import Charecters.TAs.Normal;
import Charecters.Students.Stupid;
import Charecters.Students.Kissi;
import Charecters.Students.Conditional;
import Charecters.Students.Nerd;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;


public class Map implements Initializable {
    public static final Object Synchronized = new Object();
    private static int X = -1000;
    private static int Y = -1000;
    private static int LINE = -1000;

    @FXML
    private Rectangle FoolR;

    @FXML
    private Rectangle LazyR;

    @FXML
    private Rectangle LeaderR;

    @FXML
    private Rectangle Line1BTNR;

    @FXML
    private Rectangle Line2BTNR;

    @FXML
    private Rectangle Line3BTNR;

    @FXML
    private Rectangle MenuBTNR;

    @FXML
    private AnchorPane MyMap;
    @FXML
    private Rectangle UselessR;
    @FXML
    private Rectangle WiseR;
    @FXML
    private Rectangle KindR;

    @FXML
    private Rectangle AngryR;

    @FXML
    private Rectangle NerdR;

    @FXML
    private Rectangle PlayGround;

    @FXML
    private Rectangle StartBTNR;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Line1BTNR.setVisible(false);
        Line2BTNR.setVisible(false);
        Line3BTNR.setVisible(false);
        LeaderR.setVisible(false);
        LazyR.setVisible(false);
        NerdR.setVisible(false);
        FoolR.setVisible(false);

        javafx.scene.image.Image img1 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("TA_2.png")).toExternalForm());
        WiseR.setFill(new ImagePattern(img1));
        javafx.scene.image.Image img2 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("TA_1.png")).toExternalForm());
        UselessR.setFill(new ImagePattern(img2));
        javafx.scene.image.Image img3 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("TA_3.png")).toExternalForm());
        AngryR.setFill(new ImagePattern(img3));
        javafx.scene.image.Image img4 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("TA_4.png")).toExternalForm());
        KindR.setFill(new ImagePattern(img4));

        javafx.scene.image.Image img11 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("Us_1.png")).toExternalForm());
        LeaderR.setFill(new ImagePattern(img11));
        javafx.scene.image.Image img12 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("Us_2.png")).toExternalForm());
        NerdR.setFill(new ImagePattern(img12));
        javafx.scene.image.Image img13 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("Us_3.png")).toExternalForm());
        FoolR.setFill(new ImagePattern(img13));
        javafx.scene.image.Image img14 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("Us_4.png")).toExternalForm());
        LazyR.setFill(new ImagePattern(img14));


        javafx.scene.image.Image img5 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("Line1_BTN.png")).toExternalForm());
        Line1BTNR.setFill(new ImagePattern(img5));
        javafx.scene.image.Image img6 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("Line2_BTN.png")).toExternalForm());
        Line2BTNR.setFill(new ImagePattern(img6));
        javafx.scene.image.Image img7 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("Line3_BTN.png")).toExternalForm());
        Line3BTNR.setFill(new ImagePattern(img7));

        javafx.scene.image.Image img8 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("StartBTN_In.png")).toExternalForm());
        StartBTNR.setFill(new ImagePattern(img8));
        javafx.scene.image.Image img9 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("MenuBTN.png")).toExternalForm());
        MenuBTNR.setFill(new ImagePattern(img9));

        javafx.scene.image.Image img10 = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("gif04.gif")).toExternalForm());
        PlayGround.setFill(new ImagePattern(img10));

    }

    @FXML
    void FoolEvent(MouseEvent event) {
        if(X!=-1000)
            Stupid.Stupid_N.Play(X,Y,LINE,FoolR);
    }

    @FXML
    void LazyEvent(MouseEvent event) {
        if(X!=-1000)
            Kissi.Kissi_N.Play(X,Y,LINE,LazyR);
    }

    @FXML
    void LeaderEvent(MouseEvent event) {
        if(X!=-1000)
            Conditional.Conditional_N.Play(X,Y,LINE,LeaderR);
    }

    @FXML
    void NerdEvent(MouseEvent event) {
        if(X!=-1000)
            Nerd.Nerd_N.Play(X,Y,LINE,NerdR);
    }


    @FXML
    void Line1Event(MouseEvent event) {
        synchronized (Synchronized) {
            X = 884;
            Y = 117;
            LINE = 0;
        }
    }

    @FXML
    void Line2Event(MouseEvent event) {
        synchronized (Synchronized) {
            X = 884;
            Y = 280;
            LINE = 1;
        }
    }

    @FXML
    void Line3Event(MouseEvent event) {
        synchronized (Synchronized) {
            X = 884;
            Y = 449;
            LINE = 2;
        }
    }

    @FXML
    void MenuEvent(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartMenu.fxml")));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void StartEvent(MouseEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setNode(StartBTNR);
        fade.setFromValue(0);
        fade.setToValue(1);
        StartBTNR.setVisible(false);
        Line1BTNR.setVisible(true);
        Line2BTNR.setVisible(true);
        Line3BTNR.setVisible(true);
        LeaderR.setVisible(true);
        LazyR.setVisible(true);
        NerdR.setVisible(true);
        FoolR.setVisible(true);


        Thread TAsThread = new Thread(() -> {
            while (true) {
                Random random = new Random();
                int RandomLineTA = random.nextInt(3);
                int XLine, YLine;
                if (RandomLineTA == 0) {
                    XLine = -52;
                    YLine = 114;
                } else if (RandomLineTA == 1) {
                    XLine = -52;
                    YLine = 270;
                } else {
                    XLine = -52;
                    YLine = 446;
                }

                int r = random.nextInt(4);
                if (r == 0 && WiseR.getLayoutX() <= 0) {
                    Normal.Normal_N.Play( XLine, YLine, RandomLineTA, WiseR);
                }
                else if (r == 1 && KindR.getLayoutX() <= 0) {
                    Kind.Kind_N.Play( XLine, YLine, RandomLineTA, KindR);
                }
                else if (r == 2 && UselessR.getLayoutX() <= 0) {
                    Boring.Boring_N.Play( XLine, YLine, RandomLineTA, UselessR);
                }
                else if (r == 3 && AngryR.getLayoutX() <= 0) {
                    Angry.Angry_N.Play( XLine, YLine, RandomLineTA, AngryR);
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        TAsThread.start();
    }





}
