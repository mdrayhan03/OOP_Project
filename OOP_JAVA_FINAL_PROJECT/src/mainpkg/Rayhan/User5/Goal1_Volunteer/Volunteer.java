package mainpkg.Rayhan.User5.Goal1_Volunteer;

/**
 *
 * @author RayhaN
 */
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
    }

    public void generateId() {
        String id = "Vol" ;
        id += this.name.substring(0, 3) ;
        id += this.pN.length() ;
        
        this.id = id ;
    }

    @Override
    public String toString() {
        return "Volunteer{" + "name=" + name + ", pN=" + pN + ", id=" + id + '}' ;
    }
    
    
}
