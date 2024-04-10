/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Saima.User3_AidExcutive.Goal8_Report.Report;

/**
 *
 * @author HP
 */
public class AidExcutive extends User implements Serializable{
    int foodAmount = 0 ;
    int shelterAmount = 0 ;
    
    
      public AidExcutive(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
      }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getShelterAmount() {
        return shelterAmount;
    }

    public void setShelterAmount(int shelterAmount) {
        this.shelterAmount = shelterAmount;
    }

    @Override
    public String toString() {
        return "AidExcutive{" + "foodAmount=" + foodAmount + ", shelterAmount=" + shelterAmount + '}';
    }
      
    public Report report(String subject , String des , Date doa) {
    Report rep = new Report(subject , des , doa) ;
    return rep ;
    }  
}
