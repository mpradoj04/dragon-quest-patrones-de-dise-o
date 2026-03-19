package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.SingleAttack;
import com.taller.patrones.infrastructure.combat.damageStrategy.SpecialAttackStrategy;

public class MeteoroFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new SingleAttack("METEORO", 120, Attack.AttackType.SPECIAL, new SpecialAttackStrategy());
    }

}
