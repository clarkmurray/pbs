package com.clarkamurray.pbs.controller;

import com.clarkamurray.pbs.config.AbstractController;
import com.clarkamurray.pbs.model.Attack;
import com.clarkamurray.pbs.service.AttackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/attack")
public class AttackController extends AbstractController<Attack, Integer> {

    private AttackService attackService;

    public AttackController (AttackService attackService) {
        super(attackService);
        this.attackService = attackService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> findAllAttacks(HttpServletRequest request) {
        List<Attack> results = attackService.findAllAttacks();
        return ResponseEntity.ok(results);
    }

}
