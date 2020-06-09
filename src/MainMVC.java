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


        controller.setSistema(sistema);
        controller.setAppView(view);





        controller.runController();
        int res=0;
        char login = controller.signUp();
        while(login != '0') {
            if (login == 'u') {
                userController.setSistema(sistema);
                userController.setAppView(userView);
                res = userController.userMode();
                //if(res==1) login = 'l';
            }
            if (login == 'l') {
                lojaController.setSistema(sistema);
                lojaController.setView(lojaView);
                System.out.println(sistema.toString());
                lojaController.lojaMode();
            }

            login = controller.signUp();
        }
    }
}