package icu.sgwxm.JPADemo.learn;

import icu.sgwxm.JPADemo.dao.EmployeeRepository;
import icu.sgwxm.JPADemo.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeJPATest {

    @Autowired
    private EmployeeRepository employeeRepository;

    /*
     * 实体Employee包含字段分别有：id, 姓名(name), 年龄(age), 性别(gender), companyId, 薪资(salary)
     * 实体Company包含字段分别有：id, 公司名(companyName), 员工数量(employeesNumber)
     */
    @Test
    public void test1(){
        //1.查询名字是小红的employee
        Employee employee = new Employee(1,"xiaohong",19,"female",1,7000);

        String xiaohong = employeeRepository.findFirstByName("xiaohong").getName();
        System.out.println(xiaohong);
    }

    //2.找出Employee表中第一个名字包含n字符的雇员所有信息
    @Test
    public void test2(){
        Employee firstByNameLikeAndSalaryIsGreaterThan = employeeRepository.findFirstByNameLikeAndSalaryIsGreaterThan("%n%", 6000);
        System.out.println(firstByNameLikeAndSalaryIsGreaterThan.toString());
    }

    //3.找出一个薪资最高且公司ID是1的雇员以及该雇员的name
    @Test
    public void test3(){
        String byMaxSalaryAndCompanyId = employeeRepository.findByMaxSalaryAndCompanyId(1);
        System.out.println(byMaxSalaryAndCompanyId);
    }

    //4。实现对Employee的分页查询，每页两条数据，一共三页
    //注意：PageRequest的构造方法已经弃用了代替的是PageRequest.of,并且最后一个参数代表按照table中的哪一个字段排序
    @Test
    public void test4(){
        Page<Employee> page = employeeRepository.findAllEmployee(PageRequest.of(3,1));

        List<Employee> content = page.getContent();
        for (Employee employee : content) {
            System.out.println("==================================="+employee);
        }
    }

    //5.查找xiaohong的所在公司的名称
    @Test
    public void test5(){
        String xiaohong = employeeRepository.findCompayNameByEmployeeName("xiaohong");
        System.out.println(xiaohong);
    }


}
