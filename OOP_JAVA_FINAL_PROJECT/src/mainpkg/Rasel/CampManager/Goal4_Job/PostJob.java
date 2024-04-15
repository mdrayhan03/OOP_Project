/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal4_Job;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author synt4x_err0r
 */
public class PostJob implements Serializable {
    
    int jobID;
    private String jobName, jobDescription;
    private Integer vacancy;

    public PostJob(int jobID, String jobName, String jobDescription, Integer vacancy) {
        this.jobID = jobID;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.vacancy = vacancy;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Integer getVacancy() {
        return vacancy;
    }

    public void setVacancy(Integer vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public String toString() {
        return "PostJob{" + "jobID=" + jobID + ", jobName=" + jobName + ", jobDescription=" + jobDescription + ", vacancy=" + vacancy + '}';
    }
    
    
    public int generateId() {
        Random r=new Random();
        for(int i=0;i<8;i++){
        jobID+=r.nextInt(9);
        }
        
        return jobID;
        }
    
    
    
    
}
