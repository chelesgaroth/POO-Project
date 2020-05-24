package Controller;

import Model.*;
import Model.Leitura.IReadFile;
import Model.Leitura.ReadFile;
import Model.Logins.ILogin;
import Model.Logins.Login;
import View.*;

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
            Scanner ler = new Scanner(System.in);
            view.userMode();
            opcao = ler.nextInt();
            switch (opcao) {
                case 1: { //Encomendar algo
                    catalogoStock();
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
        nav.divide(sistema.getCatalogoProds(),"\nCATALOGO DE PRODUTOS");
        do {
            nav.menu();
            ler = new Scanner(System.in);
            x = ler.nextLine();
            switch (x) {
                case "P":
                    nav.proxima(sistema.getCatalogoProds(),"\nCATALOGO DE PRODUTOS");
                    break;
                case "A":
                    nav.anterior(sistema.getCatalogoProds(),"\nCATALOGO DE PRODUTOS");
                    break;
                case "N":
                    view.printMensagem("Insira o nº da Página:");
                    ler = new Scanner(System.in);
                    num = ler.nextInt();
                    nav.escolha(sistema.getCatalogoProds(),"\nCATALOGO DE PRODUTOS", num);
                    break;
                case "T":
                    nav.total(sistema.getCatalogoProds());
                    break;
                default:
                    if(!(x.equals("M"))) view.printMensagem("Por favor insira uma opção válida!");
                    break;
            }
        }while(!(x.equals("M")));
    }

}
