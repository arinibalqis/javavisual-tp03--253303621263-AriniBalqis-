package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private ArrayList<Character> characterList;

    public CharacterManager() {
        characterList = new ArrayList<>();
    }

    public boolean addCharacter(Character character) {

        if (character == null) {
            return false;
        }

        if (characterList.contains(character)) {
            System.out.println(
                    "Nama karakter sudah digunakan: "
                    + character.getName()
            );
            return false;
        }

        characterList.add(character);

        System.out.println(
                "Karakter berhasil ditambahkan: "
                + character.getName()
        );

        return true;
    }

    public Character findByName(String name) {

        for (Character character : characterList) {

            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {

        Character character = findByName(name);

        if (character != null) {

            characterList.remove(character);

            System.out.println(
                    "Karakter berhasil dihapus: " + name
            );

            return true;
        }

        System.out.println(
                "Karakter tidak ditemukan: " + name
        );

        return false;
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    public ArrayList<Character> getAllCharacters() {

        return new ArrayList<>(characterList);
    }

    public double getAverageLevel() {

        if (characterList.isEmpty()) {
            return 0;
        }

        int totalLevel = 0;

        for (Character character : characterList) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characterList.size();
    }

    public ArrayList<Character> findByType(CharacterType type) {

        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characterList) {

            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Mencari karakter dengan level tertinggi.
     *
     * @return karakter dengan level tertinggi,
     * atau null jika tidak ada karakter
     */
    public Character findStrongest() {

        if (characterList.isEmpty()) {
            return null;
        }

        Character strongest = characterList.get(0);

        for (Character character : characterList) {

            if (character.getLevel() > strongest.getLevel()) {
                strongest = character;
            }
        }

        return strongest;
    }
}