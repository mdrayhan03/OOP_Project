package mainpkg.Rayhan.User5.Goal6_Campaign;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class CampaignTableView {
    String id , subject , time , place , des , status ;
    Date date ;

    public CampaignTableView(String id, String subject, String time, String place, String des, String status, Date date) {
        this.id = id;
        this.subject = subject;
        this.time = time;
        this.place = place;
        this.des = des;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getDes() {
        return des;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CampaignTableView{" + "id=" + id + ", subject=" + subject + ", time=" + time + ", place=" + place + ", des=" + des + ", status=" + status + ", date=" + date + '}';
    }
    
    
}
