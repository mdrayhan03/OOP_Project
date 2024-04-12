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
public class FoodRequest {
    private static int nextId = 1;

    private int requestId;
    private String foodName;
    private int foodQuantity;
    private Date requestDate;
    private Date deadline;
    private String status;

    public FoodRequest(String foodName, int requestId, Date requestDate, Date deadline, String status) {
        this.requestId = requestId;
        this.foodName = foodName;
        this.foodQuantity = foodQuantity;
        this.requestDate = requestDate;
        this.deadline = deadline;
        this.status = status;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        FoodRequest.nextId = nextId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FoodRequest{" + "requestId=" + requestId + ", foodName=" + foodName + ", foodQuantity=" + foodQuantity + ", requestDate=" + requestDate + ", deadline=" + deadline + ", status=" + status + '}';
    }
    
}
