package Model.Modes;

import Model.Encomenda;

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
    private int tipo;
    private double tempoPessoa; //tempo medio a atender uma pessoa
    ArrayList<Encomenda> encs; //encomendas validadas que a loja tem de preparar
    //HashSet<Produto> stock;

    public Loja () {
        this.existeEncomenda = 0;
        this.pessoasFila = 0;
        this.tempo = LocalDateTime.now();
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.tempoPessoa  = 0.0;
        this.encs= new ArrayList<>();
        //this.stock = new HashSet<>();
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
       /*this.stock = new HashSet<>();
        for (Produto p: stock){
            this.stock.add(p.clone());
        }*/

    }

    public Loja (Loja l){
     l.existeEncomenda = l.getExisteEncomenda();
     l.pessoasFila = l.getPessoasFila();
     l.tempo = l.getTempo();
     l.latitude = l.getLatitude();
     l.longitude = l.getLongitude();
     l.encs = l.getEncs();
     //l.stock = l.getStock();
    }

    /*public HashSet<Produto> getStock() {
        HashSet<Produto> stock = new HashSet<>() ;
        for (Produto p: this.stock){
            stock.add(p.clone());
        }
        return this.stock;
    }

    public void setStock(HashSet<Produto> stock) {
       // HashSet<Produto> stock = new HashSet<>() ;
        for (Produto p: stock){
            stock.add(p.clone());
        }
        this.stock = stock;
    }*/

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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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
                tipo == loja.tipo &&
                Double.compare(loja.tempoPessoa, tempoPessoa) == 0 &&
                Objects.equals(nome, loja.nome) &&
                Objects.equals(codLoja, loja.codLoja) &&
                Objects.equals(tempo, loja.tempo) &&
                Objects.equals(encs, loja.encs);
                //Objects.equals(stock, loja.stock);
    }


    public String toString() {
        return "Loja:" +
                codLoja + "," +
                nome + "," +tipo;
    }

    /*
    public static Loja insereLoja(String aux, Sistema s){
        Loja l = new Loja();
        String [] auxiliar = aux.split(",",3);

       // System.out.println("Linha "+aux);
        l.setCodLoja(auxiliar[0]);
        l.setNome(auxiliar[1]);
        int tipo = Integer.parseInt(auxiliar[2]);
        l.setTipo(tipo);
        Sistema.insereLoja(l,s,tipo);
        return l;

    }


    public static Loja insereProdutoLoja(String aux, Sistema s) {
       Produto p = new Produto();
        String [] auxiliar = aux.split(",");
        //System.out.println("Linha "+aux);
        String idLoja = auxiliar[3];

        //    System.out.println("Vai procurar a loja de id "+idLoja);
           Loja l = Sistema.getLoja(idLoja, s);

         p.setProdId(auxiliar[0]);
        p.setNome(auxiliar[1]);
        int quantidade = Integer.parseInt(auxiliar[2]);
        p.setQuantidade(quantidade);
        p.setLojaId(idLoja);

         l.stock.add(p);


         //System.out.println("PRODUTO "+ p.getNome() + " LOJA "+ l.getNome());
        // System.out.println("Saí do insere produto");
        return l;
    }

    public static void printaStock (Loja l) {
        HashSet<Produto> stock = l.stock;
        int i=1;
        for (Produto p : stock) {
            System.out.println("Produto "+i+"- "+p.getNome());
            i++;
        }
    }

     */
}
