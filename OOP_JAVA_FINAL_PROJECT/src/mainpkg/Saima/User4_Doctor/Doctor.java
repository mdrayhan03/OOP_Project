/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User4_Doctor;

import java.io.Serializable;
import javafx.collections.ObservableList;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Holiday;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.CampManager.Goal5_Supply.Food;
import mainpkg.Rasel.CampManager.Goal5_Supply.Medicine;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.RequestedItems;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Rayhan.User5.Goal4_VRequest.RequestedVolunteer;
import mainpkg.Rayhan.User5.Goal8_Report.Report;
import mainpkg.Rayhan.User6.Goal1_Schedule.Schedule;
import mainpkg.Saima.User4_Doctor.Goal3_CheckupSchedule.CheckupSchedule;

/**
 *
 * @author HP
 */
public class Doctor extends User implements Serializable{
    int patientAmount = 0 ;
    String[] checkupSchedule = {"9:00am-12:50pm","2:00pm-5:00pm","6:30pm-9:00pm"} ;
    int volunteerAmount=0;
    String[]ChampingPlace={"plot-1","plot-2","plot-3","plot-5","plot-5"};
    Integer medicineAmount;
    
    
    public Doctor(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
      }

    public int getPatientAmount() {
        return patientAmount;
    }

    public void setPatientAmount(int patientAmount) {
        this.patientAmount = patientAmount;
    }

    public String[] getCheckupSchedule() {
        return checkupSchedule;
    }

    public void setCheckupSchedule(String[] checkupSchedule) {
        this.checkupSchedule = checkupSchedule;
    }

    public int getVolunteerAmount() {
        return volunteerAmount;
    }

    public void setVolunteerAmount(int volunteerAmount) {
        this.volunteerAmount = volunteerAmount;
    }

    public String[] getChampingPlace() {
        return ChampingPlace;
    }

    public void setChampingPlace(String[] ChampingPlace) {
        this.ChampingPlace = ChampingPlace;
    }

    public Integer getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(Integer medicineAmount) {
        this.medicineAmount = medicineAmount;
    }

    @Override
    public String toString() {
        return "Doctor{" + "patientAmount=" + patientAmount + ", checkupSchedule=" + checkupSchedule + ", volunteerAmount=" + volunteerAmount + ", ChampingPlace=" + ChampingPlace + ", medicineAmount=" + medicineAmount + '}';
    }
    
    

  
    public Report report(String subject , String des , Date doa) {
    Report rep = new Report(subject , des , doa) ;
    return rep ;
    }
    
    public Medicine medicineInfo(String id , ObservableList<Medicine> list) {
        for (Medicine medi: list) {
            if (medi.getId() == id) {
                return medi ;
            }
        }
        return null ;
    }
    
    public Medicine addMedicine(String id,String name, Integer medicineAmount, Date date) {
        Medicine medi = new Medicine(id,name, medicineAmount, date) ;
        this.setMedicineAmount(this.getMedicineAmount()+1);
        return medi ;
    }
    
    public RequestedItems requestExtraMedicine(int id , String userType , String name, int amount, Date apply, Date deadline) {
        RequestedItems req = new RequestedItems(id , userType , name, amount, apply, deadline) ;
        return req ;
    }
    
    public RequestedVolunteer requestForVolunteer(int requesterId, String requesterName , int amount, String reason, String description, String userType, String time, String place, Date date) {
        RequestedVolunteer rq = new RequestedVolunteer(requesterId, requesterName , amount, reason, description, userType, time, place, date) ;
        return rq ;
    }
    
    public Campaign requestForMedicalCampaign(String time, String place, String subject, String userType, String des, String senderName, Date date, int senderId) {
        Campaign cam = new Campaign(time,  place,  subject,  userType, des, senderName, date, senderId) ;
        return cam ;
    }
    
   public CheckupSchedule maintainCheckupSchedule(String appointmentId, String refugeeId, String name, String gender, Date checkupDate, String checkupTime) {
        CheckupSchedule schedule = new CheckupSchedule(appointmentId, refugeeId, name, gender, checkupDate, checkupTime);
   
        return schedule;
  
    }
   
    public Holiday requestExtraHoliday(int userId, String userType , String reason, Date startDate, Date endDate) {
        Holiday req = new Holiday(userId,  userType,  reason,  startDate, endDate) ;
        return req ;
   
   };

    public Campaign requestForCampaign(String time, String place, String reason, String userType, String des, String name, Date date, int id) {
       Campaign req=new Campaign(time,place,reason,userType,des,name,date,id);

    public CheckupSchedule scheduleInfo(String value, ObservableList<CheckupSchedule> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    public Patient patientInfo(String toString, ObservableList<Patient> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
   
   
}
