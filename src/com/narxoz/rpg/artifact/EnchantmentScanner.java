package com.narxoz.rpg.artifact;

/**
 * Scans artifacts for magical properties.
 */
public class EnchantmentScanner implements ArtifactVisitor {
    private int magicalArtifactsFound = 0;

    public int getMagicalArtifactsFound() {
        return magicalArtifactsFound;
    }

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() > 10) {
            System.out.println("Magical aura detected on Weapon: " + weapon.getName() + "!");
            magicalArtifactsFound++;
        } else {
            System.out.println("No strong magic on Weapon: " + weapon.getName() + ".");
        }
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Alchemical signature detected in Potion: " + potion.getName() + " (Healing: " + potion.getHealing() + ").");
        magicalArtifactsFound++;
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Arcane runes glow on Scroll: " + scroll.getName() + " [Spell: " + scroll.getSpellName() + "].");
        magicalArtifactsFound++;
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() > 0) {
            System.out.println("Enchantment detected on Ring: " + ring.getName() + " (Bonus: +" + ring.getMagicBonus() + ").");
            magicalArtifactsFound++;
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() > 10) {
            System.out.println("Protective ward detected on Armor: " + armor.getName() + "!");
            magicalArtifactsFound++;
        } else {
            System.out.println("No strong magic on Armor: " + armor.getName() + ".");
        }
    }
}
