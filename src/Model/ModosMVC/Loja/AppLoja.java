package Model.ModosMVC.Loja;


import Model.Encomendas.IEncomenda;
import Model.Logins.ILogin;

import java.util.ArrayList;

public class AppLoja implements IAppLoja {
    private ArrayList<IEncomenda> encomendasFila; //encomendas que estão na fila de espera
    private double tempoPessoa; //tempo medio a atender uma pessoa

    public AppLoja(){
        this.encomendasFila = new ArrayList<>();
        this.tempoPessoa = 0;
    }

    public void addEncomenda(IEncomenda encomenda){
        this.encomendasFila.add(encomenda);
    }

    public void removeEncomenda(String encomenda){
        this.encomendasFila.removeIf(x -> x.getEncomendaID().equals(encomenda));
    }

    public void setTempoPessoa(double tempoPessoa) {
        this.tempoPessoa = tempoPessoa;
    }

    public boolean existsEncomenda(String enco){
        for(IEncomenda x : this.encomendasFila){
            if(x.getEncomendaID().equals(enco))return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FILA DE ESPERA DA LOJA" + encomendasFila;
    }
}
