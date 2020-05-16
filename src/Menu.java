public class Menu {
    public static void  Inicio (){
        System.out.println();
        System.out.println("---------TRAZ AQUI!--------");
        System.out.print("Bem-Vindo!!\n\n");
        System.out.println("Prima:");
        System.out.println("1- Continuar o estado da aplicação");
        System.out.println("2- Criar um novo estado da aplicação");
        //System.out.println("Verificando estado da aplicação...");
    }
    public static void  Menu () {
        System.out.println();
        System.out.println("---------TRAZ AQUI!--------");
        System.out.println("Prima:");
        System.out.println("1- Fazer Registo"); //adiciona ao estado
        System.out.println("2- Fazer Login "); //retoma o estado do aplicativo
        System.out.println("0- Sair do aplicativo");
    }
    public static void  MenuType (){
        System.out.println("---------TRAZ AQUI!--------");
        System.out.println("Fazer registo de:");
        System.out.println("1- Utilizador");
        System.out.println("2- Voluntário");
        System.out.println("3- Loja");
        System.out.println("4- Empresa");
        System.out.println("0- Voltar ao Menu Inicial");
    }
    public static void Historico(int conta1,int conta2,int conta3,int conta4,int conta5,int conta6,int conta7){
        System.out.printf("\nNúmero de Encomendas aceites: %d\n",conta1);
        System.out.printf("Número de Utilizadores: %d\n",conta2);
        System.out.printf("Número de Voluntários: %d\n",conta3);
        System.out.printf("Número de Empresas Transportadoras: %d\n",conta4);
        System.out.printf("Número de Lojas: %d\n",conta5);
        System.out.printf("Número de Encomendas: %d\n",conta6);
        System.out.printf("Número de Logins (Contas feitas): %d\n\n",conta7);

    }
}
