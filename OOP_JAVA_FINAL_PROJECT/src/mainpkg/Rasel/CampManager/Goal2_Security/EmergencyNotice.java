/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal2_Security;

import java.io.Serializable;
import java.util.Random;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author synt4x_err0r
 */
public class EmergencyNotice implements Serializable {
    
    private String Subject, notice;
    private String noticeDate;

    public EmergencyNotice(String Subject, String notice, String noticeDate) {
        this.Subject = Subject;
        this.notice = notice;
        this.noticeDate = noticeDate;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }

    @Override
    public String toString() {
        return "EmergencyNotice{" + "Subject=" + Subject + ", notice=" + notice + ", noticeDate=" + noticeDate + '}';
    }
    
    

   
}
