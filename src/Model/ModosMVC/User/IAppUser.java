package Model.ModosMVC.User;

import Model.Catalogos.ICatalogoProds;
import Model.Logins.ILogin;

import java.util.List;

public interface IAppUser {
    void constroiLinhaEncomenda (List<String> res, ILogin user);
    ICatalogoProds getProds();
    void setProds(ICatalogoProds prods);
}
