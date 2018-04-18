package model;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
    public final static User dao = new User();
}
