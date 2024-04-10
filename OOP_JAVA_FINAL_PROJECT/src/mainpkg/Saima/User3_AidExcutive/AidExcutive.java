/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive;

import java.io.Serializable;
import javafx.collections.ObservableList;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.CampManager.Goal5_Supply.Food;
import mainpkg.Rasel.CampManager.Goal5_Supply.Shelter;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.RequestedItems;
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
    
    public Food foodInfo(String id , ObservableList<Food> list) {
        for (Food f: list) {
            if (f.getId() == id) {
                return f ;
            }
        }
        return null ;
    }
    
    public Food addFood(String id,String name, String quantity, Date date) {
        Food f = new Food(id,name, quantity, date) ;
        this.setFoodAmount(this.getFoodAmount() + 1) ;
        return f ;
    }
    public Food distributeFood(String id,String name, String quantity, Date date) {
        Food f = new Food(id,name, quantity, date) ;
        this.setFoodAmount(this.getFoodAmount() - 1) ;
        return f ;
    }
    
    public RequestedItems requestExtraFood(int id , String userType , String name, int amount, Date apply, Date deadline) {
        RequestedItems req = new RequestedItems(id , userType , name, amount, apply, deadline) ;
        return req ;
    }

    public Shelter addshelter(String id, Integer amount, Date date) {
        Shelter sh = new Shelter(id, amount, date) ;
        this.setShelterAmount(this.getShelterAmount() + 1) ;
        return sh;
    }
    public Shelter allocateshelter(String id, Integer amount, Date date) {
        Shelter sh = new Shelter(id, amount, date) ;
        this.setShelterAmount(this.getShelterAmount() - 1) ;
        return sh;
    }
    public RequestedItems requestExtraShelter(int id , String userType , int amount, Date apply, Date deadline) {
        RequestedItems req = new RequestedItems(id , userType ,  amount, apply, deadline) ;
        return req ;
    }


}
