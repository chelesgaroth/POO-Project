package Model.ModosMVC.Loja;

import Model.Encomendas.IEncomenda;

import java.util.ArrayList;

public interface ILojaView {
    void modeLoja();
    void printMensagem(String s);
    void infos();
    void encomendasFila(ArrayList<IEncomenda> res);
}
