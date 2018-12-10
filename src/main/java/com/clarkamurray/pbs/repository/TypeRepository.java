package com.clarkamurray.pbs.repository;

import com.clarkamurray.pbs.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeRepository extends JpaRepository<Type, Integer>, JpaSpecificationExecutor<Type> {
}
