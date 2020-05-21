package Model;

public interface ILinhaEncomenda {
    String getCodProduto();
    void setCodProduto(String codProduto);
    String getDescricao();
    void setDescricao(String descricao);
    float getQuantidade();
    void setQuantidade(float quantidade);
    float getValor();
    void setValor(float valor);

    void insereLinhaEncomenda (String aux1, String aux2, String aux3, String aux4);
}
