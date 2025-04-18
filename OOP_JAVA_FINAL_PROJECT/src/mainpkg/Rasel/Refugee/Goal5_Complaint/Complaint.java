/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rasel.Refugee.Goal5_Complaint;

import java.io.Serializable;

/**
 *
 * @author synt4x_err0r
 */
public class Complaint implements Serializable {
    String refugeeID, name, description;

    public Complaint(){
    }
            
    public Complaint(String name, String description, String refugeeID) {
        this.name = name;
        this.description = description;
        this.refugeeID = refugeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRefugeeID() {
        return refugeeID;
    }

    public void setRefugeeID(String refugeeID) {
        this.refugeeID = refugeeID;
    }

    @Override
    public String toString() {
        return "Complaint{" + "name=" + name + ", description=" + description + ", refugeeID=" + refugeeID + '}';
    }
    
    
}
