package View;

import Model.Encomendas.IEncomenda;


import java.util.Set;

public class LojaView implements ILojaView {

    public void modeLoja(){
        System.out.println("-----------LOJA MODE----------");
        System.out.println("1- Encomendas em fila de espera");
        System.out.println("2- Validar uma encomenda");
        System.out.println("3- Ver o histórico de vendas realizadas");
        System.out.println("0- Voltar ao Menu de Login");
    }

    public void printMensagem(String s){
        System.out.printf("\n%s\n",s);
    }

    public void infos(){
        System.out.println("-----------LOJA MODE----------");
        System.out.println("Quanto tempo demora, em média, em minutos, a atender uma pessoa?");
    }

    public void encomendasFila(Set<IEncomenda> res){
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("                ENCOMENDAS NA FILA DE ESPERA");
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("Utilizador                               Código da Encomenda");
        for(IEncomenda enco : res){
            System.out.printf("%-38s",enco.getUserID());
            System.out.print(enco.getEncomendaID());
            System.out.println();
        }
    }
    public void tipodeEncomenda(int x) {
        if (x==1) {
            System.out.println("Algum destes produtos é medicamento?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
        }
        if(x==2) {
            System.out.println("Algum destes produtos é congelado?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
        }
        if(x==3){
            System.out.println("Insira o peso da encomenda: ");
        }
    }
    public void printa (String mensagem){
        System.out.println(mensagem);
    }
}
