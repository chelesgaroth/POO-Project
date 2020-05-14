import java.util.ArrayList;

public class Sistema {
    private ArrayList<Loja> listaLojas; // Register dos 4 tipos
    private ArrayList<User> listaUsers;
    private ArrayList<Empresa> listaEmpr;
    private ArrayList<Volunteer> listaVol;

    public Sistema(){
        this.listaLojas = new ArrayList<>();
        this.listaUsers = new ArrayList<>();
        this.listaEmpr = new ArrayList<>();
        this.listaVol = new ArrayList<>();
    }

    public Sistema(ArrayList<Loja> listaLojas, ArrayList<User> listaUsers, ArrayList<Empresa> listaEmpr, ArrayList<Volunteer> listaVol){
        this.listaLojas = new ArrayList<>();
        for(Loja loja: listaLojas){
            this.listaLojas.add(loja.clone());
        }
        this.listaUsers =  new ArrayList<>();
        for(User user: listaUsers){
            this.listaUsers.add(user.clone());
        }
        this.listaEmpr = new ArrayList<>();
        for(Empresa empresa : listaEmpr){
            this.listaEmpr.add(empresa.clone());
        }
        this.listaVol = new ArrayList<>();
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

    public ArrayList<Loja> getListaLojas() {
        ArrayList<Loja> lojas = new ArrayList<>();
        for(Loja loja : this.listaLojas){
            lojas.add(loja.clone());
        }
        return lojas;
    }

    public ArrayList<User> getListaUsers() {
        ArrayList<User> users = new ArrayList<>();
        for(User user : this.listaUsers){
            users.add(user.clone());
        }
        return users;
    }

    public ArrayList<Empresa> getListaEmpr(){
        ArrayList<Empresa> empresas = new ArrayList<>();
        for(Empresa empresa : this.listaEmpr){
            empresas.add(empresa.clone());
        }
        return empresas;
    }

    public ArrayList<Volunteer> getListaVol(){
        ArrayList<Volunteer> vols = new ArrayList<>();
        for (Volunteer vol : this.listaVol){
            vols.add(vol.clone());
        }
        return vols;
    }

    public void setListaLojas(ArrayList<Loja> listaLojas) {
        ArrayList<Loja> lojas = new ArrayList<>();
        for(Loja loja : listaLojas){
            lojas.add(loja.clone());
        }
        this.listaLojas = lojas;
    }

    public void setListaUsers(ArrayList<User> listaUsers) {
        ArrayList<User> users = new ArrayList<>();
        for(User user : listaUsers){
            users.add(user.clone());
        }
        this.listaUsers = users;
    }

    public void setListaEmpr(ArrayList<Empresa> listaEmpr) {
        ArrayList<Empresa> empresas = new ArrayList<>();
        for(Empresa empresa : listaEmpr){
            empresas.add(empresa.clone());
        }
        this.listaEmpr = empresas;
    }

    public void setListaVol(ArrayList<Volunteer> listaVol) {
        ArrayList<Volunteer> vols = new ArrayList<>();
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
}
