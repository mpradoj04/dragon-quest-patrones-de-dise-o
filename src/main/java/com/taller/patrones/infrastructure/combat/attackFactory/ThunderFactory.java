package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;

public class ThunderFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new Attack("THUNDER", 90, Attack.AttackType.SPECIAL);
    }

}