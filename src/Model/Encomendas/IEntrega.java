package Model.Encomendas;

import Model.Tipos.ITipo;

import java.time.LocalTime;

public interface IEntrega {

    LocalTime getHoraEntrega();
    void setHoraEntrega(LocalTime horaEntrega);
    ITipo getTransporte();
    void setTransporte(ITipo transporte);
    IEncomenda getEncomenda();
    void setEncomenda(IEncomenda encomenda);
}
