package com.clarkamurray.pbs.service;

import com.clarkamurray.pbs.config.AbstractTableService;
import com.clarkamurray.pbs.model.Attack;
import com.clarkamurray.pbs.repository.AttackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttackService extends AbstractTableService<Attack, Integer> {

    private AttackRepository attackRepository;

    public AttackService(AttackRepository attackRepository) {
        super(attackRepository);
        this.attackRepository = attackRepository;
    }

    public List<Attack> findAllAttacks() {
        List<Attack> attacks = attackRepository.findAll();
        return attacks;
    }

}
