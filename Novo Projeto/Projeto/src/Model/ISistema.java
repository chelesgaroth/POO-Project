package Model;

import Model.Tipos.IEmpresa;
import Model.Tipos.ILoja;
import Model.Tipos.IVoluntario;
import Model.Tipos.IUser;

public interface ISistema {
    void addUser(IUser c);
    boolean existsUser(IUser c);

    void addVoluntario(IVoluntario c);
    boolean existsVoluntario(IVoluntario c);

    void addLoja(ILoja c);
    boolean existsLoja(ILoja c);

    void addEmpresa(IEmpresa c);
    boolean existsEmpresa(IEmpresa c);

    void addLogin(ILogin log, String userID);
    boolean existsLogin(ILogin log);

}
