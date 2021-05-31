package icu.sgwxm.JPADemo.learn2;

import icu.sgwxm.JPADemo.domain2.Living;
import icu.sgwxm.JPADemo.domain2.PageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 复杂查询2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FTest2 {

    /**
     * 多表查询
     */
//    @Test
//    public void search(){
//
//        String sex = null;
//        String actortype = "A";
//        String cityid =
//
//        Specification<Living> specification = new Specification<Living>() {
//            @Override
//            public Predicate toPredicate(Root<Living> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                List<Predicate> list = new ArrayList<>();
//
//
//            }
//        }
//    }
}
