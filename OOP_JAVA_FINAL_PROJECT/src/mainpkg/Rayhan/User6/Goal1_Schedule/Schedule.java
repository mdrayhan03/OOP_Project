package mainpkg.Rayhan.User6.Goal1_Schedule;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;

/**
 *
 * @author RayhaN
 */
public class Schedule implements Serializable{
    String id , teacherId , teacherName , courseId , courseName , time , place ;
    Date date ;

    public Schedule(String teacherId, String teacherName, String courseId, String courseName, String time, String place, Date date) {
        this.id = this.generateId() ;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.time = time;
        this.place = place;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public Date getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String generateId() {
        String id = "Sch" ;
        id += this.getTeacherId().substring(this.getTeacherId().length() - 2) ;
        id += this.getCourseId().substring(this.getCourseId().length() - 2) ;
        id += this.place.substring(4) ;
        
        return id ;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", teacherId=" + teacherId + ", teacherName=" + teacherName + ", courseId=" + courseId + ", courseName=" + courseName + ", time=" + time + ", place=" + place + ", date=" + date + '}';
    }
    
}
