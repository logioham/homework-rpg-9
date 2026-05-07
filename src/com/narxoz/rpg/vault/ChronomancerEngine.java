package com.narxoz.rpg.vault;

import com.narxoz.rpg.combatant.Hero;
import java.util.List;

/**
 * Orchestrates the Chronomancer's Vault demo run.
 */
public class ChronomancerEngine {

    /**
     * Runs the vault sequence for the supplied party.
     *
     * @param party the heroes entering the vault
     * @return a placeholder result in the scaffold
     */
    public VaultRunResult runVault(List<Hero> party) {
        int artifactsAppraised = 0;
        int mementosCreated = 0;
        int restoredCount = 0;

        com.narxoz.rpg.memento.Caretaker caretaker = new com.narxoz.rpg.memento.Caretaker();

        System.out.println("--- Vault Sequence Initiated ---");
        for (Hero hero : party) {
            System.out.println("\nHero " + hero.getName() + " approaches the vault.");

            // 1. Appraise inventory
            System.out.println("Appraising " + hero.getName() + "'s inventory...");
            com.narxoz.rpg.artifact.GoldAppraiser appraiser = new com.narxoz.rpg.artifact.GoldAppraiser();
            hero.getInventory().accept(appraiser);
            artifactsAppraised += hero.getInventory().size();
            System.out.println("Total gold value: " + appraiser.getTotalValue());

            // 2. Save snapshot
            System.out.println("Saving chronomantic snapshot of " + hero.getName() + "...");
            caretaker.save(hero.createMemento());
            mementosCreated++;

            // 3. Vault trap changes state
            System.out.println("A vault trap triggers! " + hero.getName() + " takes 50 damage and loses 100 gold.");
            hero.takeDamage(50);
            hero.spendGold(100);
            System.out.println("Current state: " + hero);

            // 4. Rewind state
            System.out.println("Rewinding time for " + hero.getName() + "...");
            hero.restoreFromMemento(caretaker.undo());
            restoredCount++;
            System.out.println("Restored state: " + hero);
        }

        System.out.println("\n--- Vault Sequence Complete ---");

        return new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);
    }
}
