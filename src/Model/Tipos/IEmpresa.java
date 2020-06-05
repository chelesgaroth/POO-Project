package Model.Tipos;

public interface IEmpresa {
    String getIdEmpresa();
    String getNome();
    int getNif();
    double getPreco();
    double getLatitude();
    double getLongitude();
    double getRaio();

    void setIdEmpresa(String idEmpresa);
    void setNome(String nome);
    void setNif(int nif);
    void setLatitude(double latitude);
    void setLongitude(double longitude);
    void setRaio(double raio);
    void setPreco(double preco);

    Empresa clone ();

    void criaEmpresa(String aux);
}
