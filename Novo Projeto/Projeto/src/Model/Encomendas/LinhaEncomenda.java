package Model.Encomendas;

import java.util.Objects;

public class LinhaEncomenda implements ILinhaEncomenda{
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

    public LinhaEncomenda(LinhaEncomenda linha){
        this.codProduto = linha.getCodProduto();
        this.descricao = linha.getDescricao();
        this.quantidade = linha.getQuantidade();
        this.valor = linha.getValor();
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
        return "Código do Produto: " + codProduto +
                "\nDescrição: " + descricao +
                "\nQuantidade: " + quantidade +
                "\nPreço: " + valor +"\n";
    }

    public LinhaEncomenda clone(){
        return new LinhaEncomenda(this);
    }

    public void insereLinhaEncomenda (String aux1, String aux2, String aux3, String aux4){
        this.codProduto = aux1;
        this.descricao = aux2;
        this.quantidade = Float.parseFloat(aux3);
        this.valor = Float.parseFloat(aux4);
        //System.out.print(l.toString());
    }
}

