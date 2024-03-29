package mainpkg.AbstractClass;

import java.util.ArrayList;


/**
 *
 * @author RayhaN
 */
public abstract class User {
    int id ;
    String name , password , phoneNo , email , userType , status = "Deactive" ;
    String dob ;
    ArrayList<String> holidayList ;

    public User(int id, String name, String password, String phoneNo, String email, String userType , String dob) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phoneNo = phoneNo;
        this.email = email;
        this.userType = userType;
        this.dob = dob;
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

    public String getDob() {
        return dob;
    }
    
    public String getStatus() {
        return status;
    }

    public ArrayList<String> getHolidayList() {
        return holidayList;
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

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHolidayList(ArrayList<String> holidayList) {
        this.holidayList = holidayList;
    }
    
    public void setHoliday(String holi) {
        this.holidayList.add(holi) ;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", password=" + password + ", phoneNo=" + phoneNo + ", email=" + email + ", userType=" + userType + ", status=" + status + ", dob=" + dob + ", holidayList=" + holidayList + '}';
    }

    
    public User verifyLogin(int id , String pw) {
        int userId = this.getId() ;
        String userPw = this.getPassword() ;
        if (userId == id && userPw.equals(pw)) {
            this.setStatus("Active") ;
            return this ;
        }
        return null ;
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
    
    public boolean requestToLeave(String reason , String start , String end) {
        int userId = this.getId() ;
        Holiday holi = new Holiday(userId , reason , start , end) ;
        this.holidayList.add(holi.holidayid) ;
        return true ;
    }
}
