package config;

import com.jfinal.core.Controller;

public class AppController  extends Controller {
    public void index(){
        renderText("Hello Maven JFinal");
    }
}
