/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rayhan.User5.Goal6_Campaign;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author synt4x_err0r
 */
public class SkillDevelopmentCenter implements Serializable {

    private String workshopName, place, eligibleAge, type, duration;
    private Date date;
    
    public SkillDevelopmentCenter(){
    }
    
    public SkillDevelopmentCenter(String workshopName, String place, String eligibleAge, String type, Date date, String duration) {
        this.workshopName = workshopName;
        this.place = place;
        this.eligibleAge = eligibleAge;
        this.type = type;
        this.date = date;
        this.duration = duration;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEligibleAge() {
        return eligibleAge;
    }

    public void setEligibleAge(String eligibleAge) {
        this.eligibleAge = eligibleAge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "SkillDevelopmentCenter{" + "workshopName=" + workshopName + ", place=" + place + ", eligibleAge=" + eligibleAge + ", type=" + type + ", date=" + date + ", duration=" + duration + '}';
    }
    


    
}
