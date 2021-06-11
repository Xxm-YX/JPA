package icu.sgwxm.JPADemo.learn4;

import icu.sgwxm.JPADemo.dao.ModelDao;
import icu.sgwxm.JPADemo.domain6.FilePath;
import icu.sgwxm.JPADemo.domain6.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {

    @Autowired
    private ModelDao modelDao;

    @Test
    @Transactional  //开启事务
    @Rollback(false)//设置为不回滚
    public void test1(){
        Model model = new Model();
        FilePath filePath = new FilePath();

        filePath.setId();

    }
}
