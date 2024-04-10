/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal5_Supply;

import java.io.Serializable;
import java.util.Random;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author HP
 */
public class Shelter implements Serializable {
    String id,Amount;
    Date date;

    public Shelter(String id, String Amount, Date date) {
        this.id = id;
        this.Amount = Amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Shelter{" + "id=" + id + ", Amount=" + Amount + ", date=" + date + '}';
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

