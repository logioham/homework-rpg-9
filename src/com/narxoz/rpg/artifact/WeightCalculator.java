package com.narxoz.rpg.artifact;

/**
 * Calculates the total weight of artifacts.
 */
public class WeightCalculator implements ArtifactVisitor {
    private int totalWeight = 0;

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public void visit(Weapon weapon) {
        System.out.println("Weighing Weapon: " + weapon.getName() + " at " + weapon.getWeight() + " lbs.");
        totalWeight += weapon.getWeight();
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Weighing Potion: " + potion.getName() + " at " + potion.getWeight() + " lbs.");
        totalWeight += potion.getWeight();
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Weighing Scroll: " + scroll.getName() + " at " + scroll.getWeight() + " lbs.");
        totalWeight += scroll.getWeight();
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("Weighing Ring: " + ring.getName() + " at " + ring.getWeight() + " lbs.");
        totalWeight += ring.getWeight();
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("Weighing Armor: " + armor.getName() + " at " + armor.getWeight() + " lbs.");
        totalWeight += armor.getWeight();
    }
}
