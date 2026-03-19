package com.taller.patrones.infrastructure.combat.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.SingleAttack;
import com.taller.patrones.infrastructure.combat.damageStrategy.NormalAttackStrategy;

public class SlashFactory extends AttackFactory{
    
    @Override
    public Attack createAttack() {
        return new SingleAttack("SLASH", 55, Attack.AttackType.NORMAL, new NormalAttackStrategy());
    }

}