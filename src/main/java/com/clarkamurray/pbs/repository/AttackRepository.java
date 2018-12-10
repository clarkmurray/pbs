package com.clarkamurray.pbs.repository;

import com.clarkamurray.pbs.model.Attack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttackRepository extends JpaRepository<Attack, Integer>, JpaSpecificationExecutor<Attack> {
}
