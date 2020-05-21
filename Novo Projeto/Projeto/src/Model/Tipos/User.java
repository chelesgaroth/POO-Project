package Model.Tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements IUser  {
    //Variáveis dos Logs.txt
    private String userID;
    private String name;
    private float x_user;
    private float y_user;

    //Variávieis para as Apps
    private List<String> delivery_requests;
    private List<String> delivery_queue;

    /**
     * Construtor por omissão
     */
    public User() {
        //Variáveis do Logs.txt
        this.userID = "n/a";
        this.name = "n/a";
        this.x_user = 0;
        this.y_user = 0;

        //Variáveis para as Apps
        this.delivery_requests = new ArrayList<>();
        this.delivery_queue = new ArrayList<>();
    }

    /**
     * Construtor por cópia
     */
    public User(User user) {
        //Variáveis do Logs.txt
        this.userID = user.getUserID();
        this.name = user.getUserName();
        this.x_user=user.getX_user();
        this.y_user=user.getY_user();

        //Variáveis para as Apps
        this.delivery_requests = user.getDelivery_requests();
        this.delivery_queue = user.getDelivery_queue();
    }

    /**
     * Construtor por parametro
     */
    public User(String first_name, String last_name, float x_user, float  y_user, List<String> delivery_requests, List<String> delivery_queue){
        //Variávies do Logs.txt
        this.name=last_name;
        this.x_user=x_user;
        this.y_user=y_user;

        //Variáveis para as Apps
        setDelivery_queue(delivery_queue);
        setDelivery_requests(delivery_requests);
    }

 /*
    public void request_delivery(){}
    public void confirm_delivery_company(){}
    public void check_deliveries(){}
    public void rate(){ }
*/

    //Getter and Setters

    //Getters das Variáveis do ficheiro Logs.txt
    public String getUserID() {
        return userID;
    }
    public String getUserName(){
        return this.name;
    }
    public float getX_user(){
        return this.x_user;
    }
    public float getY_user(){
        return this.y_user;
    }

    //Getters das variávies para as Apps
    public List<String> getDelivery_queue() {
        List<String> res = new ArrayList<>();
        for (String s : delivery_queue) {
            res.add(s) ;
        }
        return res;
    }
    public List<String> getDelivery_requests() {
        List<String> res = new ArrayList<>();
        for (String s : delivery_requests) {
            res.add(s) ;
        }
        return res;
    }

    //Setters das variáveis do ficheiro Logs.txt
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setUserName(String name){
        this.name= name;
    }
    public void setX_user(float x_user){
        this.x_user=x_user;
    }
    public void setY_user(float y_user){
        this.y_user=y_user;
    }

    //Setters das variáveis das Apps
    public void setDelivery_queue(List<String> delivery_queue){
        this.delivery_queue= new ArrayList<>();
        delivery_queue.forEach(s -> {
            this.delivery_queue.add(s);
        });
    }

    public void setDelivery_requests(List<String> delivery_requests) {
        this.delivery_requests = new ArrayList<>();
        delivery_requests.forEach(s -> {
            this.delivery_requests.add(s);
        });
    }

    public User clone(){
        return new User(this);
    }

    //Equals e Hashcode com as variáveis do Logs.txt
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Float.compare(user.x_user, x_user) == 0 &&
                Float.compare(user.y_user, y_user) == 0 &&
                Objects.equals(userID, user.userID) &&
                Objects.equals(name, user.name);
    }


    public int hashCode() {
        return Objects.hash(userID, name, x_user, y_user);
    }

    public String toString() {
        return "Utilizador:" +
                userID +
                "," + name +
                "," + x_user +
                "," + y_user;
    }


    public void criaUser(String linhaUser){
        String[] id= linhaUser.split (",");
        this.userID = (id[0]);

        float x= Float.parseFloat(id[2]);
        float y= Float.parseFloat(id[3]);

        this.x_user = x;
        this.y_user = y;

        String[] textoSeparado = id[1].split(" ");
        String nameAux = textoSeparado[0] + " " + textoSeparado[textoSeparado.length-1];
        this.name = nameAux;
    }
}