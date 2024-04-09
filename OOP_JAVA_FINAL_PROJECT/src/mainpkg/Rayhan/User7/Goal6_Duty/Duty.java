package mainpkg.Rayhan.User7.Goal6_Duty;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class Duty {
    String time , place , id;
    int amount ;
    Date date ;

    public Duty(String time, String place, int amount, Date date) {
        this.time = time;
        this.place = place;
        this.amount = amount;
        this.date = date;
        this.id = this.generateId() ;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    private String generateId() {
        String id = "Dt" ;
        id += Integer.toString(this.getDate().getDd()) ;
        id += Integer.toString(this.getDate().getMm()) ;
        id += Integer.toString(this.getAmount()) ;
        
        return id ;
    }
}
