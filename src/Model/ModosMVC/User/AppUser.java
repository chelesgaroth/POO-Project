package Model.ModosMVC.User;

import Model.Catalogos.CatalogoProds;
import Model.Catalogos.ICatalogoProds;
import Model.Catalogos.IProduto;
import Model.Catalogos.Produto;
import Model.Encomendas.ILinhaEncomenda;
import Model.Encomendas.LinhaEncomenda;
import Model.Logins.ILogin;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

public class AppUser implements IAppUser {
    ICatalogoProds prods;

    public AppUser() {
        this.prods = prods;
    }

    public ICatalogoProds getProds() {
        return this.prods;
    }

    public void setProds(ICatalogoProds prods) {
        this.prods = prods;
    }

    public void constroiLinhaEncomenda (List<String> res, ILogin user){
        ILinhaEncomenda linhaEncomenda = new LinhaEncomenda();
        List<ILinhaEncomenda> encomendas = new ArrayList<>();
        IProduto prod = new Produto();
        int i=0;
        int x=0;
        //res : idProd / Quantidade / idProd / Quantidade ..... idLoja
        for (String string:res) {
            //primeiro verifica-se é o ultimo elemento da list, pois este é a loja
            int j=i+1;

            if (j==res.size()){
                //ir buscar loja
                System.out.println(" loja "+string);
            }

           if(j!=res.size()){
               //caso não seja o ultimo elemento, verifica-se se é o código ou a quantidade

            if((i%2)==0) {
                //vai buscar o produto do id
                prod = prods.getProd(string);
                if (prod==null) {
                    System.out.println("Lamentamos mas o produto que inseriu não está disponível");
                } else {
                    linhaEncomenda.setProduto(prod);
                    System.out.println(prod.toString());
                    x++;
                }
            }
            if(((i%2)!=0)&& prod!=null){
                //é a quantidade do produto anterior
                System.out.println("Quantidade "+string);
                float quantidade = Float.parseFloat(string);
                linhaEncomenda.setQuantidade(quantidade);
                linhaEncomenda.setValor(prod.getPreco()*quantidade);
                x++;
            }
         }
           if (x==2) { //significa que já li o produto e a quantidade
               encomendas.add(linhaEncomenda);
               System.out.println("Encomenda");
               System.out.println(linhaEncomenda.toString());
               x=0;
           }

            i++;
        }
        System.out.println("User "+ user);
    }
}
