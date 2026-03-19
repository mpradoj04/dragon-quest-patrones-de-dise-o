package com.taller.patrones.application;

import com.taller.patrones.domain.Battle;

public class BattleFacade {

    private final BattleService battleService = new BattleService();

    public void executeAttack(String battleId, String attackName) {
        Battle battle = battleService.getBattle(battleId);
        
        if (battle.isFinished() || battle == null) return;

        if (battle.isPlayerTurn()) {
            battleService.executePlayerAttack(battleId, attackName);
        } else {
            battleService.executeEnemyAttack(battleId, attackName);
        }
    }
}
