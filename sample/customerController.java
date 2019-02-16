package sample;

import connectivity.database;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;


import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class customerController implements Initializable{

    @FXML
    private TextField columnFirstName;
    @FXML
    private TextField columnSeccondName;
    @FXML
    private TextField columnPhoneNumber;
    @FXML
    private TextField columnAddress;
    @FXML
    private TextField columnDebt;



    //Initialize observable list to hold out database data

    private database dc;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        dc = new database();

    }
    @FXML
    private void addDataToDatabase(javafx.event.ActionEvent event){
        try {
            Connection conn = dc.getConnecton();
            String sql = "INSERT INTO CUSTOMER VALUES ('"+columnFirstName.getText()+"','"+columnSeccondName.getText()+"','"+columnPhoneNumber.getText()+"','"+columnAddress.getText()+"','"+columnDebt.getText()+"')";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex){
            System.err.println("Error occured"+ex);
        }



    }



}
