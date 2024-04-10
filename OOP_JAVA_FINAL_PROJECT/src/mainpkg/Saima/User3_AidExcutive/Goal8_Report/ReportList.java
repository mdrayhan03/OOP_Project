package mainpkg.Saima.User3_AidExcutive.Goal8_Report;


public class ReportList {
    Integer senderId , receiverId ;
    String siId , id ;

    public ReportList(Integer senderId, Integer receiverId, String siId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.siId = siId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public String getSiId() {
        return siId;
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

    public void setSiId(String siId) {
        this.siId = siId;
    }

    public void generateId() {
        String id = "SIR" ;
        id += this.senderId + this.receiverId / 100000;
        id += this.siId.substring(5) ;
        
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReportList{" + "senderId=" + senderId + ", receiverId=" + receiverId + ", siId=" + siId + ", id=" + id + '}';
    }
    
    
    
}
