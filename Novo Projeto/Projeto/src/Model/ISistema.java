package Model;

import Model.Catalogos.ICatalogoProds;
import Model.Logins.ILogin;
import Model.Tipos.*;

import java.util.HashMap;
import java.util.HashSet;

public interface ISistema {
    HashSet<Loja> getListaLojas();
    HashSet<User> getListaUsers();
    HashSet<Empresa> getListaEmpr();
    HashSet<Voluntario> getListaVol();
    HashMap<String,ILogin> getLogins();
    ICatalogoProds getCatalogoProds();

    void setListaLojas(HashSet<Loja> listaLojas);
    void setListaUsers(HashSet<User> listaUsers);
    void setListaEmpr(HashSet<Empresa> listaEmpr);
    void setListaVol(HashSet<Voluntario> listaVol);
    void setCatalogo(ICatalogoProds cat);

    void addTipo(ITipo t);

    boolean existsUser(User c);
    boolean existsVoluntario(Voluntario c);
    boolean existsLoja(Loja c);
    boolean existsEmpresa(Empresa c);

    void addLogin(ILogin log, String userID);
    boolean existsLogin(ILogin log);

    void StockLoja();


}
