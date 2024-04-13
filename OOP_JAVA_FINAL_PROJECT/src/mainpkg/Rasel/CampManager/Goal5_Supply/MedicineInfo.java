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
public class MedicineInfo implements Serializable {
    int medicineStock;
    String medicineName;
    Date medicineMfgDate, medicineExpDate;

    public MedicineInfo(int medicineStock, String medicineName, Date medicineMfgDate, Date medicineExpDate) {
        this.medicineStock = medicineStock;
        this.medicineName = medicineName;
        this.medicineMfgDate = medicineMfgDate;
        this.medicineExpDate = medicineExpDate;
    }

    public int getMedicineStock() {
        return medicineStock;
    }

    public void setMedicineStock(int medicineStock) {
        this.medicineStock = medicineStock;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Date getMedicineMfgDate() {
        return medicineMfgDate;
    }

    public void setMedicineMfgDate(Date medicineMfgDate) {
        this.medicineMfgDate = medicineMfgDate;
    }

    public Date getMedicineExpDate() {
        return medicineExpDate;
    }

    public void setMedicineExpDate(Date medicineExpDate) {
        this.medicineExpDate = medicineExpDate;
    }

    @Override
    public String toString() {
        return "MedicineInfo{" + "medicineStock=" + medicineStock + ", medicineName=" + medicineName + ", medicineMfgDate=" + medicineMfgDate + ", medicineExpDate=" + medicineExpDate + '}';
    }
    
}
