package mainpkg.Rasel.CampManager.Goal7_AllRequests;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class Campaign {
    String time , place , subject , id , userType  , des , senderName , status ;
    Date date ;
    int senderId ;

    public Campaign(String time, String place, String subject, String userType, String des, String senderName, Date date, int senderId) {
        this.time = time;
        this.place = place;
        this.subject = subject;
        this.userType = userType;
        this.des = des;
        this.senderName = senderName;
        this.date = date;
        this.senderId = senderId;
        this.status = "Pending" ;
        this.id = this.generateId() ;
    }

    

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getSubject() {
        return subject;
    }

    public String getId() {
        return id;
    }


    public Date getDate() {
        return date;
    }

    public String getUserType() {
        return userType;
    }

    public String getDes() {
        return des;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getStatus() {
        return status;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String generateId() {
        String id = "Cam" ;
        id += this.getSubject().substring(this.getSubject().length() - 3) ;
        id += this.date.toString().substring(0 , 2) ;
        
        return id ;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Campaign{" + "time=" + time + ", place=" + place + ", subject=" + subject + ", id=" + id + '}';
    }
    
}
