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
    String id;
    Integer amount;
    Date date;
    String status;

    public Shelter(String id, Integer amount, Date date, String status) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Shelter{" + "id=" + id + ", amount=" + amount + ", date=" + date + ", status=" + status + '}';
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

