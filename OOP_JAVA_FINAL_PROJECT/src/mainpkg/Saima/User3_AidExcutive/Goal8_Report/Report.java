/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal8_Report;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class Report {
    String subject , description , id ;
    Date applyDate ;

    public Report(String subject, String description, Date applyDate) {
        this.subject = subject;
        this.description = description;
        this.applyDate = applyDate;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public Date getApplyDate() {
        return applyDate;
    }
    
    public String getId() {
        return id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
    
    public void generateId() {
        String id = "SI" ;
        id += this.subject.substring(this.subject.length()-3) ;
        id += this.description.substring(5, 9) ;
        
        this.id = id;
    }

    @Override
    public String toString() {
        return "Report{" + "subject=" + subject + "\ndescription=" + description + "\napplyDate=" + applyDate + '}';
    }
    
    
    
}
