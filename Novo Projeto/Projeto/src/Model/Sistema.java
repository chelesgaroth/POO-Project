package Model;

import Model.Catalogos.CatalogoProds;
import Model.Catalogos.ICatalogoProds;
import Model.Encomendas.ILinhaEncomenda;
import Model.Logins.ILogin;
import Model.Tipos.*;

import java.util.*;

public class Sistema implements ISistema {
    private HashSet<ILoja> listaLojas; // Register dos 4 tipos
    private HashSet<IUser> listaUsers;
    private HashSet<IEmpresa> listaEmpr;
    private HashSet<IVoluntario> listaVol;
    private HashMap<String, ILogin> logins; // UserID + (Email + Password)

    private ICatalogoProds catalogoProds; //Catalogo com todos os produtos que existem na aplicação

    public Sistema() {
        this.listaLojas = new HashSet<>();
        this.listaUsers = new HashSet<>();
        this.listaEmpr = new HashSet<>();
        this.listaVol = new HashSet<>();
        this.logins = new HashMap<>();

        this.catalogoProds = new CatalogoProds();
    }


    public Sistema(Sistema sistema) {
        this.listaLojas = sistema.getListaLojas();
        this.listaUsers = sistema.getListaUsers();
        this.listaEmpr = sistema.getListaEmpr();
        this.listaVol = sistema.getListaVol();
        this.logins = sistema.getLogins();

        this.catalogoProds = sistema.getCatalogoProds();
    }

    public HashSet<ILoja> getListaLojas() {
        HashSet<ILoja> lojas = new HashSet<>();
        for (ILoja loja : this.listaLojas) {
            lojas.add(loja.clone());
        }
        return lojas;
    }

    public HashSet<IUser> getListaUsers() {
        HashSet<IUser> users = new HashSet<>();
        for (IUser user : this.listaUsers) {
            users.add(user.clone());
        }
        return users;
    }

    public HashSet<IEmpresa> getListaEmpr() {
        HashSet<IEmpresa> empresas = new HashSet<>();
        for (IEmpresa empresa : this.listaEmpr) {
            empresas.add(empresa.clone());
        }
        return empresas;
    }

    public HashSet<IVoluntario> getListaVol() {
        HashSet<IVoluntario> vols = new HashSet<>();
        for (IVoluntario vol : this.listaVol) {
            vols.add(vol.clone());
        }
        return vols;
    }

    public HashMap<String,ILogin> getLogins(){
        return this.logins;
    }

    public ICatalogoProds getCatalogoProds() {
        return this.catalogoProds;
    }

    public void setListaLojas(HashSet<ILoja> listaLojas) {
        HashSet<ILoja> lojas = new HashSet<>();
        for (ILoja loja : listaLojas) {
            lojas.add(loja.clone());
        }
        this.listaLojas = lojas;
    }

    public void setListaUsers(HashSet<IUser> listaUsers) {
        HashSet<IUser> users = new HashSet<>();
        for (IUser user : listaUsers) {
            users.add(user.clone());
        }
        this.listaUsers = users;
    }

    public void setListaEmpr(HashSet<IEmpresa> listaEmpr) {
        HashSet<IEmpresa> empresas = new HashSet<>();
        for (IEmpresa empresa : listaEmpr) {
            empresas.add(empresa.clone());
        }
        this.listaEmpr = empresas;
    }

    public void setListaVol(HashSet<IVoluntario> listaVol) {
        HashSet<IVoluntario> vols = new HashSet<>();
        for (IVoluntario vol : listaVol) {
            vols.add(vol.clone());
        }
        this.listaVol = vols;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sistema sistema = (Sistema) o;
        return this.listaLojas.equals(sistema.getListaLojas()) &&
                this.listaUsers.equals(sistema.getListaUsers()) &&
                this.listaEmpr.equals(sistema.getListaEmpr()) &&
                this.listaVol.equals(sistema.getListaVol()) &&
                this.logins.equals(sistema.getLogins());
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Sistema: ");
        sb.append("\nLista de Lojas: ").append(this.listaLojas).append(", ");
        sb.append("\nLista de Clientes: ").append(this.listaUsers).append(", ");
        sb.append("\nLista de Empresas: ").append(this.listaEmpr).append(", ");
        sb.append("\nLista de Voluntários: ").append(this.listaVol);
        sb.append("\nLista de Logins: ").append(this.logins);
        return sb.toString();
    }

    public Sistema clone() {
        return new Sistema(this);
    }

    //UTILIZADOR
    public void addUser(IUser c) {
        this.listaUsers.add(c);
    }
    public boolean existsUser(IUser c) {
        return this.listaUsers.contains(c);
    }

    //VOLUNTARIO
    public void addVoluntario(IVoluntario c) {
        this.listaVol.add(c);
    }
    public boolean existsVoluntario(IVoluntario c) {
        return this.listaVol.contains(c);
    }

    //LOJA
    public void addLoja(ILoja c) {
        this.listaLojas.add(c);
    }
    public boolean existsLoja(ILoja c) {
        return this.listaLojas.contains(c);
    }

    //EMPRESA
    public void addEmpresa(IEmpresa c) {
        this.listaEmpr.add(c);
    }
    public boolean existsEmpresa(IEmpresa c) {
        return this.listaEmpr.contains(c);
    }


    //LOGINS
    public void addLogin(ILogin log, String userID) {
        this.logins.put(userID,log);
    }
    public boolean existsLogin(ILogin log) {
        return this.logins.containsValue(log);
    }

    //CATALOGO DE PRODUTOS
    public void setCatalogo(ICatalogoProds cat){
        this.catalogoProds = cat;
    }

    //DEFINIR O STOCK DE CADA LOJA
    public void StockLoja(){
        ICatalogoProds aux = this.catalogoProds;
        for(ILoja loja : this.listaLojas){
            loja.setStock(aux);
        }
    }
}
