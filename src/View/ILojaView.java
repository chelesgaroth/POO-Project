package View;

import Model.Encomendas.IEncomenda;

import java.util.ArrayList;
import java.util.Set;

public interface ILojaView {
    void modeLoja();
    void printMensagem(String s);
    void infos();
    void encomendasFila(Set<IEncomenda> res);
    void tipodeEncomenda(int x);
    void printa (String mensagem);
}
