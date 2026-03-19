package com.taller.patrones.infrastructure.command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    
    private final List<AttackCommand> commands = new ArrayList<>();

    public void execute(AttackCommand command) {
        command.execute();
        commands.add(command);
    }

    public void undo() {
        if (!commands.isEmpty()) {
            AttackCommand lastCommand = commands.remove(commands.size() - 1);
            lastCommand.undo();
        }
    }

}
