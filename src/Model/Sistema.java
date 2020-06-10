package Model;

import Model.Catalogos.CatalogoProds;
import Model.Catalogos.CatalogoTipo;
import Model.Catalogos.ICatalogoProds;
import Model.Catalogos.ICatalogoTipo;

import Model.Encomendas.IEncomenda;
import Model.Logins.ILogin;
import Model.Logins.Login;
import Model.Tipos.*;

import java.io.Serializable;
import java.util.*;

public class Sistema implements ISistema, Serializable {

    private ICatalogoTipo lojas;
    private ICatalogoTipo users;
    private ICatalogoTipo empresas;
    private ICatalogoTipo voluntarios;
    private ICatalogoProds catalogoProds; //Catalogo com todos os produtos que existem na aplicação

    private HashMap<String, ILogin> logins; // UserID + (Email + Password)
    private HashSet<String> aceites; //encomendas já prontas para transportar

    private ILogin quem; //quem é que está com o login aberto

    private IFila filaEspera;
    private IFila filaEncomendas;
    private IFilaEntregues filaEntregues;
    private IGestaoEncomendas gestao;


    public Sistema() {
        this.lojas = new CatalogoTipo();
        this.users = new CatalogoTipo();
        this.empresas = new CatalogoTipo();
        this.voluntarios = new CatalogoTipo();
        this.catalogoProds = new CatalogoProds();

        this.logins = new HashMap<>();
        this.aceites = new HashSet<>();

        this.quem = new Login();

        this.filaEspera = new FilaEspera();
        this.filaEncomendas = new FilaEncomendas();
        this.filaEntregues = new FilaEntregues();
        this.gestao = new GestaoEncomendas();
    }


    public Sistema(Sistema sistema) {

        this.lojas = sistema.getLojas();
        this.users = sistema.getUsers();
        this.empresas = sistema.getEmpresas();
        this.voluntarios = sistema.getVoluntarios();
        this.catalogoProds = sistema.getCatalogoProds();

        this.logins = sistema.getLogins();
        this.aceites = sistema.getAceites();

        this.quem = sistema.getQuem();
        this.filaEspera = getFilaEspera();
        this.filaEncomendas = getFilaEncomendas();
        this.filaEntregues = getFilaEntregues();
        this.gestao = getGestao();
    }

    public IGestaoEncomendas getGestao() {
        return gestao;
    }

    public void setGestao(IGestaoEncomendas gestao) {
        this.gestao = gestao;
    }

    public IFila getFilaEspera() {
        return filaEspera;
    }

    public void setFilaEspera(IFila filaEspera) {
        this.filaEspera = filaEspera;
    }

    public IFila getFilaEncomendas() {
        return filaEncomendas;
    }

    public void setFilaEncomendas(IFila filaEncomendas) {
        this.filaEncomendas = filaEncomendas;
    }

    public IFilaEntregues getFilaEntregues() {
        return filaEntregues;
    }

    public void setFilaEntregues(IFilaEntregues filaEntregues) {
        this.filaEntregues = filaEntregues;
    }


    public ILogin getQuem() {
        return quem;
    }

    public void setQuem(ILogin quem) {
        this.quem = quem;
    }

    public HashSet<String> getAceites() {
        return this.aceites;
    }

    public void setAceites(HashSet<String> encs) {
        this.aceites = encs;
    }

    public ICatalogoTipo getLojas() {
        return lojas;
    }

    public void setLojas(ICatalogoTipo lojas) {
        this.lojas = lojas;
    }

    public ICatalogoTipo getUsers() {
        return users;
    }

    public void setUsers(ICatalogoTipo users) {
        this.users = users;
    }

    public ICatalogoTipo getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ICatalogoTipo empresas) {
        this.empresas = empresas;
    }

    public ICatalogoTipo getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(ICatalogoTipo voluntarios) {
        this.voluntarios = voluntarios;
    }


    public HashMap<String, ILogin> getLogins() {
        return this.logins;
    }

    public ICatalogoProds getCatalogoProds() {
        return this.catalogoProds;
    }

    public void setCatalogo(ICatalogoProds cat){
        this.catalogoProds = cat;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sistema sistema = (Sistema) o;
        return this.lojas.equals(sistema.getLojas()) &&
                this.users.equals(sistema.getUsers()) &&
                this.empresas.equals(sistema.getEmpresas()) &&
                this.voluntarios.equals(sistema.getVoluntarios()) &&
                this.logins.equals(sistema.getLogins());
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Sistema: ");
        sb.append("\nLista de Lojas: ").append(this.lojas).append(", ");
        sb.append("\nLista de Clientes: ").append(this.users).append(", ");
        sb.append("\nLista de Empresas: ").append(this.empresas).append(", ");
        sb.append("\nLista de Voluntários: ").append(this.voluntarios);
        sb.append("\nLista de Logins: ").append(this.logins);
        sb.append("\nFila de Encomendas: ").append(this.filaEncomendas);
        sb.append("\nFila de Espera: ").append(this.filaEspera);
        sb.append("\nFila de Entregas: ").append(this.filaEntregues);
        sb.append("\nEncomendas aceites: ").append(this.aceites);
        return sb.toString();
    }

    public Sistema clone() {
        return new Sistema(this);
    }




    //LOGINS
    public void addLogin(ILogin log, String userID) {
        this.logins.put(userID,log);
    }
    public boolean existsLogin(ILogin log) {
        return this.logins.containsValue(log);
    }



    //DEFINIR O STOCK DE CADA LOJA
    public void StockLoja(){
        ICatalogoProds aux = this.catalogoProds;
        for(ITipo loja : this.lojas.getCatalogo()){
            if(loja instanceof Loja) {
                ((Loja) loja).setStock(aux);
            }
        }
    }



    /**
     * Adicionar o ID de uma encomenda à lista de encomendas aceites.
     * Método usado principalmente quando lemos do ficheiro Logs.txt
     */
    public void addAceite(String id){
        this.aceites.add(id);
        IEncomenda encomenda = this.filaEspera.existsEncomenda(id);
        if(encomenda!=null){
            this.filaEncomendas.addEncomenda(encomenda);
            this.filaEspera.removeEncomenda(encomenda);
        }
    }

}
