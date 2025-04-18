/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal2_MedicalRecords;

/**
 *
 * @author HP
 */
public class MedicalRecord {
    private int refugeeId;
    private String medicineName;
    private String gender;
    private int dd;
    private int mm;
    private int yyyy;
    private String name;
    private int age;
    private String disease;
    private String treatment;
    private int checkupNo;

    public MedicalRecord(int refugeeId, String medicineName, String gender, int dd, int mm, int yyyy, String name, int age, String disease, String treatment, int checkupNo) {
        this.refugeeId = refugeeId;
        this.medicineName = medicineName;
        this.gender = gender;
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.treatment = treatment;
        this.checkupNo = checkupNo;
    }

    public int getRefugeeId() {
        return refugeeId;
    }

    public void setRefugeeId(int refugeeId) {
        this.refugeeId = refugeeId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getYyyy() {
        return yyyy;
    }

    public void setYyyy(int yyyy) {
        this.yyyy = yyyy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public int getCheckupNo() {
        return checkupNo;
    }

    public void setCheckupNo(int checkupNo) {
        this.checkupNo = checkupNo;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" + "refugeeId=" + refugeeId + ", medicineName=" + medicineName + ", gender=" + gender + ", dd=" + dd + ", mm=" + mm + ", yyyy=" + yyyy + ", name=" + name + ", age=" + age + ", disease=" + disease + ", treatment=" + treatment + ", checkupNo=" + checkupNo + '}';
    }
    
    
    
}
