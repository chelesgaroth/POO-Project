package Model;

import Model.Encomendas.IEntrega;

import java.util.Set;

public interface IFilaEntregues {
    void addEncomenda(IEntrega e);
    int removeEncomenda(IEntrega e);
    Set<IEntrega> getEntregas(String codId);
    Set<IEntrega> getEntregasFalse(String codId);
    Set<IEntrega> getEntregasTrue(String codId);
    Set<IEntrega> getMedicamentos(String codId);
    IEntrega getEntrega(String id);
    boolean containsEncFalse (String encId);

}
