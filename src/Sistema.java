import java.util.ArrayList;
import java.util.HashSet;

public class Sistema {
    private HashSet<Loja> listaLojas; // Register dos 4 tipos
    private HashSet<User> listaUsers;
    private HashSet<Empresa> listaEmpr;
    private HashSet<Volunteer> listaVol;

    public Sistema(){
        this.listaLojas = new HashSet<>();
        this.listaUsers = new HashSet<>();
        this.listaEmpr = new HashSet<>();
        this.listaVol = new HashSet<>();
    }

    public Sistema(HashSet<Loja> listaLojas, HashSet<User> listaUsers, HashSet<Empresa> listaEmpr, HashSet<Volunteer> listaVol){
        this.listaLojas = new HashSet<>();
        for(Loja loja: listaLojas){
            this.listaLojas.add(loja.clone());
        }
        this.listaUsers =  new HashSet<>();
        for(User user: listaUsers){
            this.listaUsers.add(user.clone());
        }
        this.listaEmpr = new HashSet<>();
        for(Empresa empresa : listaEmpr){
            this.listaEmpr.add(empresa.clone());
        }
        this.listaVol = new HashSet<>();
        for(Volunteer voluntario : listaVol){
            this.listaVol.add(voluntario.clone());
        }
    }

    public Sistema(Sistema sistema){
        this.listaLojas = sistema.getListaLojas();
        this.listaUsers = sistema.getListaUsers();
        this.listaEmpr = sistema.getListaEmpr();
        this.listaVol = sistema.getListaVol();
    }

    public HashSet<Loja> getListaLojas() {
        HashSet<Loja> lojas = new HashSet<>();
        for(Loja loja : this.listaLojas){
            lojas.add(loja.clone());
        }
        return lojas;
    }

    public HashSet<User> getListaUsers() {
        HashSet<User> users = new HashSet<>();
        for(User user : this.listaUsers){
            users.add(user.clone());
        }
        return users;
    }

    public HashSet<Empresa> getListaEmpr(){
        HashSet<Empresa> empresas = new HashSet<>();
        for(Empresa empresa : this.listaEmpr){
            empresas.add(empresa.clone());
        }
        return empresas;
    }

    public HashSet<Volunteer> getListaVol(){
        HashSet<Volunteer> vols = new HashSet<>();
        for (Volunteer vol : this.listaVol){
            vols.add(vol.clone());
        }
        return vols;
    }

    public void setListaLojas(HashSet<Loja> listaLojas) {
        HashSet<Loja> lojas = new HashSet<>();
        for(Loja loja : listaLojas){
            lojas.add(loja.clone());
        }
        this.listaLojas = lojas;
    }

    public void setListaUsers(HashSet<User> listaUsers) {
        HashSet<User> users = new HashSet<>();
        for(User user : listaUsers){
            users.add(user.clone());
        }
        this.listaUsers = users;
    }

    public void setListaEmpr(HashSet<Empresa> listaEmpr) {
        HashSet<Empresa> empresas = new HashSet<>();
        for(Empresa empresa : listaEmpr){
            empresas.add(empresa.clone());
        }
        this.listaEmpr = empresas;
    }

    public void setListaVol(HashSet<Volunteer> listaVol) {
        HashSet<Volunteer> vols = new HashSet<>();
        for (Volunteer vol : listaVol){
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
                this.listaVol.equals(sistema.getListaVol());
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Sistema: ");
        sb.append("Lista de Lojas: ").append(this.listaLojas).append(", ");
        sb.append("Lista de Clientes: ").append(this.listaUsers).append(", ");
        sb.append("Lista de Empresas: ").append(this.listaEmpr).append(", ");
        sb.append("Lista de Voluntários: ").append(this.listaVol);
        return sb.toString();
    }

    public Sistema clone(){
        return new Sistema(this);
    }


    //Adiciona um utilizador ao sistema
    public Sistema addUser(User c){
        this.listaUsers.add(c);
        return this;
    }

    //Verifica se  já existe
    public boolean existsUser(Volunteer c){
        return this.listaUsers.contains(c);
    }

    //Adiciona um voluntario ao sistema
    public Sistema addVoluntario(Volunteer c){
        this.listaVol.add(c);
        return this;
    }

    //Verifica se o voluntario já existe
    public boolean existsVolunatario(Volunteer c){
        return this.listaVol.contains(c);
    }

    //Adiciona uma loja ao sistema
    public Sistema addLoja(Loja c){
        this.listaLojas.add(c);
        return this;
    }

    //Verifica se a loja já existe
    public boolean existsLoja(Loja c){
        return this.listaLojas.contains(c);
    }

    //Adiciona um utilizador ao sistema
    public Sistema addEmpresa(Empresa c){
        this.listaEmpr.add(c);
        return this;
    }

    //Verifica se o utilizador já existe
    public boolean existsEmpresa(Empresa c){
        return this.listaEmpr.contains(c);
    }

}
