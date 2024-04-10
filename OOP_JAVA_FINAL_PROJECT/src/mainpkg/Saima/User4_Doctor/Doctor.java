/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User4_Doctor;

import java.io.Serializable;
import mainpkg.AbstractClass.User;

/**
 *
 * @author HP
 */
public class Doctor extends User implements Serializable{
    int patientAmount = 0 ;
    String[] checkupSchedule = {"9:00am-12:50pm","2:00pm-5:00pm","6:30pm-9:00pm"} ;
    int volunteerAmount=0;
    String[]ChampingPlace={"plot-1","plot-2","plot-3","plot-5","plot-5"};
    
    
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

    @Override
    public String toString() {
        return "Doctor{" + "patientAmount=" + patientAmount + ", checkupSchedule=" + checkupSchedule + ", volunteerAmount=" + volunteerAmount + ", ChampingPlace=" + ChampingPlace + '}';
    }
      
}
