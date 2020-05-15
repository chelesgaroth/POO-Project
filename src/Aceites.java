import java.util.ArrayList;

public class Aceites {
    private ArrayList<String> aceites;

    //Construtor Vazio
    public Aceites(){
        this.aceites = new ArrayList<>();
    }

    //Construtor parametrizado
    public Aceites(ArrayList<String> nomes){
        this.aceites = new ArrayList<>(nomes);
    }

    //Construtor de cópia
    public Aceites(Aceites lista){
        this.aceites = lista.getAceites();
    }

    //Getter e Setter
    public ArrayList<String> getAceites(){
        return new ArrayList<>(this.aceites);
    }

    public void setAceites(ArrayList<String> lista){
        this.aceites = new ArrayList<>(lista);
    }

    //Equals
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || this.getClass() != o.getClass())
            return false;

        Aceites lista = (Aceites) o;
        return this.aceites.equals(lista.getAceites());
    }

    // toString
    public String toString(){
        StringBuffer sb = new StringBuffer("Encomendas Aceites: ");
        sb.append("\n").append(this.aceites);
        return sb.toString();
    }

    public static void insereAceites(String aux, Aceites c){

        c.aceites.add(aux);
        c.toString();
        int j=0;
        //for( j = 0; j <c.aceites.size();j++) {
        //     System.out.println("List  " +c.aceites.get(j));
        //}
       
    }
}
