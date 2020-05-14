import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        int opcao;
        String strFile = "Logs.txt";
        Load.leitura(strFile);
        do {
            Scanner ler = new Scanner(System.in);
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
                    if(opcao==1) Register.registoUser(strFile);
                    //if(opcao==0)
                    //if(opcao==2) registoVoluntario..
                    break;
                }
            }
        }
        while (opcao!=0);
    }

}


