package mainpkg.Rasel.Refugee;

import java.io.Serializable;
import javafx.collections.ObservableList;
import mainpkg.AbstractClass.User;

/**
 *
 * @author Rasel
 */
public class Refugee extends User implements Serializable {
    
    private String food, medicine, doctor;
    private String fatherName, motherName, symbole, description;
    private int quantity, campNo;
    ObservableList<Refugee> family_members;
    
    public Refugee() {
        super(0, "", "", "", "", "", "", "");
    }
    
    public Refugee(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
    }

    public Refugee(String name, String password, String gender, String dob, String fatherName, String motherName, String symbole, String description, String userType, int id, int campNo) {
        super(id, name, password, "", "", userType, gender, dob);
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.symbole = symbole;
        this.description = description;
        this.campNo = campNo;
    }


    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRefugeeID() {
        return campNo;
    }

    public void setRefugeeID(int campNo) {
        this.campNo = campNo;
    }

    public ObservableList<Refugee> getFamily_members() {
        return family_members;
    }

    public void setFamily_members(ObservableList<Refugee> family_members) {
        this.family_members = family_members;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCampNo() {
        return campNo;
    }

    public void setCampNo(int campNo) {
        this.campNo = campNo;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Refugee{" + "\n" +
                "id = " + getId() + "\n" +
                "name = " + getName() + "\n" +
                "password = " + getPassword() + "\n" +
                "phoneNo = " + getPhoneNo() + "\n" +
                "email = " + getEmail() + "\n" +
                "userType = " + getUserType() + "\n" +
                "gender = " + getGender() + "\n" +
                "dob = " + getDob() + "\n" +
                "fatherName = " + fatherName + "\n" +
                "motherName = " + motherName + "\n" +
                "symbole = " + symbole + "\n" +
                "description = " + description + "\n" +
                "campNo = " + campNo + "\n" +
                "}";
    }
    
    

}
