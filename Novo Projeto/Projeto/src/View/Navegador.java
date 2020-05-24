package View;

import Model.Catalogos.ICatalogoProds;
import Model.Encomendas.ILinhaEncomenda;

import java.util.ArrayList;
import java.util.Iterator;
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

    public void divide(ICatalogoProds cat, String mensagem){

        System.out.flush(); //limpa ecra
        int i;
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
        }
    }

    public void proxima(ICatalogoProds cat, String mensagem){
        this.pagina += 1;
        this.inseridos += 2;
        divide(cat,mensagem);
    }

    public void anterior(ICatalogoProds cat, String mensagem){
        this.pagina -= 1;
        this.inseridos -= 2;
        if((this.pagina >= 0) && (this.inseridos >=0)){
            divide(cat,mensagem);
        }
        else {
            System.out.print("\nPágina Inválida\n\n");
        }
    }

    public void total(ICatalogoProds cat){
        System.out.print("Total: " + cat.totalProds() + "\n\n");
    }

    public void escolha(ICatalogoProds cat, String mensagem, int num){
        this.pagina = num;
        this.inseridos = num*2;
        divide(cat,mensagem);
    }

    public void menu (){
        System.out.println("Próxima Página(P)        Menu(M)        Página Anterior(A)");
        System.out.println("Escolha o nº da Página(N)               Total(T)      ");
    }
}
