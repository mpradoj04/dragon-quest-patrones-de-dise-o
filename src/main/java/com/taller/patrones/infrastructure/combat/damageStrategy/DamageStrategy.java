package com.taller.patrones.infrastructure.combat.damageStrategy;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;

public interface DamageStrategy {
    
    int calculateDamage(Character attacker, Character defender, Attack attack);

}
