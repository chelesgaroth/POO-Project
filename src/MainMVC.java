import Controller.*;
import Model.*;
import Controller.IUserController;
import View.IUserView;
import Controller.UserController;
import View.UserView;
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

        IVoluntarioView volView = new VoluntarioView();
        IVoluntarioController volController = new VoluntarioController();

        controller.setSistema(sistema);
        controller.setAppView(view);

        sistema = controller.runController();

        controller.setSistema(sistema);
        controller.setAppView(view);

        userController.setSistema(sistema);
        userController.setAppView(userView);

        lojaController.setSistema(sistema);
        lojaController.setView(lojaView);

        volController.setSistema(sistema);
        volController.setAppView(volView);

        int res=0;
        char login = controller.signUp();
        while(login != '0') {
            if (login == 'u') {
                res = userController.userMode();
                //if(res==1) login = 'l';
            }
            if (login == 'l') {
                System.out.println(sistema.toString());
                lojaController.lojaMode();
            }
            if(login == 'v'){
                System.out.println(sistema.toString());
                volController.VoluntarioMode();
            }

            login = controller.signUp();
        }
    }
}