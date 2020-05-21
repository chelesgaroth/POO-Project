package Model.Tipos;

import java.time.LocalDateTime;
import java.util.Objects;

public class Empresa implements IEmpresa{
    //Variaveis do logs.txt
    private String idEmpresa;
    private String nome;
    private double latitude; //y
    private double longitude; //x
    private int nif;
    private double raio;
    private double preco; // preco por km

    //Variaveis para a App
    private int aceitaEncomenda;
    private int aceitaMedicamento;
    private LocalDateTime tempo;
    private double taxaAdicional;
    private boolean chuva;
    private boolean transito;


    public Empresa () {
        //Variaveis do logs.txt
        this.idEmpresa = null;
        this.nome = null;
        this.nif = 0;
        this.preco = 0.0;
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.raio = 0.0;

        //Variaveis para a App
        this.aceitaEncomenda = 0;
        this.aceitaMedicamento =0;
        this.tempo = LocalDateTime.now();
        this.taxaAdicional = 0.0;
        this.chuva = false;
        this.transito = false;
    }

    public Empresa (String id,int aceitaEncomenda,int nif, int aceitaMedicamento, LocalDateTime tempo, double preco, double longitude,
                    double latitude, double raio, double taxaAdicional, boolean chuva, boolean transito, String loja) {
        this.idEmpresa = id;
        this.nome = loja;
        this.nif = nif;
        this.preco = preco;
        this.raio = raio;
        this.latitude = latitude;
        this.longitude = longitude;

        this.aceitaEncomenda = aceitaEncomenda;
        this.aceitaMedicamento = aceitaMedicamento;
        this.tempo = tempo;
        this.taxaAdicional = taxaAdicional;
        this.chuva = chuva;
        this.transito = transito;
    }

    public Empresa (Empresa emp) {
        emp.idEmpresa = emp.getIdEmpresa();
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

    //Getters e Setters

    //Variaveis do logs.txt
    public String getIdEmpresa() {
        return this.idEmpresa;
    }
    public String getNome() {
        return nome;
    }
    public int getNif() {
        return this.nif;
    }
    public double getPreco() {
        return preco;
    }
    public double getLatitude() {
        return this.latitude;
    }
    public double getLongitude() {
        return this.longitude;
    }
    public double getRaio() {
        return this.raio;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNif(int nif) {
        this.nif = nif;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setRaio(double raio) {
        this.raio = raio;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    //Variaveis para a App
    public int getAceitaMedicamento() {
        return this.aceitaMedicamento;
    }
    public int getAceitaEncomenda() {
        return this.aceitaEncomenda;
    }
    public LocalDateTime getTempo() {
        return this.tempo;
    }
    public boolean getTransito() {
        return this.transito;
    }
    public boolean getChuva() {

        return this.chuva;
    }
    public double getTaxaAdicional() {
        return this.taxaAdicional;
    }


    public void setAceitaMedicamento(int aceitaMedicamento) {
        this.aceitaMedicamento = aceitaMedicamento;
    }
    public void setAceitaEncomenda(int aceitaEncomenda) {

        this.aceitaEncomenda = aceitaEncomenda;
    }
    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public void setTaxaAdicional(double taxaAdicional) {
        this.taxaAdicional = taxaAdicional;
    }

    public void setChuva(boolean chuva) {
        this.chuva = chuva;
    }
    public void setTransito(boolean transito) {
        this.transito = transito;
    }


    public Empresa clone () {
        return new Empresa(this);
      }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa)) return false;
        Empresa empresa = (Empresa) o;
        return Double.compare(empresa.getLatitude(), getLatitude()) == 0 &&
                Double.compare(empresa.getLongitude(), getLongitude()) == 0 &&
                getNif() == empresa.getNif() &&
                Double.compare(empresa.getRaio(), getRaio()) == 0 &&
                Double.compare(empresa.getPreco(), getPreco()) == 0 &&
                Objects.equals(getIdEmpresa(), empresa.getIdEmpresa()) &&
                Objects.equals(getNome(), empresa.getNome());
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


    public void criaEmpresa(String aux){
        String[] id= aux.split (",");

        this.idEmpresa = (id[0]);
        this.nome = (id[1]);
        this.longitude = (Double.parseDouble(id[2]));
        this.latitude = (Double.parseDouble(id[3]));
        this.nif = (Integer.parseInt(id[4]));
        this.raio = (Double.parseDouble(id[5]));
        this.preco = (Double.parseDouble(id[6]));
    }
}
