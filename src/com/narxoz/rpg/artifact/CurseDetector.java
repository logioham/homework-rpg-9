package com.narxoz.rpg.artifact;

/**
 * Detects cursed artifacts.
 */
public class CurseDetector implements ArtifactVisitor {
    private int cursedArtifacts = 0;

    public int getCursedArtifacts() {
        return cursedArtifacts;
    }

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() < 0) {
            System.out.println("WARNING! Weapon is cursed: " + weapon.getName());
            cursedArtifacts++;
        } else {
            System.out.println("Weapon is safe: " + weapon.getName());
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() < 0) {
            System.out.println("WARNING! Poison detected in Potion: " + potion.getName());
            cursedArtifacts++;
        } else {
            System.out.println("Potion is safe: " + potion.getName());
        }
    }

    @Override
    public void visit(Scroll scroll) {
        if (scroll.getSpellName().toLowerCase().contains("curse")) {
            System.out.println("WARNING! Dark magic detected on Scroll: " + scroll.getName());
            cursedArtifacts++;
        } else {
            System.out.println("Scroll is safe: " + scroll.getName());
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() < 0) {
            System.out.println("WARNING! Ring is cursed: " + ring.getName());
            cursedArtifacts++;
        } else {
            System.out.println("Ring is safe: " + ring.getName());
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() < 0) {
            System.out.println("WARNING! Armor is cursed: " + armor.getName());
            cursedArtifacts++;
        } else {
            System.out.println("Armor is safe: " + armor.getName());
        }
    }
}
