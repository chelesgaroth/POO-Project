package Controller;

import Model.Encomendas.IEncomenda;
import Model.ISistema;
import Model.Tipos.ITipo;
import View.ILojaView;
import View.LojaView;

import java.util.*;


public class LojaController implements ILojaController {
    private ISistema sistema;
    private ILojaView view;
    private int opcao;

    public LojaController(){
        this.opcao = 0;
        this.view = new LojaView();
    }

    public void setSistema(ISistema sistema){ this.sistema = sistema; }

    public void setView(ILojaView view){ this.view= view; }

    public void lojaMode() {
        view.infos();
        Scanner ler = new Scanner(System.in);
        String tempo = ler.nextLine();
        String id = sistema.getQuem().getPassword().substring(0,3);
        ITipo loja = sistema.getLojaLista(id);
        do {
            ler = new Scanner(System.in);
            view.modeLoja();
            opcao = ler.nextInt();
            switch (opcao) {
                case 1: { // Encomendas em fila de espera
                    Set<IEncomenda> set = sistema.getFilaEspera().getEncomendas(id);
                    if(set==null) view.printMensagem("Não há encomendas na fila de espera!");
                    else{
                        view.encomendasFila(set);
                    }
                    break;
                }
                case 2: { //Validar a encomenda
                    view.printMensagem("Validar a Encomenda: ");
                    ler = new Scanner(System.in);
                    String encId = ler.nextLine();
                    while(!sistema.getFilaEspera().containsEncTipo(encId,id)){
                        view.printMensagem("Encomenda inválida. Insira novamente!");
                        ler = new Scanner(System.in);
                        encId = ler.nextLine();
                    }
                    IEncomenda encomenda = sistema.getFilaEspera().getEncomendaTipo(encId,id);
                    view.tipodeEncomenda(3);
                    ler = new Scanner(System.in);
                    String peso = ler.nextLine();
                    encomenda.setPesoTotal(Double.parseDouble(peso));
                    view.tipodeEncomenda(1);
                    ler = new Scanner(System.in);
                    int opcao = ler.nextInt();
                    if(opcao==1) encomenda.setMedicamentos(true);
                    else encomenda.setMedicamentos(false);

                    view.tipodeEncomenda(2);
                    ler = new Scanner(System.in);
                    opcao = ler.nextInt();
                    if(opcao==1) encomenda.setCongelados(true);
                    else encomenda.setCongelados(false);

                    sistema.getFilaEspera().removeEncomenda(encomenda);
                    sistema.getFilaEncomendas().addEncomenda(encomenda);
                    break;
                }

                case 3: { //Ver o histórico de vendas realizadas

                    break;
                }
                case 4: {
                    break;
                }

                case 5 : {

                    }

                default:
                    break;
            }
        }while (opcao != 0) ;
        view.printMensagem("Obrigada!Volte Sempre!");
    }



}
