package Controller;

import Model.Encomendas.Entrega;
import Model.Encomendas.IEntrega;
import Model.ISistema;
import Model.Tipos.Empresa;
import View.IEmpresaView;


public class EmpresaController implements IEmpresaController {
    private ISistema sistema;
    private IEmpresaView view;
    private Empresa empresa;
    private IEntrega entregaFinal;
    private int opcao;

    public EmpresaController(){
        this.empresa = new Empresa();
        this.entregaFinal = new Entrega();
        this.opcao = 0;
    }

    public void setSistema(ISistema sistema){
        this.sistema = sistema;
    }
    public void setView(IEmpresaView view) { this.view = view; }
}
