package Model.Encomendas;

import Model.Catalogos.ICatalogoProds;

import java.util.ArrayList;

public interface IEncomenda {
    String getEncomendaID();
    String getUserID();
    String getLojaID();
    double getPesoTotal();
    ArrayList<LinhaEncomenda> getProds() ;
    void setEncomendaID(String encomendaID);
    void setUserID(String userID);
    void setLojaID(String lojaID);
    void setPesoTotal(double pesoTotal);
    void setProds(ArrayList<LinhaEncomenda> prods);

    void criaEncomenda (String aux, ICatalogoProds catalogoProds);
}
