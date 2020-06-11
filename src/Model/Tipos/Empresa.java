package Model.Tipos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class
Empresa extends Tipo implements IEmpresa, Serializable {
    private int nif;
    private double raio;
    private double preco; // preco por km

    private boolean disponibilidade;
    private boolean aceitaMedicamento;
    private LocalDateTime tempo;
    private double taxaAdicional;
    private boolean chuva;
    private boolean transito;

    private int classificacao;


    public Empresa () {

        this.nif = 0;
        this.preco = 0.0;
        this.raio = 0.0;
        this.disponibilidade = false;


        this.aceitaMedicamento = false;
        this.tempo = LocalDateTime.now();
        this.taxaAdicional = 0.0;
        this.chuva = false;
        this.transito = false;
        this.classificacao = 5;
    }

    public Empresa (String id,int nif, boolean aceitaMedicamento, LocalDateTime tempo, double preco, float longitude,
                    float latitude, double raio, double taxaAdicional, boolean chuva, boolean transito, String nome) {

        super(id,nome,longitude,latitude);
        this.nif = nif;
        this.preco = preco;
        this.raio = raio;


        this.aceitaMedicamento = aceitaMedicamento;
        this.tempo = tempo;
        this.taxaAdicional = taxaAdicional;
        this.chuva = chuva;
        this.transito = transito;
    }

    public Empresa (Empresa emp) {
        super(emp);

        emp.aceitaMedicamento = emp.getAceitaMedicamento();
        emp.raio = emp.getRaio();
        emp.tempo = emp.getTempo();
        emp.preco = emp.getPreco();
        emp.transito = emp.getTransito();
        emp.chuva = emp.getChuva();
        emp.taxaAdicional = emp.getTaxaAdicional();
        emp.nif = emp.getNif();
    }

    //Getters e Setters

    public int getNif() {
        return this.nif;
    }
    public double getPreco() {
        return preco;
    }
    public double getRaio() {
        return this.raio;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }
    public void setRaio(double raio) {
        this.raio = raio;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    //Variaveis para a App
    public boolean getAceitaMedicamento() {
        return this.aceitaMedicamento;
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


    public void setAceitaMedicamento(boolean aceitaMedicamento) {
        this.aceitaMedicamento = aceitaMedicamento;
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


    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Empresa clone () {
        return new Empresa(this);
      }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa)) return false;
        Empresa empresa = (Empresa) o;
        return  super.equals(empresa) &&
                getNif() == empresa.getNif() &&
                Double.compare(empresa.getRaio(), getRaio()) == 0 &&
                Double.compare(empresa.getPreco(), getPreco()) == 0 &&
                Objects.equals(getNome(), empresa.getNome());
    }


    //Transportadora:<CodEmpresa>,<NomeEmpresa>,<GPS>,<NIF>,<raio>,<preco-por-km>
    public String toString() {
        return "Transportadora:" +
                this.getId()+ "," +
                this.getNome() + "," +
                this.getX() + "," +
                this.getY() + "," +
                nif + "," +
                raio + "," +
                preco;
    }

}
