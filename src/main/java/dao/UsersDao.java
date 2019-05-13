package dao;

import Users.Users;
import jpa.GenericJpaDao;


import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsersDao extends GenericJpaDao<Users> {

    public UsersDao(){
        super(Users.class);
    }

    /**
     * Stream seg�ts�g�vel kiveszi az adatb�zisb�l a top 20 j�t�kost
     *
     * @return a top 20 j�t�kost
     */
    public List<Users> getTopTen(){

        Query query = entityManager.createQuery("Select e from Users e");
        List<Users> top10= query.getResultList();
        return top10.stream().sorted(Comparator.comparing(Users::getScore).reversed()).collect(Collectors.toList()).subList(0, 20);
    }

}