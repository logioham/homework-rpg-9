package com.narxoz.rpg.artifact;

/**
 * Appraises the gold value of artifacts.
 */
public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue = 0;

    public int getTotalValue() {
        return totalValue;
    }

    @Override
    public void visit(Weapon weapon) {
        System.out.println("Appraising Weapon: " + weapon.getName() + " for " + weapon.getValue() + " gold.");
        totalValue += weapon.getValue();
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Appraising Potion: " + potion.getName() + " for " + potion.getValue() + " gold.");
        totalValue += potion.getValue();
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Appraising Scroll: " + scroll.getName() + " for " + scroll.getValue() + " gold.");
        totalValue += scroll.getValue();
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("Appraising Ring: " + ring.getName() + " for " + ring.getValue() + " gold.");
        totalValue += ring.getValue();
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("Appraising Armor: " + armor.getName() + " for " + armor.getValue() + " gold.");
        totalValue += armor.getValue();
    }
}
