package Model.Tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User extends Tipo implements IUser {

    //Variávieis para as Apps
    private List<String> delivery_requests;
    private List<String> delivery_queue;

    /**
     * Construtor por omissão
     */
    public User() {
        super();
        //Variáveis para as Apps
        this.delivery_requests = new ArrayList<>();
        this.delivery_queue = new ArrayList<>();
    }

    /**
     * Construtor por cópia
     */
    public User(User user) {
        super(user);
        //Variáveis para as Apps
        this.delivery_requests = user.getDelivery_requests();
        this.delivery_queue = user.getDelivery_queue();
    }

    /**
     * Construtor por parametro
     */
    public User(String id, String nome, float x, float y, List<String> delivery_requests, List<String> delivery_queue){
        super(id,nome,x,y);
        //Variáveis para as Apps
        setDelivery_queue(delivery_queue);
        setDelivery_requests(delivery_requests);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(getDelivery_requests(), user.getDelivery_requests()) &&
                Objects.equals(getDelivery_queue(), user.getDelivery_queue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDelivery_requests(), getDelivery_queue());
    }

    @Override
    public String toString() {
        return "User{" +
                "delivery_requests=" + delivery_requests +
                ", delivery_queue=" + delivery_queue +
                '}';
    }

}