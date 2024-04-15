/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal5_Supply;

/**
 *
 * @author HP
 */
import java.io.Serializable;
import java.util.Random;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author HP
 */
public class Food implements Serializable {
    int id ;
    String userType ;
    String name;
    int amount;
    Date date;

    public Food(int id, String userType, String name, int amount, Date date) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", userType=" + userType + ", name=" + name + ", amount=" + amount + ", date=" + date + '}';
    }
    



    private String generateId() {
        Random r=new Random();
        String id = "" ;
        for(int i=0;i<8;i++){
        id+=r.nextInt(9);
        }
        
        return id;
        }
}

