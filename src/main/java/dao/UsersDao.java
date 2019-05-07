package dao;

import Users.Users;
import jpa.GenericJpaDao;

public class UsersDao extends GenericJpaDao<Users> {

    public UsersDao(){
        super(Users.class);
    }


}