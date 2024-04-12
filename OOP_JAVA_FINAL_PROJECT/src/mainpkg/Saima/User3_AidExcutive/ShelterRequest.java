/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author HP
 */
public class ShelterRequest {
    String  status , id , userType ;
    int amount , senderId ;
    Date apply , deadline ;
    
    public ShelterRequest(int amount, Date apply, Date deadline, String status) {
        this.status = status;
        this.id = id;
        this.userType = userType;
        this.amount = amount;
        this.senderId = senderId;
        this.apply = apply;
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public Date getApply() {
        return apply;
    }

    public void setApply(Date apply) {
        this.apply = apply;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "ShelterRequest{" + "status=" + status + ", id=" + id + ", userType=" + userType + ", amount=" + amount + ", senderId=" + senderId + ", apply=" + apply + ", deadline=" + deadline + '}';
    }
    
    public String generateId() {
        String id = "ReqI" ;
        id += this.getApply().toString().substring(0 , 1) ;
        id += this.getDeadline().toString().substring(0 , 1) ;
        return id ;
    }
}
