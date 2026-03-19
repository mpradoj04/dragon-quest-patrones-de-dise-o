package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.infrastructure.combat.damageStrategy.NormalAttackStrategy;

public class TackleFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new Attack("TACKLE", 40, Attack.AttackType.NORMAL, new NormalAttackStrategy());
    }

}