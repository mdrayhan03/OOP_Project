package mainpkg.Rayhan.User8.Goal6_Medical;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class MedicalFacilities {
    String name , id , donerName ;
    Integer amount , donerId ;
    Date date ;

    public MedicalFacilities(Integer donerId , String donerName , String name, Integer amount, Date date) {
        this.donerId = donerId ;
        this.donerName = donerName ;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.id = this.generateId() ;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDonerName() {
        return donerName;
    }

    public Integer getDonerId() {
        return donerId;
    }

    public void setDonerName(String donerName) {
        this.donerName = donerName;
    }

    public void setDonerId(Integer donerId) {
        this.donerId = donerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EducationFacilities{" + "name=" + name + ", id=" + id + ", amount=" + amount + ", date=" + date + '}';
    }
    
    private String generateId() {
        String id = "EFc" ;
        id += this.getName().substring(this.getName().length() - 3) ;
        id += Integer.toString(this.getDate().getDd()) ;
        
        return id ;
    }
    
}
