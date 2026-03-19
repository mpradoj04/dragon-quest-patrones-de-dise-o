package com.taller.patrones.domain;

import com.taller.patrones.infrastructure.combat.damageStrategy.DamageStrategy;

/**
 * Representa un ataque que puede ejecutar un personaje.
 */
public class Attack {

    private final String name;
    private final int basePower;
    private final AttackType type;
    private final DamageStrategy damageStrategy;
    
    public Attack(String name, int basePower, AttackType type, DamageStrategy damageStrategy) {
        this.name = name;
        this.basePower = basePower;
        this.type = type;
        this.damageStrategy = damageStrategy;
    }

    public String getName() { return name; }
    public int getBasePower() { return basePower; }
    public AttackType getType() { return type; }
    public DamageStrategy getDamageStrategy() { return damageStrategy; }

    public enum AttackType {
        NORMAL, SPECIAL, STATUS
    }
}
