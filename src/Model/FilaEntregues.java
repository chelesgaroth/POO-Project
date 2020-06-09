package Model;

import Model.Encomendas.IEncomenda;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FilaEntregues implements IFila {
    private Map<String, Set<IEncomenda>> fila;

    public FilaEntregues(){
        this.fila = new HashMap<>();
    }


    public void addEncomenda(IEncomenda encomenda) {

    }


    public int removeEncomenda(IEncomenda encomenda) {
        return 0;
    }

    @Override
    public Set<IEncomenda> getEncomendas(String codId) {
        return null;
    }

    @Override
    public boolean containsEncTipo(String encId, String codId) {
        return false;
    }

    @Override
    public IEncomenda getEncomendaTipo(String encId, String codId) {
        return null;
    }

    public String toString() {
        return "Fila: " + fila;
    }
}
