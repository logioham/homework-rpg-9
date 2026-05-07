package com.narxoz.rpg;

/**
 * Entry point for Homework 9 — Chronomancer's Vault: Visitor + Memento.
 *
 * The scaffold prints the banner only; students fill in the vault demo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        // 1. Create at least 2 heroes with different starting states.
        com.narxoz.rpg.artifact.Inventory inv1 = new com.narxoz.rpg.artifact.Inventory();
        inv1.addArtifact(new com.narxoz.rpg.artifact.Weapon("Excalibur", 1000, 10, 50));
        inv1.addArtifact(new com.narxoz.rpg.artifact.Potion("Elixir of Life", 50, 2, 100));
        inv1.addArtifact(new com.narxoz.rpg.artifact.Ring("Ring of Power", 500, 1, 20));

        com.narxoz.rpg.combatant.Hero hero1 = new com.narxoz.rpg.combatant.Hero(
            "Arthur", 100, 50, 20, 15, 200, inv1
        );

        com.narxoz.rpg.artifact.Inventory inv2 = new com.narxoz.rpg.artifact.Inventory();
        inv2.addArtifact(new com.narxoz.rpg.artifact.Armor("Dragon Scale", 800, 40, 30));
        inv2.addArtifact(new com.narxoz.rpg.artifact.Scroll("Scroll of Fireball", 150, 1, "Fireball"));

        com.narxoz.rpg.combatant.Hero hero2 = new com.narxoz.rpg.combatant.Hero(
            "Merlin", 60, 200, 5, 10, 500, inv2
        );

        // 2. Build an artifact inventory and exercise the visitor interface.
        System.out.println("\n--- Global Artifact Inspection ---");
        com.narxoz.rpg.artifact.Inventory globalInv = new com.narxoz.rpg.artifact.Inventory();
        globalInv.addArtifact(new com.narxoz.rpg.artifact.Weapon("Cursed Blade", 10, 15, -5));
        globalInv.addArtifact(new com.narxoz.rpg.artifact.Potion("Poison Vial", 5, 1, -20));
        globalInv.addArtifact(new com.narxoz.rpg.artifact.Ring("Magic Ring", 200, 1, 5));
        globalInv.addArtifact(new com.narxoz.rpg.artifact.Armor("Plate Mail", 300, 50, 15));
        globalInv.addArtifact(new com.narxoz.rpg.artifact.Scroll("Scroll of Doom", 50, 2, "Curse of Doom"));

        System.out.println("Applying WeightCalculator...");
        com.narxoz.rpg.artifact.WeightCalculator weightCalc = new com.narxoz.rpg.artifact.WeightCalculator();
        globalInv.accept(weightCalc);
        System.out.println("Total global weight: " + weightCalc.getTotalWeight());

        System.out.println("\nApplying EnchantmentScanner...");
        com.narxoz.rpg.artifact.EnchantmentScanner enchantScanner = new com.narxoz.rpg.artifact.EnchantmentScanner();
        globalInv.accept(enchantScanner);
        System.out.println("Magical artifacts found: " + enchantScanner.getMagicalArtifactsFound());

        System.out.println("\nApplying CurseDetector...");
        com.narxoz.rpg.artifact.CurseDetector curseDetector = new com.narxoz.rpg.artifact.CurseDetector();
        globalInv.accept(curseDetector);
        System.out.println("Cursed artifacts found: " + curseDetector.getCursedArtifacts());

        // 3-6. Run the ChronomancerEngine demo sequence which handles memento snapshot/rewind.
        com.narxoz.rpg.vault.ChronomancerEngine engine = new com.narxoz.rpg.vault.ChronomancerEngine();
        com.narxoz.rpg.vault.VaultRunResult result = engine.runVault(java.util.Arrays.asList(hero1, hero2));

        System.out.println("\nFinal Result: " + result);
    }
}
