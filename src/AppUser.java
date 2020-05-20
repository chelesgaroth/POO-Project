import java.util.Scanner;

public class AppUser {
    public static void menu(Sistema s){
        Menu.AppUser();
        Scanner ler =  new Scanner(System.in);
        int opcao = Integer.parseInt(ler.nextLine());
        if (opcao==1){
            //Aparece o tipo de lojas que tem
            Menu.tipoEncomenda();
            //Dps de escolher o tipo de loja aparece as lojas registadas desse tipo
            int tipo = Integer.parseInt(ler.nextLine());
            System.out.println("Tipo "+ tipo);
            if (tipo==1) {
                Sistema.printaSupermecados(s);
            }

            if (tipo==2) {
                Sistema.printaRestaurantes(s);
            }

            if(tipo==3) {
                Sistema.printaRoupas(s);
            }

            if(tipo==4){
                Sistema.printaFarmacias(s);
            }
            /** Ler a opção que ele introduz
             * Preencher a estrutura com o produto que ele escolheu
             *  */



        }
    }
}
