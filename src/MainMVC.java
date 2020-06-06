import Controller.*;
import Model.*;
import Model.ModosMVC.Loja.*;
import Model.ModosMVC.User.IUserController;
import Model.ModosMVC.User.IUserView;
import Model.ModosMVC.User.UserController;
import Model.ModosMVC.User.UserView;
import View.*;

public class MainMVC {

    public static void main(String[] args) {

        IAppView view = new AppView();
        ISistema sistema = new Sistema();
        IAppController controller = new AppController();

        IUserView userView = new UserView();
        IUserController userController = new UserController();

        ILojaView lojaView = new LojaView();
        ILojaController lojaController = new LojaController();
        IAppLoja lojaModel = new AppLoja();

        controller.setSistema(sistema);
        controller.setAppView(view);

        userController.setSistema(sistema);
        userController.setAppView(userView);

        lojaController.setSistema(sistema); //será que devemos ter o sistema???
        lojaController.setView(lojaView);
        lojaController.setModel(lojaModel);

        controller.runController();
        char login = controller.signUp();
        while(login != '0') {
            if (login == 'u') {
                userController.userMode(); //ou chama o controller da appUser
            }
            if (login == 'l') {
                lojaController.lojaMode();
            }
            login = controller.signUp();
        }

        //fazer varias funcoes no controller?
        //uma que nos lê o ficheiro
        //outra que faz registo ou login
        //e outra que nos apresenta a app de acordo com o tipo de quem esta a usar a app??
        //assim podemos voltar atras nos menus
    }
}