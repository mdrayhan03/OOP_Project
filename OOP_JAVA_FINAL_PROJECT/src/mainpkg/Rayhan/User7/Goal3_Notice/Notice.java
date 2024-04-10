package mainpkg.Rayhan.User7.Goal3_Notice;

import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class Notice {
    String reason , des , id , reply ;
    Date date ;

    public Notice(String reason, String des, String reply, Date date) {
        this.reason = reason;
        this.des = des;
        this.reply = "" ;
        this.date = date;
        this.id = this.generateId() ;
    }

    public String getReason() {
        return reason;
    }

    public String getDes() {
        return des;
    }

    public String getId() {
        return id;
    }

    public String getReply() {
        return reply;
    }

    public Date getDate() {
        return date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notice{" + "reason=" + reason + ", des=" + des + ", id=" + id + ", reply=" + reply + ", date=" + date + '}';
    }
    
    private String generateId() {
        String id = "Nc" ;
        id += this.getDate().toString().substring(0 , 2) ;
        id += this.getReason().substring(this.getReason().length() - 2) ;
        id += this.getDes().substring(this.getDes().length() - 2) ;
        
        return id ;
    }
    
}
