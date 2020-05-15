import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Encomenda {
    private String encomendaID;
    private String userID;
    private String lojaID;
    private double pesoTotal;
    //private LinhaEncomenda linhaE;
    private ArrayList<LinhaEncomenda> prods;
    private boolean medicamentos;
    private boolean congelados;
    private LocalTime horaEntrega; // se é null entao tem ser entregue o mais rapido possivel
    private boolean validacao;

    public Encomenda (){
        this.userID = "n/a";
        this.lojaID = "n/a";
        this.pesoTotal = 0.0;
        this.prods = new ArrayList<>();
        this.medicamentos = false;
        this.congelados = false;
        this.horaEntrega = LocalTime.now();
        this.validacao = false;
        //this.linhaE = null;
    }

    public Encomenda (String userID, String lojaID, int pesoTotal, ArrayList<LinhaEncomenda> prods, boolean medicamentos,
                      boolean congelados, LocalTime horaEntrega, boolean validacao){
        this.userID = userID;
        this.lojaID = lojaID;
        this.pesoTotal = pesoTotal;
        this.prods = new ArrayList<>();
        for(LinhaEncomenda enc : prods){
            this.prods.add(enc.clone());
        }
        this.medicamentos = medicamentos;
        this.congelados = congelados;
        this.horaEntrega = horaEntrega;
        this.validacao = validacao;
        //this.linhaE = linhaE;
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

    public String getEncomendaID() {
        return encomendaID;
    }

    public void setEncomendaID(String encomendaID) {
        this.encomendaID = encomendaID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getLojaID() {
        return this.lojaID;
    }

    public double getPesoTotal() {
        return this.pesoTotal;
    }

    public ArrayList<LinhaEncomenda> getProds() {
        ArrayList<LinhaEncomenda> newprods = new ArrayList<>();
        for(LinhaEncomenda linha : this.prods){
            newprods.add(linha.clone());
        }
        return newprods;
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

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public void setProds(ArrayList<LinhaEncomenda> prods) {
        ArrayList<LinhaEncomenda> newProds = new ArrayList<>();
        for(LinhaEncomenda linha : prods){
            newProds.add(linha.clone());
        }
        this.prods = newProds;
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
        StringBuffer sb = new StringBuffer("\n\nEncomenda: ");
        sb.append("\nUsername: ").append(this.userID).append(", ");
        sb.append("\nLoja: ").append(this.lojaID).append(", ");
        sb.append("\nPeso Total: ").append(this.pesoTotal).append(", ");
        sb.append("\nProdutos encomendados: ").append(this.prods).append(", ");
        sb.append("\nAlgum dos produtos é um medicamento?: ").append(this.medicamentos).append(", ");
        sb.append("\nAlgum dos produtos é um congelado?").append(this.congelados).append(", ");
        sb.append("\nA que horas o utilizador quer a encomenda?").append(this.horaEntrega).append(", ");
        sb.append("\nA encomenda foi validada?").append(this.validacao).append("\n\n");
        return sb.toString();
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public static void insereEncomenda (String aux){
        Encomenda e = new Encomenda();
        String [] auxiliar = aux.split(",");
        e.setEncomendaID(auxiliar[0]);
        e.setUserID(auxiliar[1]);
        e.setLojaID(auxiliar[2]);
        double peso = Double.parseDouble(auxiliar[3]);
        e.setPesoTotal(peso);
        ArrayList<LinhaEncomenda> linhas = new ArrayList<>();
        /*LinhaEncomenda linha = LinhaEncomenda.insereLinhaEncomenda(auxiliar[4],auxiliar[5],auxiliar[6],auxiliar[7]);
        linhas.add(linha);*/
        int i=4;
        while(auxiliar[i] != null){
            System.out.printf("%s,%s,%s,%s \n", auxiliar[i],auxiliar[i+1],auxiliar[i+2],auxiliar[i+3]);
            LinhaEncomenda linha = LinhaEncomenda.insereLinhaEncomenda(auxiliar[i],auxiliar[i+1],auxiliar[i+2],auxiliar[i+3]);
            linhas.add(linha);
            System.out.printf("\nnext encomenda %d\n",i);
            //System.out.printf("\n%s\n",auxiliar[68]);
            //System.out.printf("\nERRO %s\n",auxiliar[69]);
            i=i+4;
        }
        System.out.print("FIM DO CICLO");
        e.setProds(linhas);
        System.out.print(e.toString());

    }
}
