package mainpkg.Rasel.CampManager.Goal7_AllRequests;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class Campaign {
    String time , place , subject , id ;
    Date date ;

    public Campaign(String time, String place, String subject , Date date) {
        this.time = time;
        this.place = place;
        this.subject = subject;
        this.date = date;
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

    public void setTime(String time) {
        this.time = time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void generateId() {
        String id = "Cam" ;
        id += this.getSubject().substring(this.getSubject().length() - 3) ;
        id += this.date.toString().substring(0 , 2) ;
        
        this.id = id;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Campaign{" + "time=" + time + ", place=" + place + ", subject=" + subject + ", id=" + id + '}';
    }
    
}
