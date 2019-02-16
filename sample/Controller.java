package sample;

import connectivity.database;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField textField;
    public TextField txtPassword;
    public Label warningLabel;


    private database dc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dc = new database();

    }


    public void changeScreenWhenPushed(javafx.event.ActionEvent event) throws IOException {
        try {
            Connection conn = dc.getConnecton();
            String sql = "SELECT *FROM AUTHENTICATE WHERE USERNAMES = '" + textField.getText() + "' AND PASSWORD ='" + txtPassword.getText() + "'";
            ResultSet resultSet =conn.prepareStatement(sql).executeQuery();

            if (resultSet.next()) {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("stock.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
            }else{
                warningLabel.setText("Cant Log in. Try again");


            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }


    }
}



