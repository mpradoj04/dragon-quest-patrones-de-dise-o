package com.taller.patrones.infrastructure.combat.attackFactory;

import java.util.List;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.ComboAttack;

public class ComboAttackFactory extends AttackFactory {

    @Override
    public Attack createAttack() {

        AttackFactory tackleFactory = new TackleFactory();
        AttackFactory slashFactory = new SlashFactory();
        AttackFactory fireballFactory = new FireballFactory();

        return new ComboAttack("Combo Attack", List.of(
            tackleFactory.createAttack(),
            slashFactory.createAttack(),
            fireballFactory.createAttack()
        ));
    }
    
}
