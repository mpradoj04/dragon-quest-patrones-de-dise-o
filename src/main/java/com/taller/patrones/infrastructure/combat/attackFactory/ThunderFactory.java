package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.infrastructure.combat.damageStrategy.SpecialAttackStrategy;

public class ThunderFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new Attack("THUNDER", 90, Attack.AttackType.SPECIAL, new SpecialAttackStrategy());
    }

}