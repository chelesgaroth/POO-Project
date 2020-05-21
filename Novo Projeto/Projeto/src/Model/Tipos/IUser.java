package Model.Tipos;

public interface IUser {
    String getUserID();
    String getUserName();
    float getX_user();
    float getY_user();

    void setUserID(String userID);
    void setUserName(String name);
    void setX_user(float x_user);
    void setY_user(float y_user);

    User clone();
    boolean equals(Object o);
    int hashCode();
    String toString();

    void criaUser(String linhaUser);
}
