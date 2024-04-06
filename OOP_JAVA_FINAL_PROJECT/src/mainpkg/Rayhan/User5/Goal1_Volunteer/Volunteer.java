package mainpkg.Rayhan.User5.Goal1_Volunteer;

<<<<<<< HEAD
=======
import java.io.Serializable;

>>>>>>> Rayhan
/**
 *
 * @author RayhaN
 */
<<<<<<< HEAD
public class Volunteer {
    String name , pN , id ;

    public Volunteer(String name, String pN) {
        this.name = name ;
        this.pN = pN ;
        this.generateId() ;
    }

    public String getName() {
        return name ;
    }

    public String getpN() {
        return pN ;
    }

    public String getId() {
        return id ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public void setpN(String pN) {
        this.pN = pN ;
=======
public class Volunteer implements Serializable {
    String id , name , phoneN , addedBy ;

    public Volunteer(String name, String pN, String addedBy) {
        this.name = name;
        this.phoneN = pN;
        this.addedBy = addedBy;
        this.generateId() ;
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
>>>>>>> Rayhan
    }

    public void generateId() {
        String id = "Vol" ;
<<<<<<< HEAD
        id += this.name.substring(0, 3) ;
        id += this.pN.length() ;
        
        this.id = id ;
=======
        id += name.substring(0) ;
        id += phoneN.substring(9) ;
        id += name.length() ;
        
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setpN(String pN) {
        this.phoneN = pN;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
>>>>>>> Rayhan
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Volunteer{" + "name=" + name + ", pN=" + pN + ", id=" + id + '}' ;
=======
        return "Volunteer{" + "id=" + id + ", name=" + name + ", pN=" + phoneN + ", addedBy=" + addedBy + '}';
>>>>>>> Rayhan
    }
    
    
}
