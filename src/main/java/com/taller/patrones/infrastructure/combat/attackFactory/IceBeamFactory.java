package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.infrastructure.combat.damageStrategy.SpecialAttackStrategy;

public class IceBeamFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new Attack("ICE_BEAM", 70, Attack.AttackType.SPECIAL, new SpecialAttackStrategy());
    }

}