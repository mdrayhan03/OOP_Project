package mainpkg.Rayhan.User8.Goal4_Donation;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class Donation {
    Integer donerid , amount ;
    String name , id ;
    Date date ;

    public Donation(Integer donerid, Integer amount, String name, Date date) {
        this.donerid = donerid;
        this.amount = amount;
        this.name = name;
        this.date = date;
        this.id = this.generateId() ;
    }

    public Integer getDonerid() {
        return donerid;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDonerid(Integer donerid) {
        this.donerid = donerid;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Donation{" + "donerid=" + donerid + ", amount=" + amount + ", name=" + name + ", id=" + id + ", date=" + date + '}';
    }
    
    private String generateId() {
        String id = "Don" ;
        id += Integer.toString(this.getDonerid()).substring(4) ;
        id += this.getName().substring(2 , 4) ;
        
        return id ;
    }
}
