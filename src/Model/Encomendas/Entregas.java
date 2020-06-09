package Model.Encomendas;


import Model.Tipos.IVoluntario;

import java.time.LocalTime;

public class Entregas extends Encomenda implements IEntregas{
    private LocalTime horaEntrega;
    private IVoluntario voluntario;
}
