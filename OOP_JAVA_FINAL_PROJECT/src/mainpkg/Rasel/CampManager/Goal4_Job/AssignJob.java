/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal4_Job;

/**
 *
 * @author synt4x_err0r
 */
public class AssignJob {
    int id;
    int jobID;
    boolean isAssigned;

    public AssignJob(int id, int jobID, boolean isAssigned) {
        this.id = id;
        this.jobID = jobID;
        this.isAssigned = isAssigned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public boolean isIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(boolean isAssigned) {
        this.isAssigned = isAssigned;
    }

    @Override
    public String toString() {
        return "AssignJob{" + "id=" + id + ", jobID=" + jobID + ", isAssigned=" + isAssigned + '}';
    }
    
    
    
    
}
