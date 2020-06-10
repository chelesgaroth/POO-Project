package Model;

import Model.Catalogos.ICatalogoTipo;
import Model.Catalogos.IProduto;
import Model.Encomendas.IEncomenda;
import Model.Logins.ILogin;
import Model.Tipos.ITipo;
import Model.Tipos.Loja;

import java.util.HashSet;
import java.util.List;

public interface IGestaoEncomendas {
    IEncomenda constroiEncomendaParaLoja (String loja , List<IProduto> prods, List<String> quantidades, ILogin user);
    HashSet<ITipo> verificarTransporte(ICatalogoTipo voluntarios, ICatalogoTipo empresas, IEncomenda encomenda, Loja loja);
}
