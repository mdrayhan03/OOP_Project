/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rasel.Refugee.Goal6_TrainingCenter;

import java.io.Serializable;

/**
 *
 * @author synt4x_err0r
 */
public class TrainingRegistration implements Serializable {
    String name, workshopName, gender;
    int refugeeID;
    
    public TrainingRegistration(){
    }

    public TrainingRegistration(int refugeeID, String name, String workshopName, String gender) {
        this.refugeeID = refugeeID;
        this.name = name;
        this.workshopName = workshopName;
        this.gender = gender;
    }

    public int getRefugeeID() {
        return refugeeID;
    }

    public void setRefugeeID(int refugeeID) {
        this.refugeeID = refugeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "TrainingRegistration{" + "refugeeID=" + refugeeID + ", name=" + name + ", workshopName=" + workshopName + ", gender=" + gender + '}';
    }
    
    
    
    
}
