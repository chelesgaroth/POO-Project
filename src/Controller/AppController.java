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
        char mode = '0';
        do {
            view.inicio();
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
                    sistema.setQuem(login);
                    view.printMensagem("Login concluído!!\n");
                    //System.out.println("Login : " + login.toString());
                    opcao = 0;
                    break;
                }
            }
        } while(opcao!=0);
        //view.printMensagem("Adeus!!");
        return mode;
    }
}
