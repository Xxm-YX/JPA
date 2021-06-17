package icu.sgwxm.JPADemo.learn3;

import icu.sgwxm.JPADemo.dao.CustomerDao;
import icu.sgwxm.JPADemo.dao.LinkManDao;
import icu.sgwxm.JPADemo.domain3.Customer;
import icu.sgwxm.JPADemo.domain3.LinkMan;

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
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional  //开启事务
    @Rollback(false)//设置为不回滚
    public void testAdd() {
        Customer c = new Customer();
        c.setCustName("TBD云集中心");
        c.setCustLevel("VIP客户");
        c.setCustSource("网络");
        c.setCustIndustry("商业办公");
        c.setCustAddress("昌平区北七家镇");
        c.setCustPhone("010-84389340");

        LinkMan l = new LinkMan();
        l.setLkmName("TBD联系人");
        l.setLkmGender("male");
        l.setLkmMobile("13811111111");
        l.setLkmPhone("010-34785348");
        l.setLkmEmail("98354834@qq.com");
        l.setLkmPosition("老师");
        l.setLkmMemo("还行吧");

        c.getLinkmans().add(l);
        l.setCustomer(c);
        customerDao.save(c);
        linkManDao.save(l);
    }

    @Test
    @Transactional  //开启事务
    @Rollback(false)//设置为不回滚
    public void testDelete(){
//        linkManDao.deleteById(3L);
        customerDao.deleteById(3L);
    }

    @Transactional
    @Test
    public void testFind(){
//       Customer customer = new Customer();
//       customer.setCustId(4L);
//        Example<Customer> example = Example.of(customer);
        Optional<Customer> byId = customerDao.findById(4L);
        System.out.println("准备获取懒加载的数据啦！！！！！！！");
//        if(byId.isPresent()){
//            Customer customer1 = byId.get();
//            Set<LinkMan> linkmans = customer1.getLinkmans();
//            for (LinkMan linkman : linkmans) {
//                System.out.println(linkman);
//            }
//        }
    }

    @Transactional
    @Test
    public void testFind2(){
        Optional<LinkMan> optional = linkManDao.findById(5L);
        if(optional.isPresent()){
            LinkMan linkMan = optional.get();
            System.out.println(linkMan.getCustomer());
        }
    }

    @Transactional
    @Test
    public void testFind3(){
        Specification<LinkMan> spec = new Specification<LinkMan>() {
            @Override
            public Predicate toPredicate(Root<LinkMan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Join<LinkMan, Customer> join =root.join("customer", JoinType.INNER);
                return cb.like(join.<String>get("custName"),"%TBD%");
            }
        };

        Specification<LinkMan> spec2 = (root,query,cb) ->  {
            //Join代表链接查询，通过root对象获取
            //创建的过程中，第一个参数为关联对象的属性名称，第二个参数为连接查询的方式（left，inner，right）
            //JoinType.LEFT : 左外连接,JoinType.INNER：内连接,JoinType.RIGHT：右外连接
            Join<LinkMan, Customer> join =root.join("customer", JoinType.INNER);
            return cb.like(join.<String>get("custName"),"%TBD%");
        };

        List<LinkMan> all = linkManDao.findAll(spec2);
        for (LinkMan linkMan : all) {
            System.out.println(linkMan);
        }
    }

}
