package Model.Tipos;

public interface IEmpresa {
    int getNif();
    double getPreco();
    double getRaio();

    void setNif(int nif);
    void setRaio(double raio);
    void setPreco(double preco);

    int getClassificacao();
    void setClassificacao(int classificacao);

    Empresa clone ();

}
