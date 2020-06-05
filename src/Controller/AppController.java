package Controller;

import Model.*;
import Model.Leitura.IReadFile;
import Model.Leitura.ReadFile;
import Model.Logins.ILogin;
import Model.Logins.Login;
import Model.Tipos.ILoja;
import Model.Tipos.Loja;
import View.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AppController implements IAppController {
    private ISistema sistema;
    private IAppView view;
    private INavegador nav;
    private IReadFile lerFiles;
    private String file;
    private int opcao;


    public AppController(){
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

    public void runController() {
        Scanner ler = new Scanner(System.in);
        view.printMensagem("Insira um ficheiro de leitura: ");
        file = ler.nextLine();
        lerFiles.leitura(file,sistema);
    }

    /*Esta função faz login ou regista na aplicação.
     * Faz return do char correspondente ao modo.
     * Caso seja 'l' -> Loja;
     * Caso seja 'u' -> user;
     * Caso seja 't' -> empresa;
     * Caso seja 'v' -> voluntário.
     */
    public char signUp (){
        Scanner ler = new Scanner(System.in);
        String email,pass;
        char mode = ' ';
        do {
            view.inicio();
            //view.mode();
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:{ //registo
                }
                case 2:{ //login
                    view.login(0);
                    email = ler.nextLine(); //ver o que se passa aqui
                    view.login(1);
                    email = ler.nextLine();
                    view.login(2);
                    pass = ler.nextLine();
                    ILogin login = new Login();
                    login.setEmail(email);
                    login.setPassword(pass);
                    while(!sistema.existsLogin(login)){
                        view.login(3);
                        view.login(1);
                        email = ler.nextLine();
                        view.login(2);
                        pass = ler.nextLine();
                        login.setEmail(email);
                        login.setPassword(pass);
                    }
                    mode = email.charAt(0);
                    view.printMensagem("Login concluído!!\n");
                    opcao = 0;
                    break;
                }
            }
        } while(opcao!=0);
        return mode;
    }


    public void userMode() {
        do {
            //sistema.printaLojas();
            Scanner ler = new Scanner(System.in);
            view.userMode();
            opcao = ler.nextInt();
            switch (opcao) {
                case 1: { //Encomendar algo
                    //catalogoStock();
                    break;
                }
                case 2: break;
                default: break;
            }
        }while (opcao!=0);
        view.printMensagem("Obrigada!Volte Sempre!");
    }

    public void catalogoStock(){
        Scanner ler;
        String x = " ";
        int num = 0;
        nav.divide(sistema.getCatalogoProds(),null,"\nCATALOGO DE PRODUTOS",0);
        nav.menu();
        do {
            ler = new Scanner(System.in);
            x = ler.nextLine();
            switch (x) {
                case "P": {
                    nav.proxima(sistema.getCatalogoProds(), null,"\nCATALOGO DE PRODUTOS",0);
                    nav.menu();
                    break;
                }
                case "A": {
                    nav.anterior(sistema.getCatalogoProds(),null, "\nCATALOGO DE PRODUTOS",0);
                    nav.menu();
                    break;
                }
                case "N": {
                    view.printMensagem("Insira o nº da Página:");
                    ler = new Scanner(System.in);
                    num = ler.nextInt();
                    nav.escolha(sistema.getCatalogoProds(), null,"\nCATALOGO DE PRODUTOS", 0, num);
                    nav.menu();
                    break;
                }
                case "T": {
                    nav.total(sistema.getCatalogoProds(),null,0);
                    nav.menu();
                    break;
                }
                case "E":{
                    //escolheProdLoja(0);

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

    /*
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
            System.out.println(sistema.getListaLojas().size());
            System.out.println(sistema.getListaVol());
            HashSet<Loja> lojas = sistema.getListaLojas();
            catalogoLoja(lojas);
            System.out.println("Insira o código da loja");
            ler= new Scanner(System.in);
            String loja = ler.nextLine();
            res.add(loja);
        }
        return res;
    }

    public void catalogoLoja(HashSet<ILoja> lojas){
        Scanner ler = new Scanner(System.in);
        String x = " ";
        int num = 0;
        nav.divide(null,lojas,"\nCATALOGO DE LOJAS", 1);
        nav.menu();
        do {

            ler = new Scanner(System.in);
            x = ler.nextLine();
            switch (x) {
                case "P": {
                    nav.proxima(sistema.getCatalogoProds(), null,"\nCATALOGO DE PRODUTOS",0);
                    nav.menu();
                    break;
                }
                case "A": {
                    nav.anterior(sistema.getCatalogoProds(),null, "\nCATALOGO DE PRODUTOS",0);
                    nav.menu();
                    break;
                }
                case "N": {
                    view.printMensagem("Insira o nº da Página:");
                    ler = new Scanner(System.in);
                    num = ler.nextInt();
                    nav.escolha(sistema.getCatalogoProds(), null,"\nCATALOGO DE PRODUTOS", 0, num);
                    nav.menu();
                    break;
                }
                case "T": {
                    nav.total(null,sistema.getListaLojas(),1);
                    nav.menu();
                    break;
                }
                case "E":{
                    escolheProdLoja(1);
                    break;
                }
                default: {
                    if (!(x.equals("M"))) view.printMensagem("Por favor insira uma opção válida!");
                    nav.menu();
                    break;
                }
            }
        }while(!(x.equals("M")));
    }*/

}
