package mainpkg.Saima.User4_Doctor.Goal5_RequestVolunteer;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class RequestedVolunteer {
    int requesterId , accepterId , amount ;
    String id , reason , description , userType , time , place , status , requesterName ;
    Date date ;

    public RequestedVolunteer(int requesterId, String requesterName , int amount, String reason, String description, String userType, String time, String place, Date date) {
        this.requesterId = requesterId;
        this.requesterName = requesterName ;
        this.amount = amount;
        this.reason = reason;
        this.description = description;
        this.userType = userType;
        this.time = time;
        this.place = place;
        this.date = date;
        this.status = "Pending" ;
        this.id = this.generateId() ;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public int getRequesterId() {
        return requesterId;
    }

    public int getAccepterId() {
        return accepterId;
    }

    public int getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public String getDescription() {
        return description;
    }

    public String getUserType() {
        return userType;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public void setAccepterId(int accepterId) {
        this.accepterId = accepterId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String generateId() {
        String id = "RFV" ;
        id += this.getReason().substring(this.getReason().length() - 3) ;
        id += this.getDate().toString().substring(0,2) ;
        
        return id ;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RequestedVolunteer{" + "requesterId=" + requesterId + ", accepterId=" + accepterId + ", amount=" + amount + ", id=" + id + ", reason=" + reason + ", description=" + description + ", userType=" + userType + ", time=" + time + ", place=" + place + ", status=" + status + ", date=" + date + '}';
    }
    
    
}
