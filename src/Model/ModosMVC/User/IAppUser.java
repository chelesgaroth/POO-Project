package Model.ModosMVC.User;

import Model.Catalogos.ICatalogoProds;
import Model.Encomendas.IEncomenda;
import Model.Logins.ILogin;

import java.util.List;

public interface IAppUser {
    IEncomenda constroiLinhaEncomenda (List<String> res, ILogin user);
    ICatalogoProds getProds();
    void setProds(ICatalogoProds prods);
}
