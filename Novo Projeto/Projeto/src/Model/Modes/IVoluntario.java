package Model.Modes;

public interface IVoluntario {
    String getId_volunteer();
    String getName();
    float getX_volunteer();
    float getY_volunteer();
    float getRadius_volunteer();

    void setId_volunteer(String id_volunteer);
    void setName(String name);
    void setX_volunteer(float x_volunteer);
    void setY_volunteer(float y_volunteer);
    void setRadius_volunteer(float radius_volunteer);
}
