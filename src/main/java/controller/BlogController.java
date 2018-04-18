package controller;

import com.jfinal.core.Controller;


public class BlogController extends Controller {
    public void index(){
        render("myBlog.jsp");
    }
}
