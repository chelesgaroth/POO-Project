package Model.ModosMVC.Loja;

import Model.Logins.ILogin;

import java.util.ArrayList;

public interface IAppLoja {

    void EncomendasFila(ArrayList<String> encs, ILogin login);
}
