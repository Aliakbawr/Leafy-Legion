package com.example.rou;

import SQL.MySQLConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SignMenu {
    @FXML
    private TextField NameTXT;
    public static String username;
    public static int score;
    @FXML //    activate sql
    void LogInBTN(MouseEvent event) throws SQLException, IOException {
        boolean username_exist = false;
        ResultSet resultSet = MySQLConnection.getMySQL().ExecuteQuery("SELECT * FROM 'score'");
        if (resultSet != null) {
            while (resultSet.next()) {
                if (NameTXT.getText().equals(resultSet.getString("username"))) {
                    username_exist = true;
                    username = resultSet.getString("username");
                    score = resultSet.getInt("score");
                    break;
                }
            }
        }
        if(!username_exist)
        {
            String SQLCom = String.format("INSERT INTO customers (username) VALUES ('%s')",NameTXT.getText());
            MySQLConnection.getMySQL().Execute(SQLCom);
            username = NameTXT.getText();
            score = 0;

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SelectMapMenu.fxml")));
            Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.show();
        }
    }

    @FXML
    void MenuBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartMenu.fxml")));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

}
