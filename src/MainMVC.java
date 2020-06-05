import Controller.*;
import Model.*;
import Model.ModosMVC.User.IUserController;
import Model.ModosMVC.User.UserController;
import View.*;

public class MainMVC {

    public static void main(String[] args) {

        IAppView view = new AppView();
        ISistema sistema = new Sistema();
        IAppController controller = new AppController();
        IUserController userController = new UserController();
        controller.setSistema(sistema);
        controller.setAppView(view);
        userController.setSistema(sistema);
        userController.setAppView(view);


        controller.runController();
        if(controller.signUp() == 'u'){
            userController.userMode(); //ou chama o controller da appUser
        }
        //fazer varias funcoes no controller?
        //uma que nos lê o ficheiro
        //outra que faz registo ou login
        //e outra que nos apresenta a app de acordo com o tipo de quem esta a usar a app??
        //assim podemos voltar atras nos menus
    }
}