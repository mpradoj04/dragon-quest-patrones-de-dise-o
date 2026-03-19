package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.SingleAttack;
import com.taller.patrones.infrastructure.combat.damageStrategy.NormalAttackStrategy;

public class DefaultAttackFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new SingleAttack("Golpe", 30, Attack.AttackType.NORMAL, new NormalAttackStrategy());
    }

}