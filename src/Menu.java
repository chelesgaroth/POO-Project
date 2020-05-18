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
    public static void Historico(int conta1,int conta2,int conta3,int conta4,int conta5,int conta6,int conta7, int conta8){
        System.out.printf("\nNúmero de Encomendas aceites: %d\n",conta1);
        System.out.printf("Número de Utilizadores: %d\n",conta2);
        System.out.printf("Número de Voluntários: %d\n",conta3);
        System.out.printf("Número de Empresas Transportadoras: %d\n",conta4);
        System.out.printf("Número de Lojas: %d\n",conta5);
        System.out.printf("Número de Encomendas: %d\n",conta6);
        System.out.printf("Número de Logins (Contas feitas): %d\n",conta7);
        System.out.printf("Número de Produtos: %d\n\n",conta8);
    }
    public static void MenuLogin(int x){
        if (x==1) {
            System.out.println("-------------LOGIN--------------");
            System.out.println("Por favor insira o seu ID:");
        }
        if(x==2)System.out.println("Por favor insira a sua password");
    }
    public static void AppUser(){
        System.out.print("Mode: user ----------\n\n");
        System.out.println("1- Efetuar Encomenda");
        System.out.println("AINDA EM CONSTRUÇÃO......");
    }

    public static void tipoEncomenda(){
        System.out.println("De que precisa?");
        System.out.println("1- Itens de supermecado");
        System.out.println("2- Comida de restaurante");
        System.out.println("3- Roupa ou bijuteria");
        System.out.println("4- Medicação ");
    }

    public static void tipoLoja(){
        System.out.println();
        System.out.println("Que tipo da loja?");
        System.out.println("1- Supermecado");
        System.out.println("2- Restaurante");
        System.out.println("3- Loja de roupa");
        System.out.println("4- Farmácia");
    }

    public static void prod (int x){
        if (x==0){
        System.out.println();
        System.out.println("Tem stock a registar?");
        System.out.println("1- Sim");
        System.out.println("2- Nao");
    }
        if (x==1){
            System.out.println("Por favor, introduza o nome do artigo");

        }
        if (x==2) {
            System.out.println("Por favor, introduza a quantidade");
        }

        if (x==3) {
            System.out.println("Digte S para continuar ou ENTER para terminar");
        }
    }
}
