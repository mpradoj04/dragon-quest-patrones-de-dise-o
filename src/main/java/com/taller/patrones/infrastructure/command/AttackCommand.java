package com.taller.patrones.infrastructure.command;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;

public class AttackCommand {
    
    private final Battle battle;
    private final Character attacker;
    private final Character defender;
    private final Attack attack;
    private final int damage;

    private int defenderHpBefore;
    private String previousTurn;

    public AttackCommand(Battle battle, Character attacker, Character defender, Attack attack, int damage) {
        this.battle = battle;
        this.attacker = attacker;
        this.defender = defender;
        this.attack = attack;
        this.damage = damage;
    }

    public void execute() {
        defenderHpBefore = defender.getCurrentHp();
        previousTurn = battle.getCurrentTurn();

        defender.takeDamage(damage);
        String target = defender == battle.getPlayer() ? "player" : "enemy";

        battle.setLastDamage(damage, target);

        battle.switchTurn();
        if(!defender.isAlive()) {
            battle.finish(attack.getName());
        }
    }

    public void undo() {
        defender.setCurrentHp(defenderHpBefore);
        battle.setLastDamage(0, previousTurn);

        battle.switchTurn();
    }
}
