
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Empresa {
    private String idEmpresa;
    private String nome;
    private double latitude; //y
    private double longitude; //x
    private int nif;
    private double raio;
    private double preco; // preco por km

    private int aceitaEncomenda;
    private int aceitaMedicamento;
    private LocalDateTime tempo;
    private double taxaAdicional;
    private boolean chuva;
    private boolean transito;


    public Empresa () {
        this.aceitaEncomenda = 0;
        this.aceitaMedicamento =0;
        this.tempo = LocalDateTime.now();
        this.preco = 0.0;
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.raio = 0.0;
        this.taxaAdicional = 0.0;
        this.chuva = false;
        this.transito = false;
        this.nome = null;
        this.nif = 0;

    }

    public Empresa (int aceitaEncomenda,int nif, int aceitaMedicamento, LocalDateTime tempo, double preco, double longitude,
                    double latitude, double raio, double taxaAdicional, boolean chuva, boolean transito, String loja) {
        this.aceitaEncomenda = aceitaEncomenda;
        this.aceitaMedicamento = aceitaMedicamento;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tempo = tempo;
        this.preco = preco;
        this.raio = raio;
        this.taxaAdicional = taxaAdicional;
        this.chuva = chuva;
        this.transito = transito;
        this.nome = loja;
        this.nif = nif;
    }

    public Empresa (Empresa emp) {
        emp.aceitaEncomenda = emp.getAceitaEncomenda();
        emp.aceitaMedicamento = emp.getAceitaMedicamento();
        emp.raio = emp.getRaio();
        emp.tempo = emp.getTempo();
        emp.longitude = emp.getLongitude();
        emp.latitude = emp.getLatitude();
        emp.preco = emp.getPreco();
        emp.transito = emp.getTransito();
        emp.chuva = emp.getChuva();
        emp.taxaAdicional = emp.getTaxaAdicional();
        emp.nome = emp.getNome();
        emp.nif = emp.getNif();
    }
    public int getAceitaEncomenda() {

        return this.aceitaEncomenda;
    }

    public void setAceitaEncomenda(int aceitaEncomenda) {

        this.aceitaEncomenda = aceitaEncomenda;
    }

    public LocalDateTime getTempo() {

        return this.tempo;
    }

     public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {

        this.preco = preco;
    }

    public String getIdEmpresa() {
        return this.idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getAceitaMedicamento() {
          return this.aceitaMedicamento;
      }

      public void setAceitaMedicamento(int aceitaMedicamento) {
          this.aceitaMedicamento = aceitaMedicamento;
      }

      public double getLatitude() {
          return this.latitude;
      }

      public void setLatitude(double latitude) {
          this.latitude = latitude;
      }

      public double getLongitude() {
          return this.longitude;
      }

      public void setLongitude(double longitude) {
          this.longitude = longitude;
      }

      public double getRaio() {
          return this.raio;
      }

      public void setRaio(double raio) {
          this.raio = raio;
      }

    public double getTaxaAdicional() {
        return this.taxaAdicional;
    }

    public void setTaxaAdicional(double taxaAdicional) {
        this.taxaAdicional = taxaAdicional;
    }

    public boolean getChuva() {

        return this.chuva;
    }

    public void setChuva(boolean chuva) {
        this.chuva = chuva;
    }

    public boolean getTransito() {
        return this.transito;
    }

    public void setTransito(boolean transito) {
        this.transito = transito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public Empresa clone () {
        return new Empresa(this);
      }



    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return aceitaEncomenda == empresa.aceitaEncomenda &&
                aceitaMedicamento == empresa.aceitaMedicamento &&
                Double.compare(empresa.preco, preco) == 0 &&
                Double.compare(empresa.latitude, latitude) == 0 &&
                Double.compare(empresa.longitude, longitude) == 0 &&
                Double.compare(empresa.raio, raio) == 0 &&
                Double.compare(empresa.taxaAdicional, taxaAdicional) == 0 &&
                chuva == empresa.chuva &&
                transito == empresa.transito &&
                Objects.equals(tempo, empresa.tempo);
    }

    //Transportadora:<CodEmpresa>,<NomeEmpresa>,<GPS>,<NIF>,<raio>,<preco-por-km>
    public String toString() {
        return "Transportadora:" +
                idEmpresa + "," +
                nome + "," +
                longitude + "," +
                latitude + "," +
                nif + "," +
                raio + "," +
                preco;
    }
    public static Empresa insereTransportadora(String aux,Sistema s){

        Empresa e = new Empresa();
        String[] id= aux.split (",");

        e.setIdEmpresa(id[0]);
        e.setNome(id[1]);
        e.setLongitude(Double.parseDouble(id[2]));
        e.setLatitude(Double.parseDouble(id[3]));
        e.setNif(Integer.parseInt(id[4]));
        e.setRaio(Double.parseDouble(id[5]));
        e.setPreco(Double.parseDouble(id[6]));

        Sistema.insereEmpresa(e,s);
        return e;
    }

}
