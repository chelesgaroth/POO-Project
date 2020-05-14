import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {
    public static void registo (String strfile) {
        User user = new User();

        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");
        //1ºCampo
        System.out.println("Insira o seu primeiro nome:");
        String nome1 = ler.nextLine();
        user.setFirst_name(nome1);
        //2ºCampo
        System.out.println("Insira o seu último nome:");
        String nome2 = ler.nextLine();
        user.setLast_name(nome2);

        //Escrever no ficheiro
        try {
            FileWriter file = new FileWriter(strfile,true);
            file.write("\nUtilizador:" + nome1 + " " + nome2); //temos de usar o ToString
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}