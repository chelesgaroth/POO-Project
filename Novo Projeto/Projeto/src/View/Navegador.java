package View;

import Model.Catalogos.ICatalogoProds;
import Model.Encomendas.ILinhaEncomenda;
import Model.Tipos.ILoja;
import Model.Tipos.Loja;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Navegador implements INavegador {
    private int tamPag; //nº de strings por pagina ou seja tamanho da pagina
    private int nTPag; //nº total de páginas
    private int pagina; // nº da página atual
    private int inseridos; //nº de strings já inseridas

    public Navegador(){
        this.tamPag = 2;
        this.nTPag = 0;
        this.pagina = 1;
        this.inseridos = 0;
    }

    public void divide(ICatalogoProds cat, HashSet<ILoja> lojas, String mensagem,int opcao) {
        List<ILoja> aList = new ArrayList<>();
        if (opcao == 1) {
            for (ILoja x : lojas){
                System.out.print(x.toString());
               aList.add(x);
            }
        }
        System.out.flush(); //limpa ecra

        int i;
        if(opcao==0) {
            this.nTPag = cat.totalProds() / 2;
        if((this.pagina <= this.nTPag) && (this.inseridos <= cat.totalProds())){
            System.out.println(mensagem);
            for(i = this.inseridos; (i< (this.tamPag + this.inseridos)) && (i <cat.totalProds()); i++ ){
                System.out.print("\n********Produto*********\n");
                System.out.print(cat.getCatProds().get(i).toString());
                if(i==(this.inseridos+1)) break;
            }
            //this.inseridos+=20;
            if(i>=cat.totalProds()) System.out.println("Fim dos resultados.");
            System.out.printf("\nPágina <%d/%d> \n\n",this.pagina ,this.nTPag);
            //this.pagina++;
        } }
        if (opcao==1){
            if((this.pagina <= this.nTPag) && (this.inseridos <= lojas.size())){
                System.out.println(mensagem);
                for(i = this.inseridos; (i< (this.tamPag + this.inseridos)) && (i <lojas.size()); i++ ){
                    System.out.print("\n********LOJA*********\n");
                    System.out.println(aList.get(i).toString());
                    if(i==(this.inseridos+1)) break;
                }
                //this.inseridos+=20;
                if(i>=aList.size()) System.out.println("Fim dos resultados.");
                System.out.printf("\nPágina <%d/%d> \n\n",this.pagina ,this.nTPag);

        }
    }}

    public void proxima(ICatalogoProds cat, HashSet<ILoja> lojas, String mensagem, int opcao){
        this.pagina += 1;
        this.inseridos += 2;
        divide(cat,lojas,mensagem,opcao);
    }

    public void anterior(ICatalogoProds cat, HashSet<ILoja> lojas, String mensagem, int opcao){
        this.pagina -= 1;
        this.inseridos -= 2;
        if((this.pagina >= 0) && (this.inseridos >=0)){
            divide(cat,lojas,mensagem,opcao);
        }
        else {
            System.out.print("\nPágina Inválida\n\n");
        }
    }

    public void total(ICatalogoProds cat,HashSet<ILoja> lojas, int opcao){
       if (opcao==0)  System.out.print("Total: " + cat.totalProds() + "\n\n");
       if (opcao==1) System.out.print("Total: "+ lojas.size()+ "\n\n");
    }

    public void escolha(ICatalogoProds cat, HashSet<ILoja> lojas, String mensagem, int opcao,int num){
        this.pagina = num;
        this.inseridos = num*2;
        divide(cat,lojas,mensagem,opcao);
    }

    public void menu (){
        System.out.println("Próxima Página(P)             Menu(M)                     Página Anterior(A)");
        System.out.println("Escolha o nº da Página(N)     Efetuar Encomenda (E)           Total(T)      ");
    }
}
