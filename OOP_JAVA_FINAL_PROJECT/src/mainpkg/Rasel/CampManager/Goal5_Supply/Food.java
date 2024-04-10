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
    String id,name,quantity;
    Date date;

    public Food(String id, String name, String quantity, Date date) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", date=" + date + '}';
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

