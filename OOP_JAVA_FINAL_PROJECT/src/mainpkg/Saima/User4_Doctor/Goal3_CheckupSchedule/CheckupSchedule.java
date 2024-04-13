/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal3_CheckupSchedule;

import java.util.Random;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author HP
 */
public class CheckupSchedule {
    
    private String appointmentId;
    private String refugeeId;
    private String name;
    private String gender;
    private Date checkupDate;
    private String checkupTime;

    // Constructor
    public CheckupSchedule(String appointmentId, String refugeeId, String name, String gender, Date checkupDate, String checkupTime) {
        this.appointmentId = appointmentId;
        this.refugeeId = refugeeId;
        this.name = name;
        this.gender = gender;
        this.checkupDate = checkupDate;
        this.checkupTime = checkupTime;
    }

    // Getters and setters
    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getRefugeeId() {
        return refugeeId;
    }

    public void setRefugeeId(String refugeeId) {
        this.refugeeId = refugeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(Date checkupDate) {
        this.checkupDate = checkupDate;
    }

    public String getCheckupTime() {
        return checkupTime;
    }

    public void setCheckupTime(String checkupTime) {
        this.checkupTime = checkupTime;
    }

    @Override
    public String toString() {
        return "CheckupSchedule{" + "appointmentId=" + appointmentId + ", refugeeId=" + refugeeId + ", name=" + name + ", gender=" + gender + ", checkupDate=" + checkupDate + ", checkupTime=" + checkupTime + '}';
    }

    private String appoinmentId() {
        Random r=new Random();
        String id = "" ;
        for(int i=0;i<8;i++){
        id+=r.nextInt(10);
        }
        
        return id;
        }

    
}
