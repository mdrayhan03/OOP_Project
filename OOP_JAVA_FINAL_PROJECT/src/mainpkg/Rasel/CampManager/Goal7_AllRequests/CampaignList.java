package mainpkg.Rasel.CampManager.Goal7_AllRequests;

/**
 *
 * @author RayhaN
 */
public class CampaignList {
    int senderId , receiverId ;
    String campaignId , id , status ;

    public CampaignList(int senderId, int receiverId, String campaignId, String userType) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.campaignId = campaignId;
        this.id = campaignId ; 
        this.status = "Pending" ;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public String getCampaignId() {
        return campaignId;
    }


    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CampaignList{" + "senderId=" + senderId + ", receiverId=" + receiverId + ", campaignId=" + campaignId + ", id=" + id + '}';
    }
      
    
    
}
