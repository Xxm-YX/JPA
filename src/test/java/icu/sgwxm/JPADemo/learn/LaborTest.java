package icu.sgwxm.JPADemo.learn;

import icu.sgwxm.JPADemo.dao.LaborDao;
import icu.sgwxm.JPADemo.domain.Labor;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaborTest{

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    private LaborDao laborDao;

    @Test
    public void getLabor(){
        String jpql = " from Labor";
        List<Labor> resultList = em.createQuery(jpql).getResultList();
        for (Labor labor : resultList) {
            System.out.println(labor);
        }

    }


    @Test
//    @Transactional(rollbackOn = Exception.class)
    public void addLabor(){
        Labor labor = new Labor();
        labor.setName("王五");
        labor.setSex(2);
        labor.setBirthday(new Date());
//        em.persist(labor);
//        em.close();
        laborDao.save(labor);
    }

    @Test
    public void updateLabor(){
        Labor labor = em.find(Labor.class,1l);
        labor.setName("张三1");
        em.merge(labor);
    }
}
