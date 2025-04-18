package mainpkg.Rayhan.User5.Goal8_Report;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class Report implements Serializable{
    Integer senderId , receiverId ;
    String subject , description , id ;
    Date applyDate ;

    public Report(String subject, String description, Date applyDate) {
        this.subject = subject;
        this.description = description;
        this.applyDate = applyDate;
        this.id = this.generateId() ;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
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

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public String generateId() {
        String id = "SI" ;
        id += this.subject.substring(this.subject.length()-3) ;
        id += this.description.substring(5, 9) ;
        
        return id;
    }

    @Override
    public String toString() {
        return "Report{" + "subject=" + subject + "\ndescription=" + description + "\napplyDate=" + applyDate + '}';
    }
    
    
    
}
