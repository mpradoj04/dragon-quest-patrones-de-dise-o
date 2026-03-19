package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;

public class MeteoroFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new Attack("METEORO", 120, Attack.AttackType.SPECIAL);
    }

}
