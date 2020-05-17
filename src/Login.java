import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login = (Login) o;
        return Objects.equals(getUserID(), login.getUserID()) &&
                Objects.equals(getPassword(), login.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getPassword());
    }

    public String toString() {
        return "Login:" +
                userID + "," +
                password;
    }

    public static Login insereLogin(String linha,Sistema s){
        Login l = new Login();
        String [] auxiliar = linha.split(",",2);

        l.setUserID(auxiliar[0]);
        l.setPassword(auxiliar[1]);
        //System.out.println(l.toString());
        Sistema.insereLogin(l,s);
        return l;
    }

}
