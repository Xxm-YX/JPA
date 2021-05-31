package icu.sgwxm.JPADemo.learn3;

import icu.sgwxm.JPADemo.dao.RoleDao;
import icu.sgwxm.JPADemo.dao.SysRoleDao;
import icu.sgwxm.JPADemo.dao.SysUserDao;
import icu.sgwxm.JPADemo.domain4.SysRole;
import icu.sgwxm.JPADemo.domain4.SysUser;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * 多对多的操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTest {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 需求：
     * 	保存用户和角色
     * 要求：
     * 	创建2个用户和3个角色
     * 	让1号用户具有1号和2号角色(双向的)
     * 	让2号用户具有2号和3号角色(双向的)
     *  保存用户和角色
     * 问题：
     *  在保存时，会出现主键重复的错误，因为都是要往中间表中保存数据造成的。
     * 解决办法：
     * 	让任意一方放弃维护关联关系的权利
     */

    @Test
    @Transactional
    @Rollback(value = false)
    public void test1(){
        //创建对象
        SysUser u1 = new SysUser();
        u1.setUserName("用户1");
        SysRole r1 = new SysRole();
        r1.setRoleName("角色1");

        //建立关联关系
        u1.getRoles().add(r1);
        r1.getUsers().add(u1);

        //保存
        sysRoleDao.save(r1);
        sysUserDao.save(u1);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testDelete(){

        sysUserDao.deleteById(7L);
    }
}
