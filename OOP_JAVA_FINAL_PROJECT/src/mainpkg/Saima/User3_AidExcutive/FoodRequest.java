/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User3;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author HP
 */
public class FoodRequest implements Serializable {
    String id,name;
    Integer quantity;
    Date requestDate;
    Date deadLine;
    String status;

    public FoodRequest(String id, int quantity, Date requestDate, Date deadLine, String name) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.requestDate = requestDate;
        this.deadLine = deadLine;
        this.status = status;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FoodRequest{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", requestDate=" + requestDate + ", deadLine=" + deadLine + ", status=" + status + '}';
    }

   
   
    


    public String generateId() {
        String id = "ReqI" ;
        id += this.getRequestDate().toString().substring(0 , 1) ;
        id += this.getDeadLine().toString().substring(0 , 1) ;
        return id ;
    }

    
}