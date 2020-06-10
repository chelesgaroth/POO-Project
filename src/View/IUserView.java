package View;

import Model.Tipos.ITipo;

import java.util.HashSet;

public interface IUserView {
    void userMode();
    void printMensagem(String s);
    void transportes(char opcao, HashSet<ITipo> res);
}
