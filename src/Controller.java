import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        int opcao;
        String strFile = "TesteUserFile.txt";
        File file = new File("TesteUserFile.txt");
        Load.leitura(file);
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
                    Register.registo(strFile);
                    break;
                }
            }
        }
        while (opcao!=0);
    }

}


