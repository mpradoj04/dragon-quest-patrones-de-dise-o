package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;

public class SlashFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new Attack("SLASH", 55, Attack.AttackType.NORMAL);
    }

}