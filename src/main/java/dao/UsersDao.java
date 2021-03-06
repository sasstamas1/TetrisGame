package dao;

import users.Users;
import jpa.GenericJpaDao;


import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserDao létrehozása.
 */
public class UsersDao extends GenericJpaDao<Users> {

    /**
     * UserDao konstruktora.
     */
    public UsersDao(){
        super(Users.class);
    }

    /**
     * Egy stream segitsegevel kiveszi az adatbazisbol a top 20 jatekost.
     *
     * @return a top 20 jatekost.
     */
    public List<Users> getTopTen(){

        Query query = entityManager.createQuery("Select e from Users e");
        List<Users> top10= query.getResultList();
        return top10.stream().sorted(Comparator.comparing(Users::getScore).reversed()).collect(Collectors.toList()).subList(0, 20);
    }

}