package mainpkg.Rasel.Refugee;

import mainpkg.AbstractClass.User;

/**
 *
 * @author RayhaN
 */
public class Refugee extends User {
    
    private String food, medicine, doctor;
    private int quantity, refugeeID;
    
    public Refugee(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
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
        return refugeeID;
    }

    public void setRefugeeID(int refugeeID) {
        this.refugeeID = refugeeID;
    }

    @Override
    public String toString() {
        return "Refugee{" + "food=" + food + ", medicine=" + medicine + ", doctor=" + doctor + ", quantity=" + quantity + ", refugeeID=" + refugeeID + '}';
    }
    
    
}
