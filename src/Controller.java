import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        int opcao,num;
        String strFile = " ";
        Scanner ler = new Scanner(System.in);
        do {
            Menu.Inicio();
            String aux = ler.nextLine();
            num = Integer.parseInt(aux);
            switch (num) {
                case 1: {
                    try {
                        System.out.println("Insira o nome do ficheiro:");
                        strFile = ler.nextLine();
                        File f = new File(strFile);
                        if (!(f.createNewFile())) {
                            Load.leitura(strFile, sistema);
                            //System.out.println(sistema.toString());
                            System.out.println("Estado da aplicação carregado!");
                            num = 0;
                        } else {
                            System.out.print("Ficheiro inexistente.\n");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.println("Insira um nome para um ficheiro:");
                        strFile = ler.nextLine();
                        File f = new File(strFile);
                        if (f.createNewFile()) {
                            System.out.print("\nNovo estado criado.\nPor favor registe-se.\n");
                            num = 0;
                        } else System.out.println("Já foram feitos registos com este ficheiro.\n");

                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }

                }
            }
        }
        while (num != 0) ;
        String id = " ";
        do {
            //clearConsole();
            Menu.Menu();
            String buf = ler.nextLine();
            opcao =Integer.parseInt(buf);
            switch (opcao) {
                case 0: {
                    System.out.println("Obrigada! Até à próxima!");
                    break;
                }
                case 1: {
                    Menu.MenuType();
                    buf = ler.nextLine();
                    opcao =Integer.parseInt(buf);
                    if(opcao==1) Register.registoUser(strFile,sistema);
                    if(opcao==2) Register.registoVoluntario(strFile,sistema);
                    if(opcao==3) Register.registoLoja(strFile,sistema);
                    if(opcao==4) Register.registoEmpresa(strFile,sistema);
                    break;
                }
                case 2:{
                    Menu.MenuLogin(1);
                    id = ler.nextLine();
                    Menu.MenuLogin(2);
                    String pass = ler.nextLine();
                    Login login = new Login();
                    login.setUserID(id);
                    login.setPassword(pass);
                    while(!sistema.existsLogin(login)){
                        System.out.println("Password incorreta!! Ou ID inexistente.");
                        System.out.println("Por favor insira novamente.");
                        pass = ler.nextLine();
                        login.setPassword(pass);
                    }
                    if(sistema.existsLogin(login)){
                        System.out.printf("\nBEM-VINDO %s!! LOGIN BEM SUCEDIDO!!\n", sistema.getNomeUser(id));
                        opcao = 0; //para sair do ciclo
                    }
                }
            }
        }
        while (opcao!=0);
        if(id.charAt(0)=='u') AppUser.menu();
        /* PSEUDO CODIGO - Estas funçoes podem estar numa nova classe
        if ( id[1] == "u") funcao que tem o menu com as opcoes que o user pode tomar
        if ( id[1] == "l") funcao que tem o menu com as opcoes que uma loja pode tomar
        if ( id[1] == "e") funcao que tem o menu com as opcoes que uma empresa pode tomar
        if ( id[1] == "v") funcao que tem o menu com as opcoes que um voluntario pode tomar
        */
    }

}


