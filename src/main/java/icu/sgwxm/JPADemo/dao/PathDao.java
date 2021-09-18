package icu.sgwxm.JPADemo.dao;

import icu.sgwxm.JPADemo.domain6.Model;
import icu.sgwxm.JPADemo.domain6.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PathDao extends JpaRepository<Path, UUID>, JpaSpecificationExecutor<Path> {


}
