package mainpkg.Rayhan.User6.Goal7_Storage;

/**
 *
 * @author RayhaN
 */
public class EducationCoordinatorStorage {
    int sBook , sNote , sPen , sPencil , sRubber , sPencilBox , sGeometryBox ;
    int dBook , dNote , dPen , dPencil , dRubber , dPencilBox , dGeometryBox ;

    public EducationCoordinatorStorage() {
        this.sBook = 0;
        this.sNote = 0;
        this.sPen = 0;
        this.sPencil = 0;
        this.sRubber = 0;
        this.sPencilBox = 0;
        this.sGeometryBox = 0;
        this.dBook = 0;
        this.dNote = 0;
        this.dPen = 0;
        this.dPencil = 0;
        this.dRubber = 0;
        this.dPencilBox = 0;
        this.dGeometryBox = 0;
    }

    public int getsBook() {
        return sBook;
    }

    public int getsNote() {
        return sNote;
    }

    public int getsPen() {
        return sPen;
    }

    public int getsPencil() {
        return sPencil;
    }

    public int getsRubber() {
        return sRubber;
    }

    public int getsPencilBox() {
        return sPencilBox;
    }

    public int getsGeometryBox() {
        return sGeometryBox;
    }

    public int getdBook() {
        return dBook;
    }

    public int getdNote() {
        return dNote;
    }

    public int getdPen() {
        return dPen;
    }

    public int getdPencil() {
        return dPencil;
    }

    public int getdRubber() {
        return dRubber;
    }

    public int getdPencilBox() {
        return dPencilBox;
    }

    public int getdGeometryBox() {
        return dGeometryBox;
    }

    public void setsBook(int sBook) {
        this.sBook = sBook;
    }

    public void setsNote(int sNote) {
        this.sNote = sNote;
    }

    public void setsPen(int sPen) {
        this.sPen = sPen;
    }

    public void setsPencil(int sPencil) {
        this.sPencil = sPencil;
    }

    public void setsRubber(int sRubber) {
        this.sRubber = sRubber;
    }

    public void setsPencilBox(int sPencilBox) {
        this.sPencilBox = sPencilBox;
    }

    public void setsGeometryBox(int sGeometryBox) {
        this.sGeometryBox = sGeometryBox;
    }

    public void setdBook(int dBook) {
        this.dBook = dBook;
    }

    public void setdNote(int dNote) {
        this.dNote = dNote;
    }

    public void setdPen(int dPen) {
        this.dPen = dPen;
    }

    public void setdPencil(int dPencil) {
        this.dPencil = dPencil;
    }

    public void setdRubber(int dRubber) {
        this.dRubber = dRubber;
    }

    public void setdPencilBox(int dPencilBox) {
        this.dPencilBox = dPencilBox;
    }

    public void setdGeometryBox(int dGeometryBox) {
        this.dGeometryBox = dGeometryBox;
    }
    
    public void add(String str , int amount) {
        if (null != str) switch (str) {
            case "Book":
                this.setsBook(this.getsBook() + amount);
                break;
            case "Note":
                this.setsNote(this.getsNote() + amount);
                break;
            case "Pen":
                this.setsPen(this.getsPen() + amount);
                break;
            case "Pencil":
                this.setsPencil(this.getsPencil() + amount);
                break;
            case "Rubber":
                this.setsRubber(this.getsRubber() + amount);
                break;
            case "Pencil Box":
                this.setsPencilBox(this.getsPencilBox() + amount);
                break;
            case "Geometry Box":
                this.setsGeometryBox(this.getsGeometryBox()+ amount);
                break;
            default:
                break;
        }
    }
    
    public void update(String str , int amount) {
        if (null != str) switch (str) {
            case "Book":
                this.setsBook(this.getsBook() - amount);
                break;
            case "Note":
                this.setsNote(this.getsNote() - amount);
                break;
            case "Pen":
                this.setsPen(this.getsPen() - amount);
                break;
            case "Pencil":
                this.setsPencil(this.getsPencil() - amount);
                break;
            case "Rubber":
                this.setsRubber(this.getsRubber() - amount);
                break;
            case "Pencil Box":
                this.setsPencilBox(this.getsPencilBox() - amount);
                break;
            case "Geometry Box":
                this.setsGeometryBox(this.getsGeometryBox() - amount);
                break;
            default:
                break;
        }
        
        if (null != str) switch (str) {
            case "Book":
                this.setdBook(this.getdBook() + amount);
                break;
            case "Note":
                this.setdNote(this.getdNote() + amount);
                break;
            case "Pen":
                this.setdPen(this.getdPen() + amount);
                break;
            case "Pencil":
                this.setdPencil(this.getdPencil() + amount);
                break;
            case "Rubber":
                this.setdRubber(this.getdRubber() + amount);
                break;
            case "Pencil Box":
                this.setdPencilBox(this.getdPencilBox() + amount);
                break;
            case "Geometry Box":
                this.setdGeometryBox(this.getdGeometryBox()+ amount);
                break;
            default:
                break;
        }
    }
    
    
}
