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
    
    private String jobName, jobDescription;
    private Integer vacancy;

    public PostJob(String jobName, String jobDescription, Integer vacancy) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.vacancy = vacancy;
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
        return "PostJob{" + "jobName=" + jobName + ", jobDescription=" + jobDescription + ", vacancy=" + vacancy + '}';
    }
    
    public String generateId() {
        Random r=new Random();
        String jobID = "" ;
        for(int i=0;i<8;i++){
        jobID+=r.nextInt(9);
        }
        
        return jobID;
        }
    
    
    
    
}
