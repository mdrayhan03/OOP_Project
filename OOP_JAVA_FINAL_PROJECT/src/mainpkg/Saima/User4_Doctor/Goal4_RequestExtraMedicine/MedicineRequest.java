/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal4_RequestExtraMedicine;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author HP
 */
public class MedicineRequest implements Serializable {
    String id,name;
    Integer amount;
    Date requestDate;
    Date deadLine;
    String status;

    public MedicineRequest(String id, int amount1, Date requestDate, Date deadLine, String name) {
        this.id = id;
        this.name = name;
        this.amount = amount;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
        return "MedicineRequest{" + "id=" + id + ", name=" + name + ", amount=" + amount + ", requestDate=" + requestDate + ", deadLine=" + deadLine + ", status=" + status + '}';
    }
    
    
    public String generateId() {
        String id = "ReqI" ;
        id += this.getRequestDate().toString().substring(0 , 1) ;
        id += this.getDeadLine().toString().substring(0 , 1) ;
        return id ;
    }
}
