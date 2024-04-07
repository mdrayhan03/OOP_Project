package mainpkg.Rasel.CampManager.Goal7_AllReports;

/**
 *
 * @author RayhaN
 */
public class ReportList {
    Integer senderId , receiverId ;
    String reportId , id ;

    public ReportList(Integer senderId, Integer receiverId, String reportId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.reportId = reportId;
        this.id = reportId ;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public String getReportId() {
        return reportId;
    }

    public String getId() {
        return id;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReportList{" + "senderId=" + senderId + ", receiverId=" + receiverId + ", reportId=" + reportId + ", id=" + id + '}';
    }
    
    
    
}
