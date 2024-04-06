package mainpkg.Rayhan.User5.Goal1_Volunteer;

import java.io.Serializable;

/**
 *
 * @author RayhaN
 */
public class Volunteer implements Serializable {
    String id , name , pN , addedBy ;

    public Volunteer(String id, String name, String addedBy) {
        this.id = id;
        this.name = name;
        this.addedBy = addedBy;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getpN() {
        return pN;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void generateId() {
        String id = "Vol" ;
        id += name.substring(0, 3) ;
        id += pN.length() ;
        
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    @Override
    public String toString() {
        return "Volunteer{" + "id=" + id + ", name=" + name + ", pN=" + pN + ", addedBy=" + addedBy + '}';
    }
    
    
}
