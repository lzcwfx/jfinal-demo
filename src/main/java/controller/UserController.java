package controller;

import com.jfinal.core.Controller;
import model.User;

import java.util.List;


public class UserController extends Controller {
    /**
     * 注册跳转
     */
    public void register(){
        render("register.jsp");
    }

    /**
     * 登陆跳转
     */
    public void login(){
        render("login.jsp");
    }

    /**
     * 登陆模块
     */
    public void submit(){
        String name = getPara("username");
        String password = getPara("password");

        List<User> users = User.dao.find("SELECT * FROM customer WHERE user = '" + name + "' AND password = '" + password + "'");
        setAttr("users", users);
        if (users.size()>0){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }

    /**
     * 注册模块
     */
    public void add(){
        User user = getModel(User.class, "user");
        user.save();

        System.out.println("注册成功");
    }
}
