package Model.Tipos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um voluntário
 */

public class Voluntario implements IVoluntario{
    //Variaveis do ficheiro logs.txt
    private String id_volunteer;
    private String name;
    private float x_volunteer;
    private float y_volunteer;
    private float radius_volunteer;

    //Variaveis para as Apps
    private float x_volunteer_home;
    private float y_volunteer_home;
    private boolean availability;
    private float volunteer_rating;
    private LocalDateTime time_start;
    private  LocalDateTime time_finish;
    private String id_package;
    private String id_store_pickup;
    private List<String> package_list;

    /**
     * Construtor por omissão
     */
    public Voluntario(){
        //Variaveis do ficheiro logs.txt
        this.id_volunteer = "n/a";
        this.name = "n/a";
        this.x_volunteer = 0;
        this.y_volunteer = 0;
        this.radius_volunteer = 0;

        //Variaveis para as Apps
        this.id_package = "n/a";
        this.id_store_pickup = "n/a";
        this.package_list = new ArrayList<>();
        this.x_volunteer_home = 0;
        this.y_volunteer_home = 0;
        this.availability = true;
        this.volunteer_rating = 5;
        this.time_start = LocalDateTime.now();
        this.time_finish = LocalDateTime.now();
    }

    /**
     * Construtor por cópia
     */
    public Voluntario(Voluntario voluntario){
        //Variaveis do ficheiro logs.txt
        this.id_volunteer= voluntario.getId_volunteer();
        this.name = voluntario.getName();
        this.x_volunteer= voluntario.getX_volunteer();
        this.y_volunteer= voluntario.getY_volunteer();
        this.radius_volunteer= voluntario.getRadius_volunteer();

        //Variaveis para as Apps
        /*this.id_package= voluntario.getId_package();
        this.id_store_pickup= voluntario.getId_store_pickup();
        this.package_list= voluntario.getPackage_list();
        this.x_volunteer_home= voluntario.getX_volunteer_home();
        this.y_volunteer_home= voluntario.getY_volunteer_home();
        this.availability= voluntario.getAvailability();
        this.volunteer_rating= voluntario.getVolunteer_rating();
        this.time_start= voluntario.getTime_start();
        this.time_finish= voluntario.getTime_finish();*/
    }

    /**
     * Construtor por parametro
     */
    public Voluntario(String id_volunteer,String name, String id_package, String id_store_pickup, List<String> package_list,
                      float x_volunteer, float y_volunteer, float x_volunteer_home, float y_volunteer_home,
                      float radius_volunteer, boolean availability, float volunteer_rating, LocalDateTime time_start,
                      LocalDateTime time_finish){

        //Variaveis do ficheiro logs.txt
        this.id_volunteer=id_volunteer;
        this.name = name;
        this.x_volunteer=x_volunteer;
        this.y_volunteer=y_volunteer;
        this.radius_volunteer=radius_volunteer;

        //Variaveis para as Apps
        this.id_package=id_package;
        this.id_store_pickup=id_store_pickup;
        //setPackage_list(package_list);
        this.x_volunteer_home=x_volunteer_home;
        this.y_volunteer_home=y_volunteer_home;
        this.availability=availability;
        this.volunteer_rating=volunteer_rating;
        this.time_start=time_start;
        this.time_finish=time_finish;
    }

    /*
    //sinalizar que está disposto a recolher uma encomenda
    public void make_decision(){ }

    //recolher encomenda
    public void pick_delivery(){ }

    //transporte e registo do tempo
    public void delivery_time(){ }
    */

    //VARIAVEIS DO LOGS.TXT

    //Getters
    public String getId_volunteer(){
        return this.id_volunteer;
    }
    public String getName() {
        return this.name;
    }
    public float getX_volunteer(){
        return this.x_volunteer;
    }
    public float getY_volunteer(){
        return this.y_volunteer;
    }
    public float getRadius_volunteer(){
        return this.radius_volunteer;
    }

    //Setters
    public void setId_volunteer(String id_volunteer){
        this.id_volunteer=id_volunteer;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setX_volunteer(float x_volunteer){
        this.x_volunteer=x_volunteer;
    }
    public void setY_volunteer(float y_volunteer){
        this.y_volunteer=y_volunteer;
    }
    public void setRadius_volunteer(float radius_volunteer){
        this.radius_volunteer=radius_volunteer;
    }

    /* VARIAVEIS PARA AS APPS
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
    */

    protected Voluntario clone(){
        return new Voluntario(this);
    }

    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (obj==null || obj.getClass()!=this.getClass()) return false;
        Voluntario v = (Voluntario) obj;
        return this.id_volunteer.equals(v.getId_volunteer()) && this.name.equals(v.getName()) && this.x_volunteer==v.getX_volunteer() &&
                this.y_volunteer==v.getY_volunteer() && this.radius_volunteer==v.getRadius_volunteer();/*
                this.id_package.equals(v.getId_package()) && this.id_store_pickup.equals(v.getId_store_pickup()) &&
                this.package_list.equals(v.getPackage_list()) && this.x_volunteer_home==v.getX_volunteer_home() &&
                this.getY_volunteer_home()==v.getY_volunteer_home() &&
                this.availability==(v.getAvailability()) && this.volunteer_rating==v.getVolunteer_rating() &&
                this.time_start.equals(v.getTime_start()) && this.time_finish.equals(v.getTime_finish());*/
    }

    public String toString() {
        return "Voluntario:" +
                id_volunteer + "," +
                name + "," +
                x_volunteer + "," +
                y_volunteer + "," +
                radius_volunteer ;
    }


    public void criaVoluntario(String linha) {

        String[] id= linha.split (",");
        this.id_volunteer = (id[0]);

        float x= Float.parseFloat(id[2]);
        float y= Float.parseFloat(id[3]);
        float r = Float.parseFloat(id[4]);

        this.x_volunteer = x;
        this.y_volunteer = y;
        this.radius_volunteer = r;

        String[] textoSeparado = id[1].split(" ");
        String nameAux = textoSeparado[0] + " " + textoSeparado[textoSeparado.length-1];
        this.name = nameAux;
    }

}
