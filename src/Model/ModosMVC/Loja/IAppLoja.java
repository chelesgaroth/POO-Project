package Model.ModosMVC.Loja;

import Model.Encomendas.IEncomenda;
import Model.Logins.ILogin;

import java.util.ArrayList;

public interface IAppLoja {
    void setTempoPessoa(double tempoPessoa);
    boolean existsEncomenda(String enco);
    void addEncomenda(IEncomenda encomenda);
    void removeEncomenda(String encomenda);
}
