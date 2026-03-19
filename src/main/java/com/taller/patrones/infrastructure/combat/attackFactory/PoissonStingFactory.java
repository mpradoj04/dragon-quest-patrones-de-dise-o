package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.SingleAttack;
import com.taller.patrones.infrastructure.combat.damageStrategy.StatusAttackStrategy;

public class PoissonStingFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new SingleAttack("POISON_STING", 20, Attack.AttackType.STATUS, new StatusAttackStrategy());
    }

}