import java.util.ArrayList;

public class Entrega {                  //Encomendas Aceites já entregues
    private Encomenda enco;             //Detalhes da encomenda que foi entregue
    private int precoTotal;             //Total pago
    private int taxaCobrada;            //Taxa da empresa
    private int taxasAdicionais;        //Taxa adicional paga
    private int distLojaCasa;           //dist percorrida em metros
    private String transporte;          //nome do voluntario ou da empresa que fez o transporte

    public Entrega (){
        this.enco = new Encomenda();
        this.precoTotal = 0;
        this.taxaCobrada = 0;
        this.taxasAdicionais = 0;
        this.distLojaCasa = 0;
        this.transporte = "n/a";
    }

    public Entrega (Encomenda enco, int precoTotal, int taxaCobrada, int taxasAdicionais, int distLojaCasa, String transporte){
        this.enco = enco;
        this.precoTotal = precoTotal;
        this.taxaCobrada = taxaCobrada;
        this.taxasAdicionais = taxasAdicionais;
        this.distLojaCasa = distLojaCasa;
        this.transporte = transporte;
    }

    public Entrega (Entrega ent){
        this.enco = ent.getEnco();
        this.precoTotal = ent.getPrecoTotal();
        this.taxaCobrada = ent.getTaxaCobrada();
        this.taxasAdicionais = ent.getTaxasAdicionais();
        this.distLojaCasa = ent.getDistLojaCasa();
        this.transporte = ent.getTransporte();
    }

    public Encomenda getEnco() {
        return this.enco.clone();
    }

    public int getPrecoTotal() {
        return this.precoTotal;
    }

    public int getTaxaCobrada() {
        return this.taxaCobrada;
    }

    public int getTaxasAdicionais() {
        return taxasAdicionais;
    }

    public int getDistLojaCasa() {
        return distLojaCasa;
    }

    public String getTransporte() {
        return transporte;
    }


    public void setEnco(Encomenda enco) {
        this.enco = enco.clone();
    }

    public void setPrecoTotal(int precoTotal) {
        this.precoTotal = precoTotal;
    }

    public void setTaxaCobrada(int taxaCobrada) {
        this.taxaCobrada = taxaCobrada;
    }

    public void setTaxasAdicionais(int taxasAdicionais) {
        this.taxasAdicionais = taxasAdicionais;
    }

    public void setDistLojaCasa(int distLojaCasa) {
        this.distLojaCasa = distLojaCasa;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrega entrega = (Entrega) o;
        return this.enco.equals(entrega.getEnco()) &&
                this.precoTotal == entrega.precoTotal &&
                this.taxaCobrada == entrega.taxaCobrada &&
                this.taxasAdicionais == entrega.taxasAdicionais &&
                this.distLojaCasa == entrega.distLojaCasa &&
                this.transporte.equals(entrega.getTransporte());
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Entrega: ");
        sb.append("Encomenda Entregue: ").append(this.enco).append(", ");
        sb.append("Preço Total: ").append(this.precoTotal).append(", ");
        sb.append("Taxa Total Cobrada: ").append(this.taxaCobrada).append(", ");
        sb.append("Taxas Adicionais: ").append(this.taxasAdicionais).append(", ");
        sb.append("Distancia percorrida(em metros): ").append(this.distLojaCasa).append(", ");
        sb.append("Transporte feito por: ").append(this.transporte);
        return sb.toString();
    }

    public Entrega clone(){
        return new Entrega(this);
    }
}
