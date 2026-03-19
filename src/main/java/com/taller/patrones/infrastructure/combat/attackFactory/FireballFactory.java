package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.infrastructure.combat.damageStrategy.SpecialAttackStrategy;

public class FireballFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new Attack("FIREBALL", 80, Attack.AttackType.SPECIAL, new SpecialAttackStrategy());
    }

}