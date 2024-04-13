/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal1_CampInfo;

/**
 *
 * @author synt4x_err0r
 */
public class CampCapacity {
    
    private int maxCapacity;
    private int currentOccupants;

    public CampCapacity(int maxCapacity, int currentOccupants) {
        this.maxCapacity = maxCapacity;
        this.currentOccupants = currentOccupants;
    }

    public int getCurrentOccupants() {
        return currentOccupants;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setCurrentOccupants(int currentOccupants) {
        this.currentOccupants = currentOccupants;
    }

    
    public boolean canAccommodate(int additionalOccupants) {
        return currentOccupants + additionalOccupants <= maxCapacity;
    }
    

    public void addOccupants(int occupantsToAdd) {
        if (canAccommodate(occupantsToAdd)) {
            currentOccupants += occupantsToAdd;
            System.out.println(occupantsToAdd + " occupants added successfully.");
        } else {
            System.out.println("Cannot accommodate " + occupantsToAdd + " occupants. Camp is at full capacity.");
        }
    
    }

    @Override
    public String toString() {
        return "CampCapacity{" + "maxCapacity=" + maxCapacity + ", currentOccupants=" + currentOccupants + '}';
    }
    
//    public static void main(String[] args) {
//        
//        CampCapacity capacityManager = new CampCapacity(500, 100);
//
//        // adding occupants to the camp
//        capacityManager.addOccupants(110); // Add 200 occupants
//        capacityManager.addOccupants(50); // Try to add 350 more occupants
//        
//    }
    
}
