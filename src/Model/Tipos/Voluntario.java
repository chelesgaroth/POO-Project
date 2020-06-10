package Model.Tipos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um voluntário
 */

public class Voluntario extends Tipo implements IVoluntario, Serializable {

    private float radius_volunteer;
    private boolean availability;
    private boolean medicamentos;

    private float volunteer_rating;
    private LocalDateTime time_start;
    private  LocalDateTime time_finish;
    private List<String> package_list;

    /**
     * Construtor por omissão
     */
    public Voluntario(){
        super();
        this.radius_volunteer = 0;
        this.package_list = new ArrayList<>();
        this.availability = true;
        this.medicamentos = false;
        this.volunteer_rating = 5;
        this.time_start = LocalDateTime.now();
        this.time_finish = LocalDateTime.now();
    }

    /**
     * Construtor por cópia
     */
    public Voluntario(Voluntario voluntario){

        super(voluntario);
        this.radius_volunteer= voluntario.getRadius_volunteer();
        this.package_list= voluntario.getPackage_list();
        this.availability= voluntario.getAvailability();
        this.volunteer_rating= voluntario.getVolunteer_rating();
        this.time_start= voluntario.getTime_start();
        this.time_finish= voluntario.getTime_finish();
    }

    /**
     * Construtor por parametro
     */
    public Voluntario(String id_volunteer,String name, String id_package, String id_store_pickup, List<String> package_list,
                      float x_volunteer, float y_volunteer,
                      float radius_volunteer, boolean availability, float volunteer_rating, LocalDateTime time_start,
                      LocalDateTime time_finish){

        super(id_volunteer,name,x_volunteer,y_volunteer);
        this.radius_volunteer=radius_volunteer;
        setPackage_list(package_list);
        this.availability=availability;
        this.volunteer_rating=volunteer_rating;
        this.time_start=time_start;
        this.time_finish=time_finish;
    }

    public boolean getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(boolean medicamentos) {
        this.medicamentos = medicamentos;
    }

    public float getRadius_volunteer() {
        return this.radius_volunteer;
    }
    public void setRadius_volunteer(float radius_volunteer) {
        this.radius_volunteer = radius_volunteer;
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


    public Voluntario clone(){
        return new Voluntario(this);
    }

    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (obj==null || obj.getClass()!=this.getClass()) return false;
        Voluntario v = (Voluntario) obj;
        return this.radius_volunteer==v.getRadius_volunteer() &&
                this.package_list.equals(v.getPackage_list()) &&
                this.availability==(v.getAvailability()) && this.volunteer_rating==v.getVolunteer_rating() &&
                this.time_start.equals(v.getTime_start()) && this.time_finish.equals(v.getTime_finish());
    }

    public String toString() {
        return "\nVoluntario:\n" +
                this.getId() + "\n" +
                this.getNome() + "\n" +
                this.getX() + "\n" +
                this.getY() + "\n" +
                radius_volunteer ;
    }

}
