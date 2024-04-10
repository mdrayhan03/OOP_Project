package mainpkg.Rasel.CampManager.Goal7_AllRequests;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class RequestedItems {
    String name , status , id , userType ;
    int amount , senderId ;
    Date apply , deadline ;

    public RequestedItems(int senderId , String userType , String name, int amount, Date apply, Date deadline) {
        this.senderId = senderId ;
        this.userType = userType ;
        this.name = name;
        this.amount = amount;
        this.apply = apply;
        this.deadline = deadline;
        this.id = this.generateId() ;
    }

    public int getSenderId() {
        return senderId;
    }

    public String getUserType() {
        return userType;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public Date getApply() {
        return apply;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setApply(Date apply) {
        this.apply = apply;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RequestedItems{" + "name=" + name + ", status=" + status + ", id=" + id + ", userType=" + userType + ", amount=" + amount + ", senderId=" + senderId + ", apply=" + apply + ", deadline=" + deadline + '}';
    }

    
        
    public String generateId() {
        String id = "ReqI" ;
        id += this.getName().substring(0 , 2) ;
        id += this.getApply().toString().substring(0 , 1) ;
        id += this.getDeadline().toString().substring(0 , 1) ;
        return id ;
    }
    
}
