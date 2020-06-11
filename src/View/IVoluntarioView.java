package View;

import Model.Encomendas.IEntrega;

import java.util.Set;

public interface IVoluntarioView {
    void mode();
    void encomendasFila(Set<IEntrega> res);
    void printMensagem(String s);
    void prepara();
    void listagem(IEntrega[] res);
}
