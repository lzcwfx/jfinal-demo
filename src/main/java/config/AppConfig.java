package config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import controller.UserController;
import model.User;

public class AppConfig extends JFinalConfig{
    public void configConstant(Constants me) {
        PropKit.use("config.properties");
        me.setDevMode(true);
    }

    public void configEngine(Engine engine) {

    }

    public void configRoute(Routes me) {
        me.add("/user", UserController.class);
    }
    public void configPlugin(Plugins plugins) {
        DruidPlugin db = new DruidPlugin(PropKit.get("jdbcUrl"),PropKit.get("user"),PropKit.get("password"));
        plugins.add(db);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(db);
        arp.setShowSql(true);
        arp.addMapping("customer", User.class);
        plugins.add(arp);
    }
    public void configInterceptor(Interceptors interceptors) {}
    public void configHandler(Handlers handlers) {}

    //用于启动JFinal
    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 8080, "/");
    }
}
