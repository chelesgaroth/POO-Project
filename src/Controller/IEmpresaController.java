package Controller;

import Model.ISistema;
import Model.Tipos.Empresa;
import View.IEmpresaView;

public interface IEmpresaController {
    void setSistema(ISistema sistema);
    void setView(IEmpresaView view);
    void setEmpresa();
    void mode();
}
