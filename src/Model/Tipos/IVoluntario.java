package Model.Tipos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface IVoluntario {

    float getRadius_volunteer();
    void setRadius_volunteer(float radius_volunteer);

    List<String> getPackage_list();
    void setPackage_list(List<String> package_list);
    boolean getAvailability();
    void setAvailability(boolean availability);
    int getVolunteer_rating();
    void setVolunteer_rating(int volunteer_rating);
    LocalDateTime getTime_start();
    void setTime_start(LocalDateTime time_start);
    LocalDateTime getTime_finish();
    void setTime_finish(LocalDateTime time_finish);



}
