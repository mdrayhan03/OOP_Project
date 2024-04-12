package mainpkg.Rayhan.User5.Goal2_SIReport;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class SIReport implements Serializable {
    String subject , description , id ;
    Integer senderId , receiverId ;
    Date applyDate ;

    public SIReport(String subject, Integer senderId, Integer receiverId, String des ,Date applyDate) {
        this.subject = subject;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.description = des;
        this.applyDate = applyDate;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
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
