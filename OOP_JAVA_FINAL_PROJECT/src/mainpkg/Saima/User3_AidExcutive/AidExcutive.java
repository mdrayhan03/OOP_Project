/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive;

import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.CampManager.Goal5_Supply.Food;
import mainpkg.Rasel.CampManager.Goal5_Supply.Shelter;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.RequestedItems;
import mainpkg.Rasel.Refugee.Refugee;
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
            if (Integer.toString(f.getId()) == id) {
                return f ;
            }
        }
        return null ;
    }
    
    public Shelter shelterInfo(String id, ObservableList<Shelter> list) {
    for (Shelter s : list) {
        if (s.getId()==(id)) {
            return s;
        }
    }
    return null;
}
    
     public Food addFood(int id , String userType , String name, int amount, Date date) {
        Food f = new Food(id , userType , name, amount, date) ;
        
        int currentFoodAmount = this.getFoodAmount();
            if (currentFoodAmount > 0) {
                this.setFoodAmount(currentFoodAmount + 1);
        
    }
            return f;
     }
    public Food distributeFood(int id , String userType , String name, int amount, Date date) {
            Food fd = new Food(id , userType , name, amount, date);
            int currentFoodAmount = this.getFoodAmount();
            if (currentFoodAmount > 0) {
                this.setFoodAmount(currentFoodAmount - 1);
            }
            return fd;
}
    
    public RequestedItems requestExtraFood(int id , String userType , String name, int amount, Date apply, Date deadline) {
        RequestedItems req = new RequestedItems(id , userType , name, amount, apply, deadline) ;
        return req ;
    }

    public Shelter addshelter(String id, Integer amount, Date date,String status) {
        Shelter sh = new Shelter(id, amount, date,status) ;
        this.setShelterAmount(this.getShelterAmount() + 1) ;
        return sh;
    }
    public Shelter allocateShelter(String id, int amount, Date date, String status) {
        Shelter sh = new Shelter(id, amount, date,status);
        int currentShelterAmount = this.getShelterAmount();
        if (currentShelterAmount > 0) {
            this.setShelterAmount(currentShelterAmount - 1);
        }
        return sh;
    }
    public ShelterRequest requestExtraShelter(String status,String id , String userType , int amount,int senderId, Date apply, Date deadline) {
        ShelterRequest req = new ShelterRequest(amount, apply, deadline, status);
        return req ;
    }

  public RequestedItems request(int id , String userType , String name, int amount, Date apply, Date deadline) {
        RequestedItems req = new RequestedItems(id , userType , name, amount, apply, deadline) ;
        return req ;
    }
    

   public ObservableList<Refugee> getFamilyMembersOfShelter(String selectedShelterId) {
   
    ObservableList<Refugee> familyMembers = FXCollections.observableArrayList();
    
    return familyMembers;
   }
}


