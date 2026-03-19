package com.taller.patrones.application;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;
import com.taller.patrones.infrastructure.combat.CombatEngine;
import com.taller.patrones.infrastructure.command.AttackCommand;
import com.taller.patrones.infrastructure.observer.DamagePublisher;
import com.taller.patrones.infrastructure.observer.LogObserver;
import com.taller.patrones.infrastructure.persistence.BattleRepository;

import java.util.List;
import java.util.UUID;

/**
 * Caso de uso: gestionar batallas.
 * <p>
 * Nota: Crea sus propias dependencias con new. Cada vez que necesitamos
 * un CombatEngine o BattleRepository, hacemos new aquí.
 */
public class BattleService {

    private final CombatEngine combatEngine = new CombatEngine();
    private static BattleRepository battleRepository = BattleRepository.getInstance();

    public static final List<String> PLAYER_ATTACKS = List.of("TACKLE", "SLASH", "FIREBALL", "ICE_BEAM", "POISON_STING", "THUNDER", "METEORO");
    public static final List<String> ENEMY_ATTACKS = List.of("TACKLE", "SLASH", "FIREBALL");

    public BattleService() {
        DamagePublisher.subscribe(new LogObserver());
    }

    public BattleStartResult startBattle(String playerName, String enemyName) {
        Character player = Character.builder()
                .withName(playerName != null ? playerName : "Héroe")
                .withMaxHp(150)
                .withAttack(25)
                .withDefense(15)
                .withSpeed(20)
                .build();

        Character enemy = Character.builder()
                .withName(enemyName != null ? enemyName : "Dragón")
                .withMaxHp(120)
                .withAttack(30)
                .withDefense(10)
                .withSpeed(15)
                .build();

        Battle battle = new Battle(player, enemy);
        String battleId = UUID.randomUUID().toString();
        battleRepository.save(battleId, battle);

        return new BattleStartResult(battleId, battle);
    }

    public Battle getBattle(String battleId) {
        return battleRepository.findById(battleId);
    }

    public void executePlayerAttack(String battleId, String attackName) {
        Battle battle = battleRepository.findById(battleId);
        if (battle == null || battle.isFinished() || !battle.isPlayerTurn()) return;

        Attack attack = combatEngine.createAttack(attackName);
        int damage = combatEngine.calculateDamage(battle.getPlayer(), battle.getEnemy(), attack);
        applyDamage(battle, battle.getPlayer(), battle.getEnemy(), damage, attack);
    }

    public void executeEnemyAttack(String battleId, String attackName) {
        Battle battle = battleRepository.findById(battleId);
        if (battle == null || battle.isFinished() || battle.isPlayerTurn()) return;

        Attack attack = combatEngine.createAttack(attackName != null ? attackName : "TACKLE");
        int damage = combatEngine.calculateDamage(battle.getEnemy(), battle.getPlayer(), attack);
        applyDamage(battle, battle.getEnemy(), battle.getPlayer(), damage, attack);
    }

    private void applyDamage(Battle battle, Character attacker, Character defender, int damage, Attack attack) {
        AttackCommand command = new AttackCommand(battle, attacker, defender, attack, damage);
        battle.executeAttack(command);
        DamagePublisher.notify(battle, attacker, defender, damage, attack);
    }

    public void undoLastAttack(String battleId) {
        Battle battle = battleRepository.findById(battleId);
        if (battle != null && !battle.isFinished()) {
            battle.undoLastAttack();
        }
    }

    public BattleStartResult startBattleFromExternal(String fighter1Name, int fighter1Hp, int fighter1Atk,
                                                     String fighter2Name, int fighter2Hp, int fighter2Atk) {
        Character player = Character.builder()
                .withName(fighter1Name)
                .withMaxHp(fighter1Hp)
                .withAttack(fighter1Atk)
                .withDefense(10)
                .withSpeed(10)
                .build();
        Character enemy = Character.builder()
                .withName(fighter2Name)
                .withMaxHp(fighter2Hp)
                .withAttack(fighter2Atk)
                .withDefense(10)
                .withSpeed(10)
                .build();
        Battle battle = new Battle(player, enemy);
        String battleId = UUID.randomUUID().toString();
        battleRepository.save(battleId, battle);
        return new BattleStartResult(battleId, battle);
    }

    public record BattleStartResult(String battleId, Battle battle) {}
}
