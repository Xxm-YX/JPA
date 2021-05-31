package icu.sgwxm.JPADemo.dao;

import icu.sgwxm.JPADemo.domain4.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUserDao extends JpaRepository<SysUser,Long>, JpaSpecificationExecutor<SysUser> {
}
