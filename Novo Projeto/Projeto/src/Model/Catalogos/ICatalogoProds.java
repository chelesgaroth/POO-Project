package Model.Catalogos;

import Model.Encomendas.*;

import java.util.HashMap;
import java.util.HashSet;

public interface ICatalogoProds {
    HashMap<String,IProduto> getCatProds();
    String toString();
    void insereProd(IProduto produto);
    int totalProds();
}
