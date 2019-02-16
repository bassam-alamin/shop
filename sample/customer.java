package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class customer {
    private final StringProperty FirstName;
    private final StringProperty SecondName;
    private final StringProperty PhoneNumber;
    private final StringProperty Address;
    private final DoubleProperty Debt;

    public customer(String firstName, String secondName, String phoneNumber, String address, Double debt) {
        FirstName = new SimpleStringProperty(firstName);
        SecondName = new SimpleStringProperty(secondName);
        PhoneNumber = new SimpleStringProperty(phoneNumber);
        Address = new SimpleStringProperty(address);
        Debt = new SimpleDoubleProperty(debt);
    }


    //getters
    public String getFirstName(){
        return FirstName.get();
    }
    public String getSecondName(){
        return SecondName.get();
    }
    public String getPhoneNumber(){
        return PhoneNumber.get();
    }
    public String getAddress(){
        return Address.get();
    }
    public Double getDebt(){
        return Debt.get();
    }
    //setters
    public void setFirstName(String value){
        FirstName.set(value);
    }
    public void setSecondName(String value){
        SecondName.set(value);
    }
    public void setPhoneNumber(String value){
        PhoneNumber.set(value);
    }
    public void setAddress(String value){
        Address.set(value);
    }
    public void setDebt(Double value){
        Debt.set(value);
    }
    //property values


    public StringProperty FirstNameProperty() {
        return FirstName;
    }

    public StringProperty SecondNameProperty() {
        return SecondName;
    }

    public StringProperty PhoneNumberProperty() {
        return PhoneNumber;
    }
    public StringProperty AddressProperty() {
        return Address;
    }
    public DoubleProperty DebtProperty() {
        return Debt;
    }


}
