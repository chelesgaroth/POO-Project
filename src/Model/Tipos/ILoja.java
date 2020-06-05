package Model.Tipos;


import Model.Catalogos.ICatalogoProds;
import Model.Encomendas.Encomenda;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface ILoja {

    int getPessoasFila();
    LocalDateTime getTempo();
    double getTempoPessoa();
    ArrayList<Encomenda> getEncs();
    void setPessoasFila(int pessoasFila);
    void setTempo(LocalDateTime tempo);
    void setTempoPessoa(double tempoPessoa);
    void setEncs(ArrayList<Encomenda> encs);

    ICatalogoProds getStock();
    void setStock(ICatalogoProds stock);

    Loja clone();
    boolean equals(Object o);
    int hashCode();
    String toString();
}
