package mainpkg.Rayhan.User6;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.RequestedItems;
import mainpkg.Rayhan.User5.Goal4_VRequest.RequestedVolunteer;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User6.Goal1_Schedule.Schedule;
import mainpkg.Rayhan.User6.Goal2_Teacher.Teacher;
import mainpkg.Rayhan.User6.Goal4_Student.Course;
import mainpkg.Rayhan.User6.Goal7_Storage.EducationCoordinatorStorage;

/**
 *
 * @author RayhaN
 */
public class EducationCoordinator extends User implements Serializable {
    int teacherAmount = 0 ;
    int studentAmount = 0 ;

    public EducationCoordinator(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
    }

    public int getTeacherAmount() {
        return teacherAmount;
    }

    public int getStudentAmount() {
        return studentAmount;
    }

    public void setTeacherAmount(int teacherAmount) {
        this.teacherAmount += teacherAmount;
    }

    public void setStudentAmount(int studentAmount) {
        this.studentAmount += studentAmount;
    }

    @Override
    public String toString() {
        return "EducationCoordinator{" + "teacherAmount=" + teacherAmount + ", studentAmount=" + studentAmount + '}';
    }
    
        /**
     *
     * @param id
     * @param pw
     * @return
     */
    @Override
    public EducationCoordinator verifyLogin(int id , String pw) {
        int userId = this.getId() ;
        String userPw = this.getPassword() ;
        if (userId == id && userPw.equals(pw)) {
            this.setStatus("Active") ;
            return this ;
        }
        return null ;
    }
    
    public Schedule maintainSchedule(String teacherId, String teacherName, String courseId, String courseName, String time, String place, Date date) {
        Schedule sc = null ;
        return sc ;       
    }
    public boolean checkSchedule(Schedule one , Schedule two) {
        Boolean rtn = true ;
        if(one.getDate() == two.getDate() && one.getTime().equals(two.getTime()) && one.getPlace().equals(two.getPlace())) {
            rtn = false ;
        }
        return rtn ;
    }
    public Teacher addTeacher(String name, String pN, Date doj) {
        Teacher tc = new Teacher(name, pN, doj) ;
        this.setTeacherAmount(this.getTeacherAmount() + 1) ;
        return tc ;
    }

    public RequestedVolunteer requestForVolunteer(int requesterId, String requesterName , int amount, String reason, String description, String userType, String time, String place, Date date) {
        RequestedVolunteer rq = new RequestedVolunteer(requesterId, requesterName , amount, reason, description, userType, time, place, date) ;
        return rq ;
    }
    
    public Course addCourse(String name, int tC, int tHW) {
        Course co = new Course(name, tC, tHW) ;
        return co ;
    }
//#addStudent():Boolean
//#studentInfo():Boolean
    public RequestedItems request(int id , String userType , String name, int amount, Date apply, Date deadline) {
        RequestedItems req = new RequestedItems(id , userType , name, amount, apply, deadline) ;
        return req ;
    }
//#progressReport():String
    public void maintainStorage(EducationCoordinatorStorage s){
//        EducationCoordinatorStorage st = s ;
    }
    public Campaign requestForCampaign(String time, String place, String subject, String userType, String des, String senderName, Date date, int senderId) {
        Campaign cam = new Campaign(time,  place,  subject,  userType, des, senderName, date, senderId) ;
        return cam ;
    }
  
    
    
}
