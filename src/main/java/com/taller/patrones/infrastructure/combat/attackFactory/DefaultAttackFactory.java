package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;

public class DefaultAttackFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new Attack("Golpe", 30, Attack.AttackType.NORMAL);
    }

}