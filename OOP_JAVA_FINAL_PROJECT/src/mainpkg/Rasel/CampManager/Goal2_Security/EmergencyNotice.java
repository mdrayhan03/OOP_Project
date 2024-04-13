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
    private String notice;
    private Date noticeDate;
    private Integer  userId, managerId;

    public EmergencyNotice(String notice, Date noticeDate, Integer userId, Integer managerId) {
        this.notice = notice;
        this.noticeDate = noticeDate;
        this.userId = userId;
        this.managerId = managerId;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
    
    public String generateId() {
        Random r=new Random();
        String noticeID = "" ;
        for(int i=0;i<6;i++){
        noticeID+=r.nextInt(6);
        }
        
        return noticeID;
        }

    @Override
    public String toString() {
        return "EmergencyNotice{" + "notice=" + notice + ", noticeDate=" + noticeDate + ", userId=" + userId + ", managerId=" + managerId + '}';
    }
    
    
    
    
}
