package icu.sgwxm.JPADemo.domain6;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity//表示当前类是一个实体类
@Table(name="cst_model")//建立当前实体类和表之间的对应关系
@Getter
@Setter
public class Model{
    @Id//表明当前私有属性是主键
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name="cust_id")//指定和数据库表中的cust_id列对应
    private UUID custId;
    @Column(name="cust_name")//指定和数据库表中的cust_name列对应
    private String custName;


    //配置客户和联系人的一对多关系
//    @OneToMany(targetEntity=LinkMan.class)
//    @JoinColumn(name="lkm_cust_id",referencedColumnName="cust_id")

    /**
     * cascade:配置级联操作
     * 		CascadeType.MERGE	级联更新
     * 		CascadeType.PERSIST	级联保存：
     * 		CascadeType.REFRESH 级联刷新：
     * 		CascadeType.REMOVE	级联删除：
     * 		CascadeType.ALL		包含所有
     */

    /**
     * 在客户对象的@OneToMany注解中添加fetch属性
     * 		FetchType.EAGER	：立即加载
     * 		FetchType.LAZY	：延迟加载
     */

    @OneToMany(mappedBy = "model",cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH },fetch = FetchType.LAZY)
//    @JoinColumn(name = "cust_id")
    @org.hibernate.annotations.ForeignKey(name = "none")
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<Path> linkmans = new HashSet<Path>(0);

    @Override
    public String toString() {
        return "Model{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", linkmans=" + linkmans +
                '}';
    }
}