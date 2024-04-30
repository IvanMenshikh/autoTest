package Data;

public class Users {
    String loginUser118;
    String passwordUser118;

    public String getLoginUser118(){
        if(loginUser118 == null){
            loginUser118 = "Smoke_user118";
        }
        return loginUser118;
    }
    public  String getPasswordUser118(){
        if(passwordUser118 == null){
            passwordUser118 = "";
        }
        return passwordUser118;
    }
}