package com.taller.patrones.domain;

import com.taller.patrones.infrastructure.combat.damageStrategy.DamageStrategy;

/**
 * Representa un ataque que puede ejecutar un personaje.
 */
public interface Attack {

    String getName();
    int getBasePower();
    AttackType getType();
    DamageStrategy getDamageStrategy();

    enum AttackType {
        NORMAL, SPECIAL, STATUS
    }
}
