package mainpkg.AbstractClass;

import java.io.Serializable;

/**
 *
 * @author RayhaN
 */
public class Date implements Serializable{
    int dd , mm , yyyy ;

    public Date(int dd, int mm, int yyyy) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
    }

    public int getDd() {
        return dd;
    }

    public int getMm() {
        return mm;
    }

    public int getYyyy() {
        return yyyy;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public void setYyyy(int yyyy) {
        this.yyyy = yyyy;
    }

    @Override
    public String toString() {
        return dd + "/" + mm + "/" + yyyy;
    }
    
    public boolean isValid() {
        boolean rtn = false ;
        int lp = 0 ;
        
        if (yyyy % 4 == 0 && yyyy % 100 == 0) {
            if (yyyy % 400 != 0) {
                lp = 29 ;
            }
            else {
                lp = 28 ;
            }
        }
        
        switch (mm) {
            case 2:
                rtn = dd <= lp && 0 < dd ;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                rtn = dd <= 31 && dd > 0 ;
                break;
            default:
                rtn = dd <= 30 && dd > 0 ;
                break;
        }
        return rtn ;
    }
}
