package icu.sgwxm.JPADemo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@Data
public class Employee {
    //    实体Employee包含字段分别有：id, 姓名(name), 年龄(age), 性别(gender), companyId, 薪资(salary)
    @Id //定义属性为数据库的主键，每个实体必须要有一个
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO) //定义主键生成策略
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "age",nullable = false)
    private int age;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "companyId",nullable = false)
    private int companyId;

    @Column(name = "salary",nullable = false)
    private int salary;

    public Employee(){}

    public Employee(int id,String name,int age,String gender,int companyId,int salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.companyId = companyId;
        this.salary = salary;
    }

}
