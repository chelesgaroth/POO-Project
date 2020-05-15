import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Loja {

    private int existeEncomenda;
    private int pessoasFila;
    private String nome;
    private String codLoja;
    private LocalDateTime tempo;
    private double latitude;
    private double longitude;
    private double tempoPessoa; //tempo medio a atender uma pessoa
    ArrayList<Encomenda> encs; //encomendas validadas que a loja tem de preparar

    public Loja () {
        this.existeEncomenda = 0;
        this.pessoasFila = 0;
        this.tempo = LocalDateTime.now();
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.tempoPessoa  = 0.0;
        this.encs= new ArrayList<>();
    }

    public Loja (int existeEncomenda, int pessoasFila, LocalDateTime tempo, double latitude, double longitude, double tempoPessoa,ArrayList <Encomenda> encs){
       this.existeEncomenda = existeEncomenda;
       this.pessoasFila = pessoasFila;
       this.tempo = tempo;
       this.latitude = latitude;
       this.longitude = longitude;
       this.tempoPessoa = tempoPessoa;
       this.encs = new ArrayList<>();
       for(Encomenda e : encs) {
            this.encs.add(e.clone());
       }
    }

    public Loja (Loja l){
     l.existeEncomenda = l.getExisteEncomenda();
     l.pessoasFila = l.getPessoasFila();
     l.tempo = l.getTempo();
     l.latitude = l.getLatitude();
     l.longitude = l.getLongitude();
     l.encs = l.getEncs();
    }
    public int getExisteEncomenda() {
        return this.existeEncomenda;
    }

    public void setExisteEncomenda(int existeEncomenda) {
        this.existeEncomenda = existeEncomenda;
    }

    public int getPessoasFila() {
        return this.pessoasFila;
    }

    public void setPessoasFila(int pessoasFila) {
        this.pessoasFila = pessoasFila;
    }

    public LocalDateTime getTempo() {
        return this.tempo;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getTempoPessoa() {
        return tempoPessoa;
    }

    public void setTempoPessoa(double tempoPessoa) {
        this.tempoPessoa = tempoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodLoja() {
        return codLoja;
    }

    public void setCodLoja(String codLoja) {
        this.codLoja = codLoja;
    }

    public ArrayList<Encomenda> getEncs() {
        ArrayList<Encomenda> encs = new ArrayList<>() ;
        for (Encomenda e: this.encs){
            encs.add(e.clone());
        }
        return this.encs;
    }

    public void setEncs(ArrayList<Encomenda> encs) {
        ArrayList<Encomenda> encos = new ArrayList<> ();
        for (Encomenda e: encos){
            encos.add(e.clone());
        }
        this.encs = encos;
    }

    public Loja clone(){
        return new Loja (this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loja loja = (Loja) o;
        return existeEncomenda == loja.existeEncomenda &&
                pessoasFila == loja.pessoasFila &&
                Double.compare(loja.latitude, latitude) == 0 &&
                Double.compare(loja.longitude, longitude) == 0 &&
                Double.compare(loja.tempoPessoa, tempoPessoa) == 0 &&
                Objects.equals(tempo, loja.tempo) &&
                Objects.equals(encs, loja.encs);
    }

    @Override
    public String toString() {
        return "Loja{" +
                "existeEncomenda=" + existeEncomenda +
                ", pessoasFila=" + pessoasFila +
                ", nome='" + nome + '\'' +
                ", codLoja='" + codLoja + '\'' +
                ", tempo=" + tempo +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", tempoPessoa=" + tempoPessoa +
                ", encs=" + encs +
                '}';
    }

    public static void  insereLoja(String aux,Sistema s){
        Loja l = new Loja();
        String [] auxiliar = aux.split(",",2);

      //  System.out.println (aux);
        l.setCodLoja(auxiliar[0]);
        l.setNome(auxiliar[1]);
     //   System.out.println(auxiliar[0]);

        l.toString();
        Sistema.insereLoja(l,s);


    }
}
