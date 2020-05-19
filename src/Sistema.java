import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Sistema {
    private HashSet<Loja> listaLojas; // Register dos 4 tipos
    private HashSet<User> listaUsers;
    private HashSet<Empresa> listaEmpr;
    private HashSet<Volunteer> listaVol;
    private HashSet<Loja> supermecados;
    private HashSet<Loja> farmacias;
    private HashSet<Loja> roupas;
    private HashSet<Loja> restaurantes;
    private HashSet<Login> listaLogs;

    public Sistema() {
        this.listaLojas = new HashSet<>();
        this.listaUsers = new HashSet<>();
        this.listaEmpr = new HashSet<>();
        this.listaVol = new HashSet<>();
        this.listaLogs = new HashSet<>();
        this.supermecados = new HashSet<>();
        this.restaurantes = new HashSet<>();
        this.roupas = new HashSet<>();
        this.farmacias = new HashSet<>();
    }

    public Sistema(HashSet<Loja> listaLojas, HashSet<User> listaUsers, HashSet<Empresa> listaEmpr, HashSet<Volunteer> listaVol, HashSet<Login> listaLogs) {
        this.listaLojas = new HashSet<>();
        for (Loja loja : listaLojas) {
            this.listaLojas.add(loja.clone());
        }
        this.listaUsers = new HashSet<>();
        for (User user : listaUsers) {
            this.listaUsers.add(user.clone());
        }
        this.listaEmpr = new HashSet<>();
        for (Empresa empresa : listaEmpr) {
            this.listaEmpr.add(empresa.clone());
        }
        this.listaVol = new HashSet<>();
        for (Volunteer voluntario : listaVol) {
            this.listaVol.add(voluntario.clone());
        }
        this.listaLogs = new HashSet<>();
        for (Login log : listaLogs) {
            this.listaLogs.add(log.clone());
        }
        this.supermecados = new HashSet<>();
        for (Loja loja : listaLojas) {
            this.supermecados.add(loja.clone());
        }
        this.farmacias = new HashSet<>();
        for (Loja loja : listaLojas) {
            this.farmacias.add(loja.clone());
        }
        this.roupas = new HashSet<>();
        for (Loja loja : listaLojas) {
            this.roupas.add(loja.clone());
        }
        this.restaurantes = new HashSet<>();
        for (Loja loja : listaLojas) {
            this.restaurantes.add(loja.clone());
        }
    }

    public Sistema(Sistema sistema) {
        this.listaLojas = sistema.getListaLojas();
        this.listaUsers = sistema.getListaUsers();
        this.listaEmpr = sistema.getListaEmpr();
        this.listaVol = sistema.getListaVol();
        this.listaLogs = sistema.getListaLogs();
    }

    public HashSet<Loja> getListaLojas() {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : this.listaLojas) {
            lojas.add(loja.clone());
        }
        return lojas;
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

    public HashSet<Volunteer> getListaVol() {
        HashSet<Volunteer> vols = new HashSet<>();
        for (Volunteer vol : this.listaVol) {
            vols.add(vol.clone());
        }
        return vols;
    }

    public HashSet<Login> getListaLogs() {
        HashSet<Login> logs = new HashSet<>();
        for (Login log : this.listaLogs) {
            logs.add(log.clone());
        }
        return logs;
    }

    public HashSet<Loja> getSupermecados() {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : this.supermecados) {
            lojas.add(loja.clone());
        }
        return lojas;
    }

    public void setSupermecados(HashSet<Loja> supermecados) {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : supermecados) {
            lojas.add(loja.clone());
        }
        this.supermecados = lojas;
    }

    public HashSet<Loja> getFarmacias() {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : this.farmacias) {
            lojas.add(loja.clone());
        }
        return lojas;
    }

    public void setFarmacias(HashSet<Loja> farmacias) {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : farmacias) {
            lojas.add(loja.clone());
        }
        this.farmacias = farmacias;
    }

    public HashSet<Loja> getRoupas() {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : this.roupas) {
            lojas.add(loja.clone());
        }
        return lojas;
    }

    public HashSet<Loja> getRestaurantes() {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : this.restaurantes) {
            lojas.add(loja.clone());
        }
        return lojas;
    }

    public void setRestaurantes(HashSet<Loja> restaurantes) {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : restaurantes) {
            lojas.add(loja.clone());
        }
        this.restaurantes = lojas;
    }

    public void setRoupas(HashSet<Loja> roupas) {
        HashSet<Loja> lojas = new HashSet<>();
        for (Loja loja : roupas) {
            lojas.add(loja.clone());
        }
        this.roupas = lojas;
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

    public void setListaVol(HashSet<Volunteer> listaVol) {
        HashSet<Volunteer> vols = new HashSet<>();
        for (Volunteer vol : listaVol) {
            vols.add(vol.clone());
        }
        this.listaVol = vols;
    }

    public void setListaLogs(HashSet<Login> listaLogs) {
        HashSet<Login> logs = new HashSet<>();
        for (Login log : listaLogs) {
            logs.add(log.clone());
        }
        this.listaLogs = logs;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sistema sistema = (Sistema) o;
        return this.listaLojas.equals(sistema.getListaLojas()) &&
                this.listaUsers.equals(sistema.getListaUsers()) &&
                this.listaEmpr.equals(sistema.getListaEmpr()) &&
                this.listaVol.equals(sistema.getListaVol()) &&
                this.listaLogs.equals(sistema.getListaLogs());
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Sistema: ");
        sb.append("Lista de Lojas: ").append(this.listaLojas).append(", ");
        sb.append("Lista de Clientes: ").append(this.listaUsers).append(", ");
        sb.append("Lista de Empresas: ").append(this.listaEmpr).append(", ");
        sb.append("Lista de Voluntários: ").append(this.listaVol).append(", ");
        sb.append("Lista de Logins: ").append(this.listaLogs);
        return sb.toString();
    }

    public Sistema clone() {
        return new Sistema(this);
    }


    //Adiciona um utilizador ao sistema
    public Sistema addUser(User c) {
        this.listaUsers.add(c);
        return this;
    }

    //Verifica se  já existe
    public boolean existsUser(User c) {
        return this.listaUsers.contains(c);
    }

    //Adiciona um voluntario ao sistema
    public Sistema addVoluntario(Volunteer c) {
        this.listaVol.add(c);
        return this;
    }

    //Verifica se o voluntario já existe
    public boolean existsVolunatario(Volunteer c) {
        return this.listaVol.contains(c);
    }

    //Adiciona uma loja ao sistema
    public Sistema addLoja(Loja c) {
        this.listaLojas.add(c);
        return this;
    }

    //Verifica se a loja já existe
    public boolean existsLoja(Loja c, int tipo) {

        if (tipo == 1) return this.supermecados.contains(c);
        if (tipo == 2) return this.restaurantes.contains(c);
        if (tipo == 3) return this.roupas.contains(c);
        if (tipo == 4) return this.farmacias.contains(c);
        return false;
    }

    public boolean existeLojaSupermecado() {
        return false;
    }

    //Adiciona um utilizador ao sistema
    public Sistema addEmpresa(Empresa c) {
        this.listaEmpr.add(c);
        return this;
    }

    //Verifica se o utilizador já existe
    public boolean existsEmpresa(Empresa c) {
        return this.listaEmpr.contains(c);
    }

    //Adiciona um Login ao sistema
    public Sistema addLogin(Login l) {
        this.listaLogs.add(l);
        return this;
    }

    //Verifica se o Login já existe
    public boolean existsLogin(Login c) {
        return this.listaLogs.contains(c);
    }

    public static void insereLoja(Loja l, Sistema s, int tipo) {
        boolean res;
        /** Esta função primeiro verifica se a loja ja existe e se for false insere com o set */
        res = s.existsLoja(l, tipo);
        if (res == false) {
            if (tipo == 1) {
                s.supermecados.add(l);
                System.out.println("Supermecado inserido no Sistema\n\n");
            }

            if (tipo == 2) {
                s.restaurantes.add(l);
                System.out.println("Restaurante inserido no Sistema\n\n");
            }
        if (tipo == 3) {
            s.roupas.add(l);
            System.out.println("Loja de roupa inserida no Sistema\n\n");
        }
        if (tipo == 4) {
            s.farmacias.add(l);
            System.out.println("Farmácia inserida no Sistema\n\n");
        }
    } else System.out.println("Loja já existe");

}
    public static void insereUser(User u, Sistema s){
        boolean res= false;
        res= s.existsUser(u);
        /** Verifica se o user ja existe antes de inserir */
        if (res == false) {
            s.listaUsers.add(u);
            //System.out.println("User inserido no Sistema\n\n");
        }
       else System.out.println("User já existente\n\n");
    }

    public static void insereEmpresa (Empresa e,Sistema s){
        //Verifica se a empresa existe antes de inserir
        boolean res= s.existsEmpresa(e);
        if (res==false) {
            s.listaEmpr.add(e);
            //System.out.println("Empresa inserida no Sistema\n\n");
        }
        else System.out.println("Empresa já existente\n\n");
    }

    public static void insereVol (Volunteer v,Sistema s) {
        //verifica se existe antes de inserir

        boolean res = s.existsVolunatario(v);
        if (!res) {
            s.listaVol.add(v);
            //System.out.println("Voluntario inserido no Sistema\n\n");
        }
        else System.out.println("Voluntario já existente\n\n");
    }

    public static void insereLogin (Login l , Sistema s){
        boolean res = s.existsLogin(l);
        if(!res){
            s.addLogin(l);
        }
        else System.out.println("Este usuário já tem registo.");
    }

    public String getNomeUser(String userID){
        if(userID.charAt(0)=='u'){
            for(User user : this.listaUsers){
                if(user.getUserID().equals(userID)){
                    return (user.getUserName());
                }
            }
        }
        return "nao encontrado";
    }

   public static void printaSupermecados(Sistema s) {
        System.out.println("Entrou na printa");
    /**    for(Loja loja : s.supermecados){
            System.out.println("Entrou no for");
            System.out.println(loja);
        }*/

       s.supermecados.stream().forEach(sup -> System.out.println(sup));
    }

    public static void printaRestaurantes (Sistema s) {
        for( Loja loja : s.restaurantes ){
            System.out.println( loja );
        }
    }

    public static void printaRoupas (Sistema s){
        for( Loja loja : s.roupas ){
            System.out.println( loja );
        }

    }

    public static void printaFarmacias (Sistema s) {
        int i=1;
        for( Loja loja : s.farmacias ){
            System.out.println("Loja "+ i+"- "+ loja.getNome());
            loja.stock.forEach((Produto p) -> {System.out.println(p.toString());});
            i++;
        }
    }
    public static Loja getLoja(String lojaId, Sistema s) {
        Loja res = new Loja();
        char c= lojaId.charAt(1);
        if(c=='r'){
            for (Loja l : s.roupas) {
                if (l.getCodLoja().equals(lojaId)) {
                    res = l;
                }
            }
        }

        if(c=='c'){
            for (Loja l : s.restaurantes) {
                if (l.getCodLoja().equals(lojaId)) {
                    res = l;
                }
            }
        }

        if(c=='f') {
            for (Loja l : s.farmacias) {
                if (l.getCodLoja().equals(lojaId)) {
                    res = l;
                }
            }
        }
        if(c=='s'){
            for (Loja l : s.farmacias) {
                if (l.getCodLoja().equals(lojaId)) {
                    res = l;
                }
            }
        }

        System.out.println(res.toString());
     return res;

    }
}