import Controller.*;
import Model.*;
import View.*;

public class MainMVC {

    public static void main(String[] args) {

        IAppView view = new AppView();
        ISistema sistema = new Sistema();
        IAppController controller = new AppController();

        controller.setSistema(sistema);
        controller.setAppView(view);

        controller.runController();
    }
}
