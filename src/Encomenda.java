import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Encomenda {
    private String userID;
    private String lojaID;
    private int pesoTotal;
    private ArrayList<String> prods;
    private boolean medicamentos;
    private boolean congelados;
    private LocalTime horaEntrega; // se é null entao tem ser entregue o mais rapido possivel
    private boolean validacao;

    public Encomenda (){
        this.userID = "n/a";
        this.lojaID = "n/a";
        this.pesoTotal = 0;
        this.prods = new ArrayList<>();
        this.medicamentos = false;
        this.congelados = false;
        this.horaEntrega = LocalTime.now();
        this.validacao = false;
    }

    public Encomenda (String userID, String lojaID, int pesoTotal, ArrayList<String> prods, boolean medicamentos,
                      boolean congelados, LocalTime horaEntrega, boolean validacao){
        this.userID = userID;
        this.lojaID = lojaID;
        this.pesoTotal = pesoTotal;
        this.prods = new ArrayList<>(prods);
        this.medicamentos = medicamentos;
        this.congelados = congelados;
        this.horaEntrega = horaEntrega;
        this.validacao = validacao;
    }

    public Encomenda (Encomenda enco){
        this.userID = enco.getUserID();
        this.lojaID = enco.getLojaID();
        this.pesoTotal = enco.getPesoTotal();
        this.prods = enco.getProds();
        this.medicamentos = enco.getMedicamentos();
        this.congelados = enco.getCongelados();
        this.horaEntrega = enco.getHoraEntrega();
        this.validacao = enco.getValidacao();
    }

    public String getUserID() {
        return this.userID;
    }

    public String getLojaID() {
        return this.lojaID;
    }

    public int getPesoTotal() {
        return this.pesoTotal;
    }

    public ArrayList<String> getProds() {
        return  new ArrayList<>(this.prods);
    }

    public boolean getMedicamentos(){
        return this.medicamentos;
    }

    public boolean getCongelados(){
        return this.congelados;
    }

    public LocalTime getHoraEntrega() {
        return this.horaEntrega;
    }

    public boolean getValidacao(){
        return this.validacao;
    }


    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setLojaID(String lojaID) {
        this.lojaID = lojaID;
    }

    public void setPesoTotal(int pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public void setProds(ArrayList<String> prods) {
        this.prods = new ArrayList<>(prods);
    }

    public void setMedicamentos(boolean medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void setCongelados(boolean congelados) {
        this.congelados = congelados;
    }

    public void setHoraEntrega(LocalTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public void setValidacao(boolean validacao) {
        this.validacao = validacao;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return this.pesoTotal == encomenda.pesoTotal &&
                this.medicamentos == encomenda.medicamentos &&
                this.congelados == encomenda.congelados &&
                this.validacao == encomenda.validacao &&
                this.userID.equals(encomenda.getUserID()) &&
                this.lojaID.equals(encomenda.getLojaID()) &&
                this.prods.equals(encomenda.getProds()) &&
                this.horaEntrega.equals(encomenda.getHoraEntrega());
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Encomenda: ");
        sb.append("Username: ").append(this.userID).append(", ");
        sb.append("Loja: ").append(this.lojaID).append(", ");
        sb.append("Peso Total: ").append(this.pesoTotal).append(", ");
        sb.append("Produtos encomendados: ").append(this.prods).append(", ");
        sb.append("Algum dos produtos é um medicamento?: ").append(this.medicamentos).append(", ");
        sb.append("Algum dos produtos é um congelado?").append(this.congelados).append(", ");
        sb.append("A que horas o utilizador quer a encomenda?").append(this.horaEntrega).append(", ");
        sb.append("A encomenda foi validada?").append(this.validacao).append(", ");
        return sb.toString();
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }
}
