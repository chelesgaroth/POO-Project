package Controller;

import Model.*;
import Model.Leitura.IReadFile;
import Model.Leitura.ReadFile;
import View.*;

import java.util.Scanner;

public class AppController implements IAppController {
    private ISistema sistema;
    private IAppView view;
    private IReadFile lerFiles;
    private String file;
    private int opcao;

    public AppController(){
        this.file = " ";
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
        do {
            ler = new Scanner(System.in);
            view.inicio();
            //view.mode();
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:{ //registo
                }
                case 2:{ //login
                }
            }
        } while(opcao!=0);
    }
}
