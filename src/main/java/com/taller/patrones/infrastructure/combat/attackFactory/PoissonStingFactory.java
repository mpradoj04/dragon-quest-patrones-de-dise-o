package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;

public class PoissonStingFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new Attack("POISON_STING", 20, Attack.AttackType.STATUS);
    }

}