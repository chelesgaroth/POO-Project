package Model.ModosMVC.Loja;

import Model.ISistema;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LojaController implements ILojaController {
    private ISistema sistema;
    private ILojaView view;
    private IAppLoja model;
    private int opcao;

    public LojaController(){
        this.opcao = 0;
        this.view = new LojaView();
        this.model = new AppLoja();
    }

    public void setSistema(ISistema sistema){ this.sistema = sistema; }

    public void setView(ILojaView view){ this.view= view; }

    public void setModel(IAppLoja model) { this.model = model; }

    public void lojaMode() {
        do {
            Scanner ler = new Scanner(System.in);
            view.modeLoja();
            opcao = ler.nextInt();
            switch (opcao) {
                case 1: { //Validar a encomenda
                    /*
                    PEDIR INPUTS PARA TER INFOS PARA CRIAR UMA ENCOMENDA
                    DEPOIS DISSO FAZER SET DA ENCOMENDA COM ESSAS INFORMAÇÕES
                    ADICIONAR A ENCOMENDA AO SISTEMA À LISTA ENCS
                     */
                    break;
                }
                case 2: { //Indicar que a encomenda está pronta
                    System.out.println(LocalTime.now());
                    break;
                }
                case 3: { // Encomendas em fila de espera

                    break;
                }
                case 4: { //Ver o histórico de vendas realizadas
                    break;
                }
                default:
                    break;
            }
        }while (opcao != 0) ;
        view.printMensagem("Obrigada!Volte Sempre!");
    }
}
