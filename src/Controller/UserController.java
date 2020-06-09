package Controller;

import Model.Catalogos.IProduto;
import Model.Encomendas.IEncomenda;
import Model.ISistema;
import View.IUserView;
import View.INavegador;
import View.Navegador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserController implements IUserController {
    private ISistema sistema;
    private IUserView view;
    private INavegador nav;
    private int opcao;


    public UserController() {
        this.nav = new Navegador();
        this.opcao = 0;
    }


    public void setSistema(ISistema sistema){
        this.sistema = sistema;
    }
    public void setAppView(IUserView view) {
        this.view = view;
    }


    public int userMode() {
        int res = 0;
        do {
            Scanner ler = new Scanner(System.in);
            view.userMode();
            opcao = ler.nextInt();
            List<IProduto> prods = new ArrayList<>();
            List<String> quantidades = new ArrayList<>();
            switch (opcao) {
                case 1: { //Encomendar algo
                    catalogo(0,prods,quantidades); //se o catálogo por chamado com 0 então pretendemos visualizar os Produtos
                    opcao = 0;
                    res = 1;
                    view.printMensagem("Enviando pedido à loja...\nPor favor aguarde");
                    break;
                }
                case 2: {

                    break;
                }
                default: break;
            }
        }while (opcao!=0);
        view.printMensagem("Obrigada!Volte Sempre!");
        return res;
    }

    public void catalogo(int opcao, List<IProduto> prods, List<String> quantidades){

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
                    if(opcao==0) escolheProdLoja(0,prods,quantidades);
                    if(opcao == 1){
                        String loja = escolheProdLoja(2,prods,quantidades);
                        //Mandar a encomenda para a gestao e depois para a fila de espera
                        IEncomenda enc = sistema.getGestao().constroiEncomendaParaLoja(loja,prods,quantidades, sistema.getQuem());
                        sistema.getFilaEspera().addEncomenda(enc);
                    }
                    x = "M";
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


    public String escolheProdLoja(int opcao, List<IProduto> prods, List<String> quantidades) {
        String loja = " ";
        Scanner ler = new Scanner(System.in);
        if(opcao==0){
            System.out.println("Insira o código do produto"); //ver se o produto existe
            String prod = ler.nextLine();
            while(!sistema.getCatalogoProds().existsProdStr(prod)){
                System.out.println("Produto não existe!! Insira novamente.");
                prod = ler.nextLine();
            }
            IProduto produto = sistema.getCatalogoProds().getProd(prod);
            prods.add(produto);
            System.out.println(prods.toString());
            System.out.println("Cesto de Compras: " + prod);
            System.out.println("Qual a quantidade pretendida");
            ler = new Scanner(System.in);
            String quantidade = ler.nextLine();
            quantidades.add(quantidade);
            System.out.println("Pretende escolher mais produtos? Selecione 1, caso contrário 0");
            ler = new Scanner(System.in);
            String x = ler.nextLine();
            if (x.equals("0")) {
                escolheProdLoja(1,prods,quantidades);
            }
            if(x.equals("1")){
                System.out.println("escolheu 1");
                catalogo(0,prods,quantidades);
            }
            else System.out.println("Opção inválida, tente novamente");

        }

        if (opcao==1) {
            //HashSet<Loja> lojas = sistema.getListaLojas();
            catalogo(1,prods,quantidades);

        }
        if(opcao==2) {
            System.out.println("Insira o código da loja");
            ler = new Scanner(System.in);
            loja = ler.nextLine();
            if (sistema.existLojasCod(loja)) {
                System.out.println("Loja Escolhida : " + loja);
            } else {
                System.out.println("Loja inválida, insira novamente");
                catalogo(1, prods,quantidades);
            }
        }
        return loja;
    }
}
