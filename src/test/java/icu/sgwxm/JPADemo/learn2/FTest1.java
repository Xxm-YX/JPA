package icu.sgwxm.JPADemo.learn2;

import icu.sgwxm.JPADemo.dao.User1Dao;
import icu.sgwxm.JPADemo.domain.PageParam;
import icu.sgwxm.JPADemo.domain2.User;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 复杂查询练习
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FTest1 {

    @Autowired
    private User1Dao user1Dao;
    /**
     * 单表的  这里使用 Predict 断言
     */
    @Test
    public void search(){
        PageParam page = new PageParam();
//        page.setSearchName("zhangsan");
        User student = new User();
        student.setUname("zhang");
//        PageRequest pageRequest = ;
        Page<User> all = user1Dao.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate userNameLike = null;
                if(null != student && !StringUtils.isEmpty(student.getUname())){
                    // 这里也可以root.get("name").as(String.class)这种方式来强转泛型类型
                    userNameLike = criteriaBuilder.like(root.get("uname"),"%"+student.getUname()+"%");
                }
                if(null != userNameLike) criteriaQuery.where(userNameLike);  //这里等同于加到where语句后面

//                下面还可以加其他的条件查询
//                Predicate clazzNameLike = null;
//                if(null != student && null != student.getClazz() && !StringUtils.isEmpty(student.getClazz().getName())) {
//                    clazzNameLike = cb.like(root.<String> get("clazz").<String> get("name"), "%" + student.getClazz().getName() + "%");
                    return null;
            }
        }, PageRequest.of(0, page.getPageSize()));
        //分页是从第0页开始

        List<User> content = all.getContent();
        for (User user : content) {
            System.out.println(user);
        }
    }

    @Test
    public void search2(){
        User student = new User();
        student.setUname("zhang");

        String searchName = "zhang";
        String searchId = "1";
        String searchMobile = "1";
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(StringUtils.isNotBlank(searchName)){
                    list.add(criteriaBuilder.like(root.<String>get("uname"),"%"+searchName+"%"));
                }
                if (StringUtils.isNotBlank(searchId)) {
                    list.add(criteriaBuilder.equal(root.get("uid").as(Long.class), searchId));
                }

                if (StringUtils.isNotBlank(searchMobile)) {
                    list.add(criteriaBuilder.like(root.get("utel").as(String.class), "%" + searchMobile + "%"));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
        List<User> all = user1Dao.findAll(specification);
        System.out.println(all);
    }




}
