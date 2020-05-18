import java.util.Objects;

public class Produto {
    private String prodId;
    private String nome;
    private int quantidade;
    private String lojaId;

    public Produto() {
        this.prodId = "n/a";
        this.nome = "n/a";
        this.quantidade = 0;
        this.lojaId = "n/a";

    }

    public Produto (Produto p) {
        p.prodId = p.getProdId();
        p.nome = p.getNome();
        p.quantidade = p.getQuantidade();
        p.lojaId = p.getLojaId();

    }

    public String getLojaId() {
        return lojaId;
    }

    public void setLojaId(String lojaId) {
        this.lojaId = lojaId;
    }

    public Produto(String prodId, String nome, int quantidade){
        this.prodId = prodId;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public Produto clone(){
        return new Produto(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return quantidade == produto.quantidade &&
                Objects.equals(prodId, produto.prodId) &&
                Objects.equals(nome, produto.nome) &&
                Objects.equals(lojaId, produto.lojaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, nome, quantidade, lojaId);
    }

    @Override
    public String toString() {
        return "Produto:" +
                prodId + ',' +
                  nome + ',' +
                 + quantidade +
                ","+ lojaId ;
    }
}
