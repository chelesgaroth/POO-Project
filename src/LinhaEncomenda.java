import java.util.Objects;

public class LinhaEncomenda {
    private String codProduto;
    private String descricao;
    private float quantidade;
    private float valor;


    public LinhaEncomenda() {
        this.codProduto = "n/a";
        this.descricao = "n/a";
        this.quantidade = 0;
        this.valor = 0;

    }

    public LinhaEncomenda(String codProduto, String descricao, Float quantidade, Float valor) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getCodProduto() {
        return this.codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaEncomenda that = (LinhaEncomenda) o;
        return Float.compare(that.quantidade, quantidade) == 0 &&
                Float.compare(that.valor, valor) == 0 &&
                Objects.equals(codProduto, that.codProduto) &&
                Objects.equals(descricao, that.descricao);
    }

    public String toString() {
        return "LinhaEncomenda{" +
                "codProduto='" + codProduto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }

    public static void insereLinhaEncomenda (String aux1, String aux2, String aux3, String aux4){
        LinhaEncomenda l= new LinhaEncomenda();
        l.setCodProduto(aux1);
        l.setDescricao(aux2);
        float qtd = Float.parseFloat(aux3);
        l.setQuantidade(qtd);
        float preco = Float.parseFloat(aux4);
        l.setValor(preco);
        l.toString();


    }
}

