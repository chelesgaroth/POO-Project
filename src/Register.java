import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Register {
    public static void registoUser (String strfile) {
        User user = new User();

        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //UserID ->  gera um userID random para o utilizador
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int);
        user.setUserID("u" + id);
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
            file.write("\n");
            file.write(user.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}