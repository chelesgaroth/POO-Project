package Model.Catalogos;

import Model.Encomendas.*;

import java.util.HashMap;
import java.util.HashSet;

public interface ICatalogoProds {
    HashMap<Integer,ILinhaEncomenda> getCatProds();
    String toString();
    void insereProd(ILinhaEncomenda produto);
    int totalProds();
}
