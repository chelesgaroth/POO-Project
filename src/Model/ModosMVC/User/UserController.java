package Model.ModosMVC.User;

import Model.ISistema;
import Model.Leitura.IReadFile;
import Model.Leitura.ReadFile;
import Model.Tipos.ILoja;
import Model.Tipos.Loja;
import View.IAppView;
import View.INavegador;
import View.Navegador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class UserController implements IUserController {
    private ISistema sistema;
    private IAppView view;
    private INavegador nav;
    private IReadFile lerFiles;
    private String file;
    private int opcao;


    public UserController()
    {
        this.file = " ";
        this.nav = new Navegador();
        this.lerFiles = new ReadFile();
        this.opcao = 0;
    }
    public void setSistema(ISistema sistema){
        this.sistema = sistema;
    }

    public void setAppView(IAppView view) {
        this.view = view;
    }
    public void userMode() {
        do {
            //sistema.printaLojas();
            Scanner ler = new Scanner(System.in);
            view.userMode();
            opcao = ler.nextInt();
            switch (opcao) {
                case 1: { //Encomendar algo
                    catalogo(0); //se o catálogo por chamado com 0 então pretendemos visualizar os Produtos
                    break;
                }
                case 2: {

                    break;
                }
                default: break;
            }
        }while (opcao!=0);
        view.printMensagem("Obrigada!Volte Sempre!");
    }

    public void catalogo(int opcao){
        Scanner ler;
        String x = " ";
        int num = 0;
        if(opcao==0)
            nav.divide(sistema.getCatalogoProds(),null,"\nCATALOGO DE PRODUTOS",0);
        if (opcao==1)
            nav.divide(null,sistema.getListaLojas(),"\nCATALOGO DE LOJAS", 1);
        nav.menu();
        do {
            ler = new Scanner(System.in);
            x = ler.nextLine();
            switch (x) {
                case "P": {
                    if(opcao==0)
                        nav.proxima(sistema.getCatalogoProds(), null,"\nCATALOGO DE PRODUTOS",0);
                    if(opcao==1)
                        nav.proxima(null, sistema.getListaLojas(),"\nCATALOGO DE LOJAS",1);
                    nav.menu();
                    break;
                }
                case "A": {
                    if (opcao==0)
                        nav.anterior(sistema.getCatalogoProds(),null, "\nCATALOGO DE PRODUTOS",0);
                    if(opcao==1)
                        nav.anterior(null,sistema.getListaLojas(), "\nCATALOGO DE LOJAS",1);
                    nav.menu();
                    break;
                }
                case "N": {
                    view.printMensagem("Insira o nº da Página:");
                    ler = new Scanner(System.in);
                    num = ler.nextInt();
                    if (opcao==0)
                        nav.escolha(sistema.getCatalogoProds(), null,"\nCATALOGO DE PRODUTOS", 0, num);
                    if(opcao==1)
                        nav.escolha(null, sistema.getListaLojas(),"\nCATALOGO DE LOJAS", 1, num);
                    nav.menu();
                    break;
                }
                case "T": {
                    if (opcao==0)
                        nav.total(sistema.getCatalogoProds(),null,0);
                    if (opcao==1)
                        nav.total(null,sistema.getListaLojas(),1);
                    nav.menu();
                    break;
                }
                case "E":{
                    if(opcao==0) escolheProdLoja(0);
                    if (opcao==1) escolheProdLoja(1);
                    break;
                }
                default: {
                    if (!(x.equals("M"))) view.printMensagem("Por favor insira uma opção válida!");
                    nav.menu();
                    break;
                }
            }
        }while(!(x.equals("M")));
    }


    public List<String> escolheProdLoja(int opcao) {
        List<String> res= new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        if(opcao==0){
            System.out.println("Insira o código do produto");
            String prod = ler.nextLine();
            res.add(prod);
            escolheProdLoja(1);
        }

        if (opcao==1) {
            HashSet<Loja> lojas = sistema.getListaLojas();
            catalogo(1);
            System.out.println("Insira o código da loja");
            ler= new Scanner(System.in);
            String loja =
                    ler.nextLine();
            res.add(loja);
        }
        return res;
    }
}
