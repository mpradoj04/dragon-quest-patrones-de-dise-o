package com.taller.patrones.infrastructure.combat;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;
import com.taller.patrones.infrastructure.combat.attackFactory.AttackRegistry;

/**
 * Motor de combate. Calcula daño y crea ataques.
 * <p>
 * Nota: Esta clase crece cada vez que añadimos un ataque nuevo o un tipo de daño distinto.
 */
public class CombatEngine {

    public Attack createAttack(String name) {
        return AttackRegistry.getFactory(name).createAttack();
    }

    public int calculateDamage(Character attacker, Character defender, Attack attack) {
        return attack.getDamageStrategy().calculateDamage(attacker, defender, attack);
    }
}
