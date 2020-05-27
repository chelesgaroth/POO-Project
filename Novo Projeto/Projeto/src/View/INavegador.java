package View;

import Model.Catalogos.ICatalogoProds;
import Model.Tipos.ILoja;
import Model.Tipos.Loja;

import java.util.HashSet;

public interface INavegador {
    void divide(ICatalogoProds cat, HashSet<ILoja> lojas, String mensagem, int opcao);
    void proxima(ICatalogoProds cat, HashSet<ILoja> lojas, String mensagem, int opcao);
    void anterior(ICatalogoProds cat, HashSet<ILoja> lojas, String mensagem, int opcao);
    void total(ICatalogoProds cat,HashSet<ILoja> lojas, int opcao);
    void escolha(ICatalogoProds cat, HashSet<ILoja> lojas, String mensagem, int opcao, int num);
    void menu ();
}
