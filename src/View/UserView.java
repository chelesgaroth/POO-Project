package View;

import Model.Tipos.Empresa;
import Model.Tipos.ITipo;
import Model.Tipos.Voluntario;

import java.util.HashSet;

public class UserView implements IUserView {

    public void userMode(){
        System.out.println("-----------USER MODE----------");
        System.out.println("1- Fazer uma encomenda");
        System.out.println("2- Escolher o transporte");
        System.out.println("3- Classificar transporte");
        System.out.println("4- Encomendas em espera de Transporte");
        System.out.println("5- Histórico");
        System.out.println("0- Voltar ao Menu de Login");
    }

    public void classificacao(){
        System.out.println("-----------CLASSIFICAÇÃO----------");
        System.out.println("1- ★");
        System.out.println("2- ★★");
        System.out.println("3- ★★★");
        System.out.println("4- ★★★★");
        System.out.println("5- ★★★★★");
        System.out.println("0- Voltar ao Menu");
    }

    public void printMensagem(String s){
        System.out.printf("\n%s\n",s);
    }

    public void transportes(char opcao, HashSet<ITipo> res){
        int x = 0x2713;
        if(opcao== ' ') {
            System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
            System.out.println("                   OPÇÕES DE TRANSPORTE");
            System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");

        }
        if(opcao=='V') {
            System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
            System.out.println("VOLUNTÁRIOS       CÓDIGO      RAIO DE AÇÃO           PREÇO  ");
            System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
            for(ITipo tipo : res){
                if(tipo instanceof Voluntario){
                    Voluntario vol = (Voluntario) tipo;
                    System.out.printf("%-15s",vol.getNome());
                    System.out.printf("    %-15s",vol.getId());
                    if(vol.getAvailability()){
                        String check = "✓";
                        System.out.printf("%-15s",check);
                    }
                    else {
                        String no = "x";
                        System.out.printf("%-15s",no);
                    }
                    String preco = "     Grátis";
                    System.out.printf("%-15s",preco);
                    System.out.println();
                }
            }
            System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
            System.out.println("(E) Escolha um meio de transporte");
        }
        else if(opcao =='T'){
            System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
            System.out.println("TRANSPORTADORAS      CÓDIGO     DISPONIBILIDADE        PREÇO");
            System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
            for(ITipo tipo : res){
                if(tipo instanceof Empresa){
                    Empresa emp = (Empresa) tipo;
                    System.out.printf("%-15s",emp.getNome());
                    System.out.printf("%-25s",emp.getId());
                    if(emp.getDisponibilidade()){
                        String check = "✓";
                        System.out.printf("%-15s",check);
                    }
                    else {
                        String no = "x";
                        System.out.printf("%-15s",no);
                    }
                    System.out.printf("%-15s",emp.getPreco());
                    System.out.println();
                }
            }
            System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
            System.out.println("(E) Escolha um meio de transporte");
        }
        else if(opcao == 'M'){
            System.out.println("Obrigada!! Dentro de minutos a encomenda será entregue!\nAté já!");
        }
        //else System.out.println("Opção inválida! Escolha novamente");
        if(opcao != 'E') System.out.println("\n(V) Voluntários       (M) Menu           (T) Transportadoras");
    }
}
