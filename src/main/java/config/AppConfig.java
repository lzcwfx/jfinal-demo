package config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.render.ViewType;
import controller.BlogController;

public class AppConfig extends JFinalConfig{
    public void configConstant(Constants me) {
        me.setViewType(ViewType.JSP);
        me.setBaseViewPath("/view");
        me.setDevMode(true);
    }
    public void configRoute(Routes me) {
        me.add("/blog", BlogController.class);
    }
    public void configPlugin(Plugins plugins) {}
    public void configInterceptor(Interceptors interceptors) {}
    public void configHandler(Handlers handlers) {}

    //用于启动JFinal
    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 8080, "/blog", 5);
    }
}
