package com.taller.patrones.domain.builders;

import com.taller.patrones.domain.Character;

public class CharacterBuilder {

    private String name;
    private int maxHp;
    private int attack;
    private int defense;
    private int speed;

    public CharacterBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder withMaxHp(int maxHp) {
        this.maxHp = maxHp;
        return this;
    }

    public CharacterBuilder withAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public CharacterBuilder withDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public CharacterBuilder withSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public Character build() {
        return new Character(name, maxHp, attack, defense, speed);
    }
    
}
