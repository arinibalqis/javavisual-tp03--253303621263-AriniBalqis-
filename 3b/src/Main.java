import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("======================================");
        System.out.println("       CHARACTER MANAGER - TP5");
        System.out.println("======================================");

        // 1. ADD CHARACTER
        System.out.println("\n--- 1. ADD CHARACTER ---");

        Character c1 = new Character(
                1,
                "Arthur",
                10,
                CharacterType.WARRIOR
        );

        Character c2 = new Character(
                2,
                "Merlin",
                15,
                CharacterType.MAGE
        );

        Character c3 = new Character(
                3,
                "Robin",
                12,
                CharacterType.ARCHER
        );

        manager.addCharacter(c1);
        manager.addCharacter(c2);
        manager.addCharacter(c3);

        // 2. DUPLICATE NAME
        System.out.println("\n--- 2. DUPLICATE NAME TEST ---");

        Character duplicate = new Character(
                4,
                "Arthur",
                20,
                CharacterType.MAGE
        );

        boolean duplicateResult =
                manager.addCharacter(duplicate);

        System.out.println(
                "Hasil penambahan duplikat: "
                + duplicateResult
        );

        // 3. FIND BY NAME
        System.out.println("\n--- 3. FIND BY NAME ---");

        Character found = manager.findByName("Merlin");

        if (found != null) {
            System.out.println(
                    "Karakter ditemukan: " + found
            );
        } else {
            System.out.println(
                    "Karakter tidak ditemukan."
            );
        }

        // 4. TOTAL CHARACTERS
        System.out.println("\n--- 4. TOTAL CHARACTERS ---");

        System.out.println(
                "Total karakter: "
                + manager.getTotalCharacters()
        );

        // 5. GET ALL CHARACTERS
        System.out.println("\n--- 5. ALL CHARACTERS ---");

        ArrayList<Character> allCharacters =
                manager.getAllCharacters();

        for (Character character : allCharacters) {
            System.out.println(character);
        }

        // 6. DEFENSIVE COPY
        System.out.println(
                "\n--- 6. DEFENSIVE COPY EXPERIMENT ---"
        );

        ArrayList<Character> copy =
                manager.getAllCharacters();

        System.out.println(
                "Jumlah sebelum copy diubah: "
                + manager.getTotalCharacters()
        );

        copy.clear();

        System.out.println(
                "Jumlah copy setelah clear: "
                + copy.size()
        );

        System.out.println(
                "Jumlah asli setelah copy di-clear: "
                + manager.getTotalCharacters()
        );

        // 7. AVERAGE LEVEL
        System.out.println("\n--- 7. AVERAGE LEVEL ---");

        System.out.println(
                "Rata-rata level: "
                + manager.getAverageLevel()
        );

        // 8. FIND BY TYPE
        System.out.println("\n--- 8. FIND BY TYPE ---");

        ArrayList<Character> mages =
                manager.findByType(CharacterType.MAGE);

        System.out.println(
                "Karakter bertipe MAGE:"
        );

        for (Character character : mages) {
            System.out.println(character);
        }

        // 9. FIND STRONGEST
        System.out.println("\n--- 9. FIND STRONGEST ---");

        Character strongest =
                manager.findStrongest();

        if (strongest != null) {
            System.out.println(
                    "Karakter terkuat: "
                    + strongest
            );
        }

        // 10. REMOVE CHARACTER
        System.out.println("\n--- 10. REMOVE CHARACTER ---");

        manager.removeCharacter("Robin");

        System.out.println(
                "Total setelah remove: "
                + manager.getTotalCharacters()
        );

        // 11. REFERENCE EXPERIMENT
        System.out.println(
                "\n--- 11. REFERENCE EXPERIMENT ---"
        );

        Character a = new Character(
                10,
                "ReferenceA",
                5,
                CharacterType.WARRIOR
        );

        Character b = a;

        b.setLevel(8);

        System.out.println(
                "a.getLevel() = " + a.getLevel()
        );

        System.out.println(
                "a == b = " + (a == b)
        );

        // 12. STATIC COUNTER
        System.out.println(
                "\n--- 12. STATIC COUNTER ---"
        );

        System.out.println(
                "Total object Character yang dibuat: "
                + Character.getTotalCharacterCreated()
        );

        System.out.println("\n======================================");
        System.out.println("          PROGRAM SELESAI");
        System.out.println("======================================");
    }
}