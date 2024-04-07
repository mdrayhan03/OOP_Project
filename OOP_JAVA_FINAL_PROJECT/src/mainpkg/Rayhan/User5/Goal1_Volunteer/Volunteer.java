package mainpkg.Rayhan.User5.Goal1_Volunteer;

import java.io.Serializable;

/**
 *
 * @author RayhaN
 */
public class Volunteer implements Serializable {
    String id , name , phoneN , addedBy ;

    public Volunteer(String name, String pN, String addedBy) {
        this.name = name;
        this.phoneN = pN;
        this.addedBy = addedBy;
        this.id = this.generateId() ;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getpN() {
        return phoneN;
    }

    public String getAddedBy() {
        return addedBy;

    }

    public String generateId() {
        String id = "Vol" ;
        id += name.substring(0) ;
        id += phoneN.substring(9) ;
        id += name.length() ;
        
        return id ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setpN(String pN) {
        this.phoneN = pN;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    @Override
    public String toString() {
        return "Volunteer{" + "id=" + id + ", name=" + name + ", pN=" + phoneN + ", addedBy=" + addedBy + '}';
    }
    
    
}
