package mainpkg.AbstractClass;

import java.io.Serializable;

/**
 *
 * @author RayhaN
 */
public class Holiday implements Serializable{
    int userId ;
    String reason , holidayid , usertType , status , id ;
    Date startDate , endDate ;

    public Holiday(int userId, String userType , String reason, Date startDate, Date endDate) {
        this.userId = userId;
        this.usertType = userType ;
        this.reason = reason;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = this.generateId() ;
        this.status = "Pending" ;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsertType() {
        return usertType;
    }

    public String getReason() {
        return reason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getHolidayid() {
        return holidayid;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsertType(String usertType) {
        this.usertType = usertType;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setHolidayid(String holidayid) {
        this.holidayid = this.generateId();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    protected String generateId() {
        String id = "Hd" ;
        id += Integer.toString(this.getUserId()).substring(4) ;
        id += this.getUsertType().substring(0 , 3) ;       
        
        return id ;
    }
    
}
