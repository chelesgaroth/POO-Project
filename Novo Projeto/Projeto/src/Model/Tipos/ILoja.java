package Model.Tipos;


public interface ILoja {
    String getNome();
    String getCodLoja();
    double getLongitude();
    double getLatitude();
    void setNome(String nome);
    void setLongitude(double longitude);
    void setLatitude(double latitude);
    void setCodLoja(String codLoja);

    Loja clone();
    boolean equals(Object o);
    int hashCode();
    String toString();

    void criaLoja(String aux);
}
