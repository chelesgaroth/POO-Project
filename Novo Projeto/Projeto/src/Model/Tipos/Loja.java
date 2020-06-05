package Model.Tipos;

import Model.Catalogos.CatalogoProds;
import Model.Catalogos.ICatalogoProds;
import Model.Encomendas.Encomenda;
import Model.Encomendas.ILinhaEncomenda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Loja implements ILoja {
    //Variáveis do ficheiro Logs.txt
    private String nome;
    private String codLoja;
    private double latitude;
    private double longitude;

    //Variáveis para a App
    private int existeEncomenda;
    private int pessoasFila;
    private LocalDateTime tempo;
    private int tipo;
    private double tempoPessoa; //tempo medio a atender uma pessoa
    ArrayList<Encomenda> encs; //encomendas validadas que a loja tem de preparar

    private ICatalogoProds stock; //Stock da loja

    public Loja () {
        //Variáveis do ficheiro Logs.txt
        this.nome = null;
        this.codLoja = null;
        this.latitude = 0.0;
        this.longitude = 0.0;

        //Variáveis da App
        this.tempo = LocalDateTime.now();
        this.tempoPessoa  = 0.0;
        this.encs= new ArrayList<>();
        this.existeEncomenda = 0;
        this.pessoasFila = 0;

        this.stock = new CatalogoProds();
    }

    public Loja (String nome, String codLoja, int existeEncomenda, int pessoasFila, LocalDateTime tempo, double latitude, double longitude,
                 double tempoPessoa,ArrayList <Encomenda> encs, ICatalogoProds stock){

        //Variáveis do ficheiro Logs.txt
        this.nome = nome;
        this.codLoja = codLoja;
        this.latitude = latitude;
        this.longitude = longitude;


        //Variáveis da App
        this.existeEncomenda = existeEncomenda;
        this.pessoasFila = pessoasFila;
        this.tempo = tempo;
        this.tempoPessoa = tempoPessoa;
        this.encs = new ArrayList<>();
        for(Encomenda e : encs) {
            this.encs.add(e.clone());
        }

        this.stock = stock;

    }

    public Loja (Loja l){

        //Variáveis do ficheiro Logs.txt
        l.nome = l.getNome();
        l.codLoja = l.getCodLoja();
        l.latitude = l.getLatitude();
        l.longitude = l.getLongitude();

        //Variáveis da App
        l.existeEncomenda = l.getExisteEncomenda();
        l.pessoasFila = l.getPessoasFila();
        l.tempo = l.getTempo();
        l.encs = l.getEncs();

        l.stock = l.getStock();
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



    //Getters and Setters

    //Getters das variáveis do ficheiro Logs.txt

    public String getNome() {
        return nome;
    }
    public String getCodLoja() {

        return codLoja;
    }
    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }


    //Setters das variáveis do ficheiro Logs.txt

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setCodLoja(String codLoja) {
        this.codLoja = codLoja;
    }


    //Getters das variáveis da App
    public int getExisteEncomenda() {
        return this.existeEncomenda;
    }

    public int getPessoasFila() {
        return this.pessoasFila;
    }

    public LocalDateTime getTempo() {
        return this.tempo;
    }

    public double getTempoPessoa() {
        return tempoPessoa;
    }

    public int getTipo() {
        return tipo;
    }

    public ArrayList<Encomenda> getEncs() {
        ArrayList<Encomenda> encs = new ArrayList<>() ;
        for (Encomenda e: this.encs){
            encs.add(e.clone());
        }
        return this.encs;
    }

    public ICatalogoProds getStock() {
        return stock;
    }

    //Setters das Variávies da App
    public void setExisteEncomenda(int existeEncomenda) {
        this.existeEncomenda = existeEncomenda;
    }

    public void setPessoasFila(int pessoasFila) {
        this.pessoasFila = pessoasFila;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }


    public void setTempoPessoa(double tempoPessoa) {
        this.tempoPessoa = tempoPessoa;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setEncs(ArrayList<Encomenda> encs) {
        ArrayList<Encomenda> encos = new ArrayList<> ();
        for (Encomenda e: encos){
            encos.add(e.clone());
        }
        this.encs = encos;
    }

    public void setStock(ICatalogoProds stock) {
        this.stock = stock;
    }

    //Método Clone
    public Loja clone(){
        return new Loja(this);
    }

    //Equals para as variáveis do ficheiro Logs.txt
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

    //HashCode para as variáveis do ficheiro Logs.txt
    public int hashCode() {
        return Objects.hash(nome, codLoja, latitude, longitude);
    }

    public String toString() {
        return "Loja:" +
                codLoja + "," +
                nome + "\n" ;//+
                //stock;
    }

    public Loja criaLoja(String aux){
        String [] auxiliar = aux.split(",",3);
        Loja l = new Loja();
        l.setCodLoja(auxiliar[0]);
        l.setNome (auxiliar[1]);
      return l;
    }


    /*

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