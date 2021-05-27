package icu.sgwxm.JPADemo.dao;


import icu.sgwxm.JPADemo.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户服务数据接口类
 *
 * @author 杨高超
 * @since 2018-03-12
 */

@Repository
public interface UserDao extends JpaRepository<UserDO, Long> {

    @Query(value = "select t from UserDO t where t.account = ?1")
    UserDO findAccount(String account);

    @Query(value = "select u from UserDO u where u.name = ?1 and u.id = ?2")
    UserDO findOne(String username,Long id);

    @Query(value = "select u from UserDO u where u.id in :ids")
    List<UserDO> findByIdArr(@Param("ids") Long[] aaa);

    @Query(value = "select u.name from UserDO u")
    List findUserAll();


}