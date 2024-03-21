package mainpkg.AbstractClass;

/**
 *
 * @author RayhaN
 */
public class Holiday {
    int userId ;
    String reason , holidayid ;
    String startDate , endDate ;

    public Holiday(int userId, String reason, String startDate, String endDate) {
        this.userId = userId;
        this.reason = reason;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getHolidayid() {
        return holidayid;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setHolidayid(String holidayid) {
        this.holidayid = this.generateId();
    }
    
    protected String generateId() {
        String holidayId = "" ;
        int id = this.userId % 1000 ;
        String start = this.startDate ;
        holidayid = "H" + id + start ;
        
        return holidayId ;
    }
    
}
