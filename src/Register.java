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
        //3ºCampo e 4ºCampo
        System.out.println("Insira as suas coordenadas de GPS:");
        System.out.println("x:");
        String x = ler.nextLine();
        System.out.println("y:");
        String y = ler.nextLine();
        float xs = Float.parseFloat(x);
        float ys = Float.parseFloat(y);
        user.setX_user(xs);
        user.setY_user(ys);
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
    public static void registoVoluntario (String strfile){
        Volunteer vol = new Volunteer();

        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //VolunteerID ->  gera um userID random para o utilizador
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int);
        vol.setId_volunteer("u" + id);
        //1ºCampo nome do voluntario
        System.out.println("Insira o seu primeiro nome:");
        String nome1 = ler.nextLine();
        //vol.setFirst_name(nome1);
    }
}