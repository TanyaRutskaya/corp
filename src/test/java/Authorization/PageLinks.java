package Authorization;//QA env

public class PageLinks {
    public static String qaPageWithCreds(){
        return "https:admin:Passwd!123@qa-site.axamit.com/";
    }
    public static String qaPageTeam(){return "https:admin:Passwd!123@qa-site.axamit.com/company/team/";}
    public static String qaPageContactUs(){return "https:admin:Passwd!123@qa-site.axamit.com/contacts/";}

  //  PROD env
public static String prodHomePage(){
        return "https://axamit.com/";
}
}
