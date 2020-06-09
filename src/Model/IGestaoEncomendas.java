package Model;

import Model.Catalogos.IProduto;
import Model.Encomendas.IEncomenda;
import Model.Logins.ILogin;

import java.util.List;

public interface IGestaoEncomendas {
    IEncomenda constroiEncomendaParaLoja (String loja , List<IProduto> prods, List<String> quantidades, ILogin user);
}
