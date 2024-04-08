package mainpkg.Rayhan.User6.Goal4_Student;

/**
 *
 * @author RayhaN
 */
public class Course {
    String id , name ; 
    int tC , tHW ;

    public Course(String name, int tC, int tHW) {
        this.name = name;
        this.tC = tC;
        this.tHW = tHW;
        this.id = this.generateId() ;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int gettC() {
        return tC;
    }

    public int gettHW() {
        return tHW;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void settC(int tC) {
        this.tC = tC;
    }

    public void settHW(int tHW) {
        this.tHW = tHW;
    }
    
    public String generateId() {
        String id = null ;
        id += this.getName().substring(0, 4) ;
        int i = this.gettC() + this.gettHW() * 1000 ;
        id += Integer.toString(i).substring(0 , 2) ;
        
        return id ;
    }

    @Override
    public String toString() {
        return "Course Id=" + id + "\nname=" + name + "\ntC=" + tC + "\ntHW=" + tHW ;
    }
    
    
}
