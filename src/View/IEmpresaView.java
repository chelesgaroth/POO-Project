package View;

import Model.Encomendas.IEntrega;

import java.util.Set;

public interface IEmpresaView {
    void prepara(int x);
    void menu();
    void encomendasFila(Set<IEntrega> res);

    void printMensagem(String s);
}
