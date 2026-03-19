package com.taller.patrones.infrastructure.observer;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;

public interface DamageObserver {

    void onDamageDealt(Battle battle, Character attacker, Character defender, int damage, Attack attack);
    
}
