import Controller.*;
import Model.*;
import Model.ModosMVC.User.Controller.IUserController;
import Model.ModosMVC.User.Controller.UserController;
import View.*;

public class MainMVC {

    public static void main(String[] args) {

        IAppView view = new AppView();
        ISistema sistema = new Sistema();
        IAppController controller = new AppController();

        controller.setSistema(sistema);
        controller.setAppView(view);


        controller.runController();
        if(controller.signUp() == 'u'){
            controller.userMode(); //ou chama o controller da appUser
        }
        //fazer varias funcoes no controller?
        //uma que nos lê o ficheiro
        //outra que faz registo ou login
        //e outra que nos apresenta a app de acordo com o tipo de quem esta a usar a app??
        //assim podemos voltar atras nos menus
    }
}
