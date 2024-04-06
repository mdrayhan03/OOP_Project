package mainpkg.Rayhan.User5.Goal2_SIReport;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class SIReport {
    String subject , description , id ;
    Date applyDate ;

    public SIReport(String subject, String description, Date applyDate) {
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
        return "SIReport{" + "subject=" + subject + "\ndescription=" + description + "\napplyDate=" + applyDate + '}';
    }
    
    
    
}