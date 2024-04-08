package mainpkg.Rayhan.User5.Goal1_Volunteer;

import java.io.Serializable;

/**
 *
 * @author RayhaN
 */

public class Volunteer implements Serializable {
    String id , name , phoneN , addedBy ;
    int addedById ;

    public Volunteer(String name, String pN, String addedBy , int addedById) {
        this.name = name;
        this.phoneN = pN;
        this.addedBy = addedBy;
        this.addedById = addedById ;
        this.id = this.generateId() ;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getphoneN() {
        return phoneN;
    }

    public String getAddedBy() {
        return addedBy;

    }

    public int getAddedById() {
        return addedById;
    }

    private String generateId() {
        String id = "Vol" ;
        id += name.substring(0) ;
        id += phoneN.substring(9) ;
        id += name.length() ;
        
        return id ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setphoneN(String pN) {
        this.phoneN = pN;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddedById(int addedById) {
        this.addedById = addedById;
    }

    @Override
    public String toString() {
        return "Volunteer{" + "id=" + id + ", name=" + name + ", phoneN=" + phoneN + ", addedBy=" + addedBy + ", addedById=" + addedById + '}';
    }


    
    
}
