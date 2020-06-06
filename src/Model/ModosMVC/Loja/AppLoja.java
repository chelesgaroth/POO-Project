package Model.ModosMVC.Loja;


import Model.Encomendas.IEncomenda;
import Model.Logins.ILogin;

import java.util.ArrayList;

public class AppLoja implements IAppLoja {
    private ArrayList<IEncomenda> encomendasFila; //encomendas que estão na fila de espera

    public AppLoja(){
        this.encomendasFila = new ArrayList<>();
    }

    public void EncomendasFila(ArrayList<String> encs, ILogin login){
        String aux = login.getEmail();
        aux = aux.substring(0,3);
    }
}
