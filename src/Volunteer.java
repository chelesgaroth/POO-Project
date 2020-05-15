import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Classe que representa um volunário
 */

public class Volunteer {
    private String id_volunteer;
    private String id_package;
    private String id_store_pickup;
    private List<String> package_list;
    private String firstName;
    private String lastName;


    private float x_volunteer;
    private float y_volunteer;
    private float x_volunteer_home;
    private float y_volunteer_home;
    private float radius_volunteer;
    private boolean availability;
    private float volunteer_rating;
    private LocalDateTime time_start;
    private  LocalDateTime time_finish;

    /**
     * Construtor por omissão
     */
    public Volunteer(){
        this.id_volunteer = "n/a";
        this.id_package = "n/a";
        this.id_store_pickup = "n/a";
        this.package_list = new ArrayList<>();
        this.x_volunteer = 0;
        this.y_volunteer = 0;
        this.x_volunteer_home = 0;
        this.y_volunteer_home = 0;
        this.radius_volunteer = 0;
        this.availability = true;
        this.volunteer_rating = 5;
        this.time_start = LocalDateTime.now();
        this.time_finish = LocalDateTime.now();
    }

    /**
     * Construtor por cópia
     */
    public Volunteer (Volunteer volunteer){
        this.id_volunteer=volunteer.getId_volunteer();
        this.id_package=volunteer.getId_package();
        this.id_store_pickup=volunteer.getId_store_pickup();
        this.package_list=volunteer.getPackage_list();
        this.x_volunteer=volunteer.getX_volunteer();
        this.y_volunteer=volunteer.getY_volunteer();
        this.x_volunteer_home=volunteer.getX_volunteer_home();
        this.y_volunteer_home=volunteer.getY_volunteer_home();
        this.radius_volunteer=volunteer.getRadius_volunteer();
        this.availability=volunteer.getAvailability();
        this.volunteer_rating=volunteer.getVolunteer_rating();
        this.time_start=volunteer.getTime_start();
        this.time_finish=volunteer.getTime_finish();
    }

    /**
     * Construtor por parametro
     */
    public Volunteer(String id_volunteer, String id_package, String id_store_pickup, List<String> package_list,
                     float x_volunteer, float y_volunteer, float x_volunteer_home, float y_volunteer_home,
                     float radius_volunteer, boolean availability, float volunteer_rating, LocalDateTime time_start,
                     LocalDateTime time_finish){
        this.id_volunteer=id_volunteer;
        this.id_package=id_package;
        this.id_store_pickup=id_store_pickup;
        setPackage_list(package_list);
        this.x_volunteer=x_volunteer;
        this.y_volunteer=y_volunteer;
        this.x_volunteer_home=x_volunteer_home;
        this.y_volunteer_home=y_volunteer_home;
        this.radius_volunteer=radius_volunteer;
        this.availability=availability;
        this.volunteer_rating=volunteer_rating;
        this.time_start=time_start;
        this.time_finish=time_finish;
    }

    public static void insereVolunteer(String aux,Sistema s) {
        //System.out.println("Voluntario e"+aux);
        Volunteer v = new Volunteer();
        String[] id= aux.split (",");
        v.setId_volunteer(id[0]);
        //System.out.println("ID " +id[0]);

        float x= Float.parseFloat(id[2]);
        float y= Float.parseFloat(id[3]);
        float r = Float.parseFloat(id[4]);

        v.setX_volunteer(x);
        v.setY_volunteer(y);
        v.setRadius_volunteer(r);

        String[] textoSeparado = id[1].split(" ");

        v.setFirstName(textoSeparado[0]);

        v.setLastName(textoSeparado[textoSeparado.length-1]);
        //v.toString();
        Sistema.insereVol(v,s);
    }

    /**
     * sinalizar que está disposto a recolher uma encomenda
     */
    public void make_decision(){

    }

    /**
     * recolher encomenda
     */
    public void pick_delivery(){

    }

    /**
     * transporte e registo do tempo
     */
    public void delivery_time(){

    }


    public String getId_volunteer(){
        return this.id_volunteer;
    }
    public void setId_volunteer(String id_volunteer){
        this.id_volunteer=id_volunteer;
    }

    public String getId_package(){
        return this.id_package;
    }
    public void setId_package(String id_package){
        this.id_package=id_package;
    }

    public String getId_store_pickup(){
        return this.id_store_pickup;
    }

    public void setId_store_pickup(String id_store_pickup){
        this.id_store_pickup=id_store_pickup;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<String> getPackage_list() {
        List<String> res = new ArrayList<>();
        for (String s : package_list) {
            res.add(s) ;
        }
        return res;
    }
    public void setPackage_list(List<String> package_list){
        this.package_list= new ArrayList<>();
        package_list.forEach(s -> {
            this.package_list.add(s);
        });
    }

    public float getX_volunteer(){
        return this.x_volunteer;
    }
    public void setX_volunteer(float x_volunteer){
        this.x_volunteer=x_volunteer;
    }

    public float getY_volunteer(){
        return this.y_volunteer;
    }
    public void setY_volunteer(float y_volunteer){
        this.y_volunteer=y_volunteer;
    }

    public float getX_volunteer_home(){
        return this.x_volunteer_home;
    }
    public void setX_volunteer_home(float x_volunteer_home){
        this.x_volunteer_home=x_volunteer_home;
    }

    public float getY_volunteer_home(){
        return this.y_volunteer_home;
    }
    public void setY_volunteer_home(float y_volunteer_home){
        this.y_volunteer_home=y_volunteer_home;
    }

    public float getRadius_volunteer(){
        return this.radius_volunteer;
    }
    public void setRadius_volunteer(float radius_volunteer){
        this.radius_volunteer=radius_volunteer;
    }

    public boolean getAvailability(){
        return this.availability;
    }
    public void setAvailability(boolean availability){
        this.availability=availability;
    }

    public float getVolunteer_rating(){
        return this.volunteer_rating;
    }
    public void setVolunteer_rating(float volunteer_rating){
        this.volunteer_rating=volunteer_rating;
    }

    public LocalDateTime getTime_start(){
        return this.time_start;
    }
    public void setTime_start(LocalDateTime time_start){
        this.time_start=time_start;
    }

    public LocalDateTime getTime_finish(){
        return this.time_finish;
    }
    public void setTime_finish(LocalDateTime time_finish){
        this.time_finish=time_finish;
    }


    protected Volunteer clone(){
        return new Volunteer(this);
    }

    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (obj==null || obj.getClass()!=this.getClass()) return false;
        Volunteer v = (Volunteer) obj;
        return this.id_volunteer.equals(v.getId_volunteer()) && this.id_package.equals(v.getId_package()) &&
                this.id_store_pickup.equals(v.getId_store_pickup()) && this.package_list.equals(v.getPackage_list()) &&
                this.x_volunteer==v.getX_volunteer() && this.y_volunteer==v.getY_volunteer() && this.x_volunteer_home==v.getX_volunteer_home() &&
                this.getY_volunteer_home()==v.getY_volunteer_home() && this.radius_volunteer==v.getRadius_volunteer() &&
                this.availability==(v.getAvailability()) && this.volunteer_rating==v.getVolunteer_rating() &&
                this.time_start.equals(v.getTime_start()) && this.time_finish.equals(v.getTime_finish());
    }
}
