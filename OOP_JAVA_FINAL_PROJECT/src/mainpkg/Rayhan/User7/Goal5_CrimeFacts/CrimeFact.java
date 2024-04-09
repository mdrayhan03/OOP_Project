package mainpkg.Rayhan.User7.Goal5_CrimeFacts;

import java.util.Random;

/**
 *
 * @author RayhaN
 */
public class CrimeFact {
    String id , reporterName , des ;
    Integer reporterId ;

    public CrimeFact(String reporterName, String des, Integer reporterId) {
        this.reporterName = reporterName;
        this.des = des;
        this.reporterId = reporterId;
        this.id = this.generateId() ;
    }

    public String getId() {
        return id;
    }

    public String getReporterName() {
        return reporterName;
    }

    public String getDes() {
        return des;
    }

    public Integer getReporterId() {
        return reporterId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setReporterId(Integer reporterId) {
        this.reporterId = reporterId;
    }

    @Override
    public String toString() {
        return "CrimeFact{" + "id=" + id + ", reporterName=" + reporterName + ", des=" + des + ", reporterId=" + reporterId + '}';
    }
    
    private String generateId() {
        String id = "CF" ;
        id += Integer.toString(this.getReporterId()).substring(3) ;
        id += this.getDes().substring(this.getDes().length() - 2) ;
        return id ;
    }
    
}
