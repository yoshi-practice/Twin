package e.yoshi1125hisa.litboard;


import java.io.Serializable;

public class Post implements Serializable{

    private String userName , at , mail , pass;
    private String inchX , inchY , inch;
    private String  dpiX , dpiY;
    private String realScreenWidth , realScreenHeight , modelName;
    private String dpX,dpY,realInchX,realInchY,realInch;

    public Post(){

    }

    public Post(String userName,String mail ,String at,String pass, String inch , String inchX , String inchY ,
              String dpiX , String dpiY , String realScreenHeight , String realScreenWidth ,String modelName , String dpX,String dpY
            /*,String realInchX,String realInchY,String realInch*/
            ) {
        this.userName = userName;
        this.at = at;
        this.mail = mail;
        this.pass = pass;
        this.inch = inch;
        this.inchX = inchX;
        this.inchY = inchY;
        this.dpiX = dpiX;
        this.dpiY = dpiY;
        this.realScreenHeight = realScreenHeight;
        this.realScreenWidth = realScreenWidth;
        this.modelName = modelName;
        this.dpX = dpX;
        this.dpY = dpY;
        /*this.realInchX = realInchX;
        this.realInchY = realInchY;
        this.realInch = realInch;
*/
    }

    public String getDpiX() { return  dpiX; }
    public void setDpiX(String dpiX){ this.dpiX = dpiX; }

    public String getDpiY() { return  dpiY; }
    public void setDpiY(String dpiY){ this.dpiY = dpiY; }

    public String getUserName() { return  userName; }
    public void setUserName(String userName){ this.userName = userName; }

    public String getAt() { return  at; }
    public void setAt(String at){ this.at = at; }

    public String getPass() { return  pass; }
    public void setPass(String pass){ this.pass = pass; }

    public String getMail() { return  mail; }
    public void setMail(String mail){ this.mail = mail; }

    public String getInchX() { return  inchX; }
    public void setInchX(String inchX){ this.inchX = inchX; }

    public String getInchY() { return  inchY; }
    public void setInchY(String inchY){ this.inchY = inchY; }

    public String getInch() { return  inch; }
    public void setInch(String inch){ this.inch = inch; }

    public String getRealScreenHeight() {
        return realScreenHeight;
    }
    public void setRealScreenHeight(String realScreenHeight){this.realScreenHeight=realScreenHeight;}

    public String getRealScreenWidth() {
        return realScreenWidth;
    }
    public void setRealScreenWidth(String realScreenWidth){this.realScreenWidth=realScreenWidth;}

    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName){this.modelName=modelName;}

    public String getDpX() { return  dpX; }
    public void setDpX(String dpX){ this.dpX = dpX; }

    public String getDpY() { return  dpY; }
    public void setDpY(String dpY){ this.dpX = dpY; }

 /*   public String getRealInchX() { return  realInchX; }
    public void setRealInchX(String realInchX){ this.realInchX = realInchX; }


    public String getRealInchY() { return  realInchY; }
    public void setRealInchY(String realInchY){ this.realInchY = realInchY; }

    public String getRealInch() { return  realInch; }
    public void setRealInch(String realInch){ this.realInch = realInch; }

*/

}
