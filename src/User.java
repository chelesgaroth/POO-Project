import java.util.List;
import java.util.ArrayList;

/**
 * Classe que representa um utilizdor
 */

public class User {

    private String first_name;
    private String last_name;
    private float x_user;
    private float y_user;
    private List<String> delivery_requests;
    private List<String> delivery_queue;

    /**
     * Construtor por omissão
     */
    public User() {
        this.first_name = "n/a";
        this.last_name = "n/a";
        this.x_user = 0;
        this.y_user = 0;
        this.delivery_requests = new ArrayList<>();
        this.delivery_queue = new ArrayList<>();
    }

    /**
     * Construtor por cópia
     */
    public User(User user) {
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.x_user=user.getX_user();
        this.y_user=user.getY_user();
        this.delivery_requests = user.getDelivery_requests();
        this.delivery_queue = user.getDelivery_queue();
    }

    /**
     * Construtor por parametro
     */
    public User(String first_name, String last_name, float x_user, float  y_user, List<String> delivery_requests, List<String> delivery_queue){
        this.first_name=first_name;
        this.last_name=last_name;
        this.x_user=x_user;
        this.y_user=y_user;
        setDelivery_queue(delivery_queue);
        setDelivery_requests(delivery_requests);
    }


    /**
     * Solicitar uma entrega de uma encomenda que foi pedida a uma loja
     */
    public void request_delivery(){

    }

    /**
     * Aceitar o serviço de entrega
     */
    public void confirm_delivery_company(){

    }

    /**
     * Aceder à informação de entregas efetuadas
     */
    public void check_deliveries(){

    }

    /**
     * Classificar o voluntário ou a empresa de transportes
     */
    public void rate(){

    }

    
    public String getFirst_name(){
        return this.first_name;
    }
    public void setFirst_name(String first_name){
        this.first_name= first_name;
    }

    public String getLast_name(){
        return this.last_name;
    }
    public void setLast_name(String last_name){
        this.first_name= last_name;
    }

    public float getX_user(){
        return this.x_user;
    }
    public void setX_user(float x_user){
        this.x_user=x_user;
    }

    public float getY_user(){
        return this.y_user;
    }
    public void setY_user(float y_user){
        this.y_user=y_user;
    }

    public List<String> getDelivery_queue() {
        List<String> res = new ArrayList<>();
        for (String s : delivery_queue) {
            res.add(s) ;
        }
        return res;
    }
    public void setDelivery_queue(List<String> delivery_queue){
        this.delivery_queue= new ArrayList<>();
        delivery_queue.forEach(s -> {
            this.delivery_queue.add(s);
        });
    }
    
     public List<String> getDelivery_requests() {
         List<String> res = new ArrayList<>();
         for (String s : delivery_requests) {
             res.add(s) ;
         }
         return res;
     }
     public void setDelivery_requests(List<String> delivery_requests) {
         this.delivery_requests = new ArrayList<>();
         delivery_requests.forEach(s -> {
             this.delivery_requests.add(s);
         });
     }

     protected User clone(){
         return new User(this);
     }

     public boolean equals (Object obj) {
        if (obj==this) return true;
        if (obj==null || obj.getClass()!=this.getClass()) return false;
        User u = (User) obj;
        return  this.first_name.equals(u.getFirst_name())&& this.last_name.equals(u.getLast_name())&&
                this.x_user==u.getX_user() && this.y_user==u.getY_user() &&
                this.delivery_queue.equals(u.getDelivery_queue())&& this.delivery_requests.equals(u.getDelivery_requests());
     }
}
