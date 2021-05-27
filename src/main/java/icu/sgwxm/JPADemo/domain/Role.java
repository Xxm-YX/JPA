package icu.sgwxm.JPADemo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 人员角色
 */
@Entity
@Table(name = "test_role")
@Setter
@Getter
public class Role {
    /**
     * GenerationType.IDENTITY 自增  mysql
     * GenerationType.SEQUENCE 序列  oracle
     * GenerationType.TABLE JPA提供的一种机制，通过一张数据库表完成主键自增
     * GenerationType.AUTO 由程序根据数据库类型自动选择适合的主键生成策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "rolename")
    private String rolename;

    /**
     * 这个 数据库会创建一个sid字段，来存储labor表的id主键
     */
    @ManyToOne(targetEntity = Labor.class)
    //这里配置外键
    @JoinColumn(name = "sid",referencedColumnName = "id")
    private Labor labor;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
