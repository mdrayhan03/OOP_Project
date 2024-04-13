/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User4_Doctor;

import java.io.Serializable;
import mainpkg.Rasel.Refugee.Refugee;

/**
 *
 * @author HP
 */
public class Patient extends Refugee implements Serializable{
    
    Integer patientId;
    String disease,age,checkupDate,treatment;
    Integer checkupNo;

    public Patient(Integer patientId, String disease, String age, String checkupDate, String treatment, Integer checkupNo, int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
        this.patientId = patientId;
        this.disease = disease;
        this.age = age;
        this.checkupDate = checkupDate;
        this.treatment = treatment;
        this.checkupNo = checkupNo;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(String checkupDate) {
        this.checkupDate = checkupDate;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Integer getCheckupNo() {
        return checkupNo;
    }

    public void setCheckupNo(Integer checkupNo) {
        this.checkupNo = checkupNo;
    }

    @Override
    public String toString() {
        return "Patient{" + "patientId=" + patientId + ", disease=" + disease + ", age=" + age + ", checkupDate=" + checkupDate + ", treatment=" + treatment + ", checkupNo=" + checkupNo + '}';
    }
    

    
}
