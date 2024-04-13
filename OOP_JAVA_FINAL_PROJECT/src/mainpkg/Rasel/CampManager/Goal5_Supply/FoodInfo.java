/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal5_Supply;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author synt4x_err0r
 */
public class FoodInfo implements Serializable {
    int foodStock;
    String foodName;
    Date foodMfgDate, foodExpDate;

    public FoodInfo(int foodStock, String foodName, Date foodMfgDate, Date foodExpDate) {
        this.foodStock = foodStock;
        this.foodName = foodName;
        this.foodMfgDate = foodMfgDate;
        this.foodExpDate = foodExpDate;
    }

    public int getFoodStock() {
        return foodStock;
    }

    public void setFoodStock(int foodStock) {
        this.foodStock = foodStock;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Date getFoodMfgDate() {
        return foodMfgDate;
    }

    public void setFoodMfgDate(Date foodMfgDate) {
        this.foodMfgDate = foodMfgDate;
    }

    public Date getFoodExpDate() {
        return foodExpDate;
    }

    public void setFoodExpDate(Date foodExpDate) {
        this.foodExpDate = foodExpDate;
    }

    @Override
    public String toString() {
        return "FoodInfo{" + "foodStock=" + foodStock + ", foodName=" + foodName + ", foodMfgDate=" + foodMfgDate + ", foodExpDate=" + foodExpDate + '}';
    }
    
    
    

}
