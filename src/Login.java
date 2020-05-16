public class Login {
    private String userID;
    private String password;

    //Construtor Vazio
    public Login(){
        this.userID = " ";
        this.password = " ";
    }

    //Construtor por parametro
    public Login(String userID,String password) {
        this.userID = userID;
        this.password = password;
    }

    //Construtor por cópia
    public Login(Login conta){
        this.userID = conta.getUserID();
        this.password = conta.getPassword();
    }

    //Getters
    public String getUserID() {
        return this.userID;
    }

    public String getPassword() {
        return this.password;
    }

    //Setters
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login clone(){
        return new Login(this);
    }

    public boolean equals (Object obj) {
        if (obj==this) return true;
        if (obj==null || obj.getClass()!=this.getClass()) return false;
        Login c = (Login) obj;
        return  this.userID.equals(c.getUserID())&&
                this.password.equals(c.getPassword());
    }

    public String toString() {
        return "Login:" +
                userID + "," +
                password;
    }

    public static Login insereLogin(String linha){
        Login l = new Login();
        String [] auxiliar = linha.split(",",2);

        l.setUserID(auxiliar[0]);
        l.setPassword(auxiliar[1]);
        return l;
    }

}
