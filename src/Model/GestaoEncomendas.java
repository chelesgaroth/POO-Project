package Model;

import Model.Catalogos.IProduto;
import Model.Catalogos.Produto;
import Model.Encomendas.Encomenda;
import Model.Encomendas.IEncomenda;
import Model.Encomendas.ILinhaEncomenda;
import Model.Encomendas.LinhaEncomenda;
import Model.Logins.ILogin;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestaoEncomendas implements IGestaoEncomendas {


    public IEncomenda constroiEncomendaParaLoja (String loja , List<IProduto> prods, List<String> quantidades, ILogin user){

        ArrayList<LinhaEncomenda> encomendas = new ArrayList<>();
        IEncomenda encFinal = new Encomenda();
        String userId = (user.getPassword()).substring(0,3);

        int i=0;
        for(IProduto produto : prods){
            LinhaEncomenda linhaEncomenda = new LinhaEncomenda();
            linhaEncomenda.setProduto(produto);
            linhaEncomenda.setQuantidade(Float.parseFloat(quantidades.get(i)));
            linhaEncomenda.setValor((produto.getPreco()* Float.parseFloat(quantidades.get(i))));
            encomendas.add(linhaEncomenda);
        }
        Random random = new Random();
        int numero = random.nextInt(10000);
        String idEnc = "e" + numero;
        encFinal.setEncomendaID(idEnc);
        encFinal.setLojaID(loja);
        encFinal.setUserID(userId);
        encFinal.setProds(encomendas);
        encFinal.setHoraInicial(LocalTime.now());
        System.out.println("Encomenda: "+ encFinal.toString());
        return encFinal;
    }
}
