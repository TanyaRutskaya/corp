package Authorization;


public class UserCredentials {
    public String login;
    public String password;

    public UserCredentials(String login, String  password) {this.login = login; this.password= password;}

    //QA user

    public static UserCredentials qaCreds(){

        return new UserCredentials ("admin", "Passwd!123");
    }

}
