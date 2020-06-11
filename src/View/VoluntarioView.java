package View;


import Model.Encomendas.IEncomenda;
import Model.Encomendas.IEntrega;

import java.util.Set;

public class VoluntarioView implements IVoluntarioView {

    public void mode(){
        System.out.println("-----------VOLUNTÁRIO MODE----------");
        System.out.println("1- Encomendas à espera da validação");
        System.out.println("2- Entregar Encomenda ao Utilizador");
        System.out.println("3- Histórico de entregas");
        System.out.println("4- Classificações recebidas pelos Users");
        System.out.println("0- Voltar ao Menu de Login");
    }

    public void encomendasFila(Set<IEntrega> res){
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("                ENCOMENDAS PARA TRANSPORTE");
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("Código da Encomenda  Medicamento   Congelados   Hora Inicial");
        for(IEntrega enco : res){
            System.out.printf("%-20s",enco.getEncomenda().getEncomendaID());
            System.out.printf("%-20s",enco.getEncomenda().getMedicamentos());
            System.out.printf("%-20s",enco.getEncomenda().getCongelados());
            System.out.print(enco.getEncomenda().getHoraInicial());
            System.out.println();
        }
    }

    public void prepara(){
        System.out.println("Aceita transportar medicamentos?");
        System.out.println("(Y) Yes                  (N) No ");
    }

    public void printMensagem(String s){
        System.out.printf("\n%s\n",s);
    }

    public void listagem(IEntrega[] res){
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("                   HISTÓRICO DE ENTREGAS");
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("Código     Distância Percorrida       Data           Hora   ");
        for(int i=0; res[i]!=null; i++){
            System.out.printf("%-20s",res[i].getEncomenda().getEncomendaID());
            System.out.printf("%-20s",res[i].getDistPercorrida());
            System.out.printf("%-20s",res[i].getDataEntrega());
            System.out.print(res[i].getHoraEntrega());
            System.out.println();
        }
    }
}
