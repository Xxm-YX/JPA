package icu.sgwxm.JPADemo.dao;

import icu.sgwxm.JPADemo.domain6.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ModelDao extends JpaRepository<Model, UUID>, JpaSpecificationExecutor<Model> {


}
