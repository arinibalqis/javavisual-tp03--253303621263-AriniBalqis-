package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private int id;
    private String name;
    private int level;
    private CharacterType type;

    private static int totalCharacterCreated = 0;

    public Character(int id, String name, int level, CharacterType type) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.type = type;

        totalCharacterCreated++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public CharacterType getType() {
        return type;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", type=" + type +
                '}';
    }
}