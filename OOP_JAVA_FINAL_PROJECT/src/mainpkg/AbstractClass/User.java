package mainpkg.AbstractClass;

import java.util.ArrayList;
import javafx.collections.ObservableList;


/**
 *
 * @author RayhaN
 */
public abstract class User {
    int id ;
    String name , password , phoneNo , email , userType , gender , status = "Deactive" ;
    String dob ;
    ObservableList<Holiday> holidayList ;

    public User(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phoneNo = phoneNo;
        this.email = email;
        this.userType = userType;
        this.gender = gender;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", password=" + password + ", phoneNo=" + phoneNo + ", email=" + email + ", userType=" + userType + ", gender=" + gender + ", status=" + status + ", dob=" + dob + ", holidayList=" + holidayList + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setHolidayList(ObservableList<Holiday> holidayList) {
        this.holidayList = holidayList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public String getDob() {
        return dob;
    }

    public ObservableList<Holiday> getHolidayList() {
        return holidayList;
    }

    
    public User verifyLogin(int id , String pw) {
        return this ;
    }
    
    public boolean changePassword(String oldPw , String newPw) {
        String old = this.getPassword() ;
        
        if (old.equals(oldPw)) {
            this.setPassword(newPw);
            return true ;
        }
        return false ;        
    }
    
    public boolean forgetPassword(int id , String userType , String phoneNo , String newPw , String confirmPw) {
        if (this.id == id && this.userType.equals(userType) && this.phoneNo.equals(phoneNo)) {
            if(newPw.equals(confirmPw)) {
                this.setPassword(newPw);
                return true ;
            }
        }
        return false ;
    }
    
    public boolean requestToLeave(String reason , Date start , Date end) {
        Integer userId = this.getId() ;
        String userType = this.getUserType() ;
        Holiday holi = new Holiday(userId , userType , reason , start , end) ;
        System.out.println(holi) ;
        this.holidayList.add(holi) ;
        return true ;
    }
}
