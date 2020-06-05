package Model;

import Model.Catalogos.ICatalogoProds;
import Model.Logins.ILogin;
import Model.Tipos.*;

import java.util.HashSet;

public interface ISistema {
    void addUser(User c);
    boolean existsUser(User c);

    void addVoluntario(IVoluntario c);
    boolean existsVoluntario(IVoluntario c);

    void addLoja(ILoja c);
    boolean existsLoja(ILoja c);

    void addEmpresa(IEmpresa c);
    boolean existsEmpresa(IEmpresa c);

    void addLogin(ILogin log, String userID);
    boolean existsLogin(ILogin log);

    void setCatalogo(ICatalogoProds cat);
    void StockLoja();

    ICatalogoProds getCatalogoProds();
    HashSet<ILoja> getListaLojas();
    HashSet<IVoluntario> getListaVol();
    void setListaLojas(HashSet<ILoja> listaLojas);

    void addTipo(ITipo t);

}
