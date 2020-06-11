package Controller;

import Model.Encomendas.Entrega;
import Model.Encomendas.IEntrega;
import Model.ISistema;
import Model.Tipos.Empresa;
import Model.Tipos.User;
import View.IEmpresaView;

import java.util.Scanner;
import java.util.Set;


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
    public void setEmpresa() {
        String id = sistema.getLogins().getCodigoID(sistema.getQuem().getEmail());
        this.empresa = (Empresa) sistema.getEmpresas().getTipo(id);
    }

    public void mode(){
        setEmpresa();
        Scanner ler = new Scanner(System.in);
        view.prepara(0);
        if(ler.nextLine().equals("Y")) empresa.setAceitaMedicamento(true);
        view.prepara(1);
        ler = new Scanner(System.in);
        if(ler.nextLine().equals("Y")) empresa.setChuva(true);
        view.prepara(2);
        ler = new Scanner(System.in);
        String n = ler.nextLine();
        empresa.setNEncs(Integer.parseInt(n));
        view.prepara(3);
        ler = new Scanner(System.in);
        String taxa = ler.nextLine();
        empresa.setTaxaAdicional(Double.parseDouble(taxa));
        do{
            view.menu();
            ler = new Scanner(System.in);
            opcao = ler.nextInt();
            switch (opcao){
                case 1:{ //Encomendas por entregar
                    Set<IEntrega> res = sistema.getFilaEntregues().getEntregasFalse(empresa.getId());
                    if(res!=null)view.encomendasFila(res);
                    else view.printMensagem("Não há Encomendas por entregar");
                    break;
                }
            }
        }while (opcao!=0);
    }
}
