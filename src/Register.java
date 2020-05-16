import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Register {
    public static void registoUser (String strfile,Sistema sistema) {

        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //UserID ->  gera um userID random para o utilizador
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int);
        id = "u" + id + ",";
        //UserName
        System.out.println("Insira o seu primeiro nome:");
        String nome1 = ler.nextLine();
        System.out.println("Insira o seu último nome:");
        String nome2 = ler.nextLine();
        String linha = id + nome1 + " " + nome2;
        //Coordenadas GPS
        System.out.println("Insira as suas coordenadas de GPS:");
        System.out.println("x:");
        String x = ler.nextLine();
        System.out.println("y:");
        String y = ler.nextLine();

        linha = linha + "," + x + "," + y;
        User user = User.insereUser(linha,sistema);
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
    public static void registoVoluntario (String strfile,Sistema sistema){

        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //VolunteerID ->  gera um userID random para o utilizador
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int);
        id = "v" + id;
        //Nome do voluntario
        System.out.println("Insira o seu primeiro nome:");
        String nome1 = ler.nextLine();
        System.out.println("Insira o seu último nome:");
        String nome2 = ler.nextLine();
        String linha = id + "," + nome1 + " " + nome2;
        //Coordenadas GPS
        System.out.println("Insira as suas coordenadas de GPS:");
        System.out.println("x:");
        String x = ler.nextLine();
        System.out.println("y:");
        String y = ler.nextLine();
        //Raio de ação
        System.out.println("Insira o seu raio de ação:");
        String r = ler.nextLine();
        linha = linha + "," + x + "," + y + "," + r;
        Volunteer vol = Volunteer.insereVolunteer(linha,sistema);
        //Escrever no ficheiro
        try {
            FileWriter file = new FileWriter(strfile,true);
            file.write("\n");
            file.write(vol.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void registoLoja (String strfile,Sistema sistema){
        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //LojaID
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int);
        id = "l" + id + ",";
        //LojaName
        System.out.println("Insira o nome da sua loja:");
        String nome = ler.nextLine();
        String linha = id + nome;
        Loja loja = Loja.insereLoja(linha,sistema);
        //Escrever no ficheiro
        try {
            FileWriter file = new FileWriter(strfile,true);
            file.write("\n");
            file.write(loja.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void registoEmpresa (String strfile,Sistema sistema){
        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //EmpresaID
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int);
        id = "t" + id;
        //Nome da empresa
        System.out.println("Insira o nome da Empresa Transportadora:");
        String nome = ler.nextLine();
        String linha = id + "," + nome;
        //Coordenadas GPS
        System.out.println("Insira as suas coordenadas de GPS:");
        System.out.println("x:");
        String x = ler.nextLine();
        System.out.println("y:");
        String y = ler.nextLine();
        //NIF
        System.out.println("Insira o NIF da empresa:");
        String nif = ler.nextLine();
        //Raio de ação
        System.out.println("Insira o seu raio de ação:");
        String r = ler.nextLine();
        //Preço por Km
        System.out.println("Insira o preço por Km que a empresa cobra:");
        String preco = ler.nextLine();

        linha = linha + "," + x + "," + y + "," + nif + "," + r + "," + preco;
        Empresa emp = Empresa.insereTransportadora(linha,sistema);

        //Escrever no ficheiro
        try {
            FileWriter file = new FileWriter(strfile,true);
            file.write("\n");
            file.write(emp.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}