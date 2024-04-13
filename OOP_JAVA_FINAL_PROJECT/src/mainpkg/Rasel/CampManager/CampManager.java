package mainpkg.Rasel.CampManager;

import java.io.Serializable;
import java.util.ArrayList;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.Refugee.Refugee;

public class CampManager extends User implements Serializable {
    
//    private ArrayList<ReportList> allReports;
//    private ArrayList<RequestManager> allRequest;
    private ArrayList<Refugee> refugeeInfo;
    private int rice, potato, onion, oil, fish, pulse, milk, egg, chicken;
    private Date doj;

    public CampManager(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob, Date doj) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
        this.doj = doj;
    }
   
    
    public ArrayList<Refugee> getRefugeeInfo() {
        return refugeeInfo;
    }

    public void setRefugeeInfo(ArrayList<Refugee> refugeeInfo) {
        this.refugeeInfo = refugeeInfo;
    }

    public int getRice() {
        return rice;
    }

    public void setRice(int rice) {
        this.rice = rice;
    }

    public int getPotato() {
        return potato;
    }

    public void setPotato(int potato) {
        this.potato = potato;
    }

    public int getOnion() {
        return onion;
    }

    public void setOnion(int onion) {
        this.onion = onion;
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public int getFish() {
        return fish;
    }

    public void setFish(int fish) {
        this.fish = fish;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getEgg() {
        return egg;
    }

    public void setEgg(int egg) {
        this.egg = egg;
    }

    public int getChicken() {
        return chicken;
    }

    public void setChicken(int chicken) {
        this.chicken = chicken;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }
    
    @Override
    public String toString() {
        return "CampManager{" + "refugeeInfo=" + refugeeInfo + ", rice=" + rice + ", potato=" + potato + ", onion=" + onion + ", oil=" + oil + ", fish=" + fish + ", pulse=" + pulse + ", milk=" + milk + ", egg=" + egg + ", chicken=" + chicken + ", doj=" + doj + '}';
    }


    
//    public String campCapacity(){
//        campCapacity = 
//        return a;
//    }
//
//    public void supplyFood(){
//        int a = 10;
//    }
//    
//    public void supplyMedicine(){
//    }
//            
//    public String addOrUpdateCampRules(){
//    }
//    
//    public String giveJobsToRefugee(){
//    }
//    
//    public void supplyEducationalInstruments(){
//    }
//    
//    public String registerNewRefugee(refugeeInfo){
//    }
//    
//    public String showAllComplaints(Complaint)
//            
//    public String showAllReports(allReports){
//    }
//    
//    public String showAllRequest(allRequest){
//    }
//    
//    protected Boolean acceptRejectRequest(){
//    }
//    
//    public String giveShelter(){
//    }
//    
//

}
