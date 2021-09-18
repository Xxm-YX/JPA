package icu.sgwxm.JPADemo.learn4;

import icu.sgwxm.JPADemo.dao.CustomerDao;
import icu.sgwxm.JPADemo.dao.LinkManDao;
import icu.sgwxm.JPADemo.dao.ModelDao;
import icu.sgwxm.JPADemo.dao.PathDao;
import icu.sgwxm.JPADemo.domain3.Customer;
import icu.sgwxm.JPADemo.domain3.LinkMan;
import icu.sgwxm.JPADemo.domain6.Model;
import icu.sgwxm.JPADemo.domain6.Path;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyTest {

    @Autowired
    private ModelDao modelDao;

    @Autowired
    private PathDao pathDao;

    @Test
    @Transactional  //开启事务
    @Rollback(false)//设置为不回滚
    public void testAdd() {
        Model model = new Model();
        model.setCustId(UUID.randomUUID());
        model.setCustName("zyx");

        Path path = new Path();
        path.setLkmId(UUID.randomUUID());
        path.setPath("xxm");

        model.getLinkmans().add(path);
        path.setModel(model);

        modelDao.save(model);
        pathDao.save(path);
    }

    @Test
    @Transactional  //开启事务
    @Rollback(false)//设置为不回滚
    public void show(){
        List<Model> all = modelDao.findAll();
        System.out.println(all);
    }



}
