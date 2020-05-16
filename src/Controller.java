import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Sistema sistema = new Sistema ();
        int opcao;
        String strFile = " ";
        Menu.Inicio();
        Scanner ler = new Scanner(System.in);
        String aux = ler.nextLine();
        int num =Integer.parseInt(aux);
        if(num==2){
            try {
                System.out.println("Insira um nome para um ficheiro:");
                strFile = ler.nextLine();
                File f = new File(strFile);
                if (f.createNewFile()) {
                    System.out.print("\nNovo estado criado.\nPor favor registe-se.\n");
                } else {
                    System.out.println("Já foram feitos registos.\nFaça login ou registe-se.\n");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Insira o nome do ficheiro:");
            strFile = ler.nextLine();
            Load.leitura(strFile, sistema);
            System.out.println("Estado da aplicação carregado!");
        }
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
                    /* Classe login
                    * 1º) Quando estivermos no register o user escolher uma password.
                    * 2º) Ligamos o userID à password na classe login atraves de um hashMap
                    * 3º) No register chamamos a função que adiciona ao hashMap
                    * 4º) No login , apenas temos de procurar no hashmap a password correspondente ao userID
                    * 5º) Usamos equals e caso seja verdade tem acesso ao resto do programa
                    * 6º) O resto do programa permite usar a aplicacao para fazer encomendas etc, consultar o historico...
                     */
                }
            }
        }
        while (opcao!=0);
    }

}


