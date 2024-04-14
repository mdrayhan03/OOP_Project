
package mainpkg.Rayhan.User6.Goal2_Teacher;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class Teacher implements Serializable{
    String id , name , pN ;
    Date doj ;

    public Teacher(String name, String pN, Date doj) {
        this.name = name;
        this.pN = pN;
        this.doj = doj;
        this.id = this.generateId() ;
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

    public Date getDoj() {
        return doj;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }
    
    public String generateId() {
        String id = "Tec" ;
        id += this.getName().substring(this.getName().length() - 2) ;
        id += this.getpN().substring(3 , 6) ;
        return id ;
    }

    @Override
    public String toString() {
        return "Id=" + id + "\nname=" + name + "\npN=" + pN + "\ndoj=" + doj ;
    }
    
    
}
