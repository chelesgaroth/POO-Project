package Model;

import Model.Catalogos.CatalogoProds;
import Model.Catalogos.ICatalogoProds;
import Model.Encomendas.Encomenda;
import Model.Encomendas.ILinhaEncomenda;
import Model.Logins.ILogin;
import Model.Tipos.*;

import java.util.*;

public class Sistema implements ISistema {
    private HashSet<Loja> listaLojas; // Register dos 4 tipos
    private HashSet<User> listaUsers;
    private HashSet<Empresa> listaEmpr;
    private HashSet<Voluntario> listaVol;
    private HashMap<String, ILogin> logins; // UserID + (Email + Password)
    ArrayList<Encomenda> encs; //encomendas validadas que a loja tem de preparar
    private ICatalogoProds catalogoProds; //Catalogo com todos os produtos que existem na aplicação

    public Sistema() {
        this.listaLojas = new HashSet<>();
        this.listaUsers = new HashSet<>();
        this.listaEmpr = new HashSet<>();
        this.listaVol = new HashSet<>();
        this.logins = new HashMap<>();
        this.encs = new ArrayList<>();
        this.catalogoProds = new CatalogoProds();
    }


    public Sistema(Sistema sistema) {
        this.listaLojas = sistema.getListaLojas();
        this.listaUsers = sistema.getListaUsers();
        this.listaEmpr = sistema.getListaEmpr();
        this.listaVol = sistema.getListaVol();
        this.logins = sistema.getLogins();
        this.encs = sistema.getEncs();
        this.catalogoProds = sistema.getCatalogoProds();
    }

    public ArrayList<Encomenda> getEncs() {
        ArrayList<Encomenda> encs = new ArrayList<>() ;
        for (Encomenda e: this.encs){
            encs.add(e.clone());
        }
        return encs;
    }

    public void setEncs(ArrayList<Encomenda> encs) {
        this.encs = encs;
    }

    public HashSet<Loja> getListaLojas() {
       HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : this.listaLojas) {
            lojas.add(loja.clone());
        }
        return this.listaLojas;
    }

    public HashSet<User> getListaUsers() {
        HashSet<User> users = new HashSet<>();
        for (User user : this.listaUsers) {
            users.add(user.clone());
        }
        return users;
    }

    public HashSet<Empresa> getListaEmpr() {
        HashSet<Empresa> empresas = new HashSet<>();
        for (Empresa empresa : this.listaEmpr) {
            empresas.add(empresa.clone());
        }
        return empresas;
    }

    public HashSet<Voluntario> getListaVol() {
        HashSet<Voluntario> vols = new HashSet<>();
        for (Voluntario vol : this.listaVol) {
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

    public void setListaLojas(HashSet<Loja> listaLojas) {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : listaLojas) {
            lojas.add(loja.clone());
        }
        this.listaLojas = lojas;
    }

    public void setListaUsers(HashSet<User> listaUsers) {
        HashSet<User> users = new HashSet<>();
        for (User user : listaUsers) {
            users.add(user.clone());
        }
        this.listaUsers = users;
    }

    public void setListaEmpr(HashSet<Empresa> listaEmpr) {
        HashSet<Empresa> empresas = new HashSet<>();
        for (Empresa empresa : listaEmpr) {
            empresas.add(empresa.clone());
        }
        this.listaEmpr = empresas;
    }

    public void setListaVol(HashSet<Voluntario> listaVol) {
        HashSet<Voluntario> vols = new HashSet<>();
        for (Voluntario vol : listaVol) {
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

    public void addTipo(ITipo t){
        if(t instanceof User) {
            User u = (User) t;
            this.listaUsers.add(u);
        }
        if(t instanceof Loja) {
            Loja l = (Loja) t;
            this.listaLojas.add(l);
        }
        if(t instanceof Voluntario) {
            Voluntario v = (Voluntario) t;
            this.listaVol.add(v);
        }
        if(t instanceof Empresa) {
            Empresa e = (Empresa) t;
            this.listaEmpr.add(e);
        }


    }
    //UTILIZADOR
    public boolean existsUser(User c) {
        return this.listaUsers.contains(c);
    }

    //VOLUNTARIO
    public boolean existsVoluntario(Voluntario c) {
        return this.listaVol.contains(c);
    }

    //LOJA
    public boolean existsLoja(Loja c) {
        return this.listaLojas.contains(c);
    }

    //EMPRESA
    public boolean existsEmpresa(Empresa c) {
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
