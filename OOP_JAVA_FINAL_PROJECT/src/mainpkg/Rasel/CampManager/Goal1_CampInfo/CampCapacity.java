package mainpkg.Rasel.CampManager.Goal1_CampInfo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import mainpkg.Rasel.Refugee.Refugee;

/**
 *
 * @author synt4x_err0r
 */
public class CampCapacity {
    
    private int maxCapacity;
    private int currentOccupants;
    float[] totalRefugee = new float[2];
    
    int totalRefugeeCount = 0;

    public CampCapacity(int maxCapacity, int currentOccupants) {
        this.maxCapacity = maxCapacity;
        this.currentOccupants = currentOccupants;
    }

    public int getCurrentOccupants() {
        return currentOccupants+refugeeCount();
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
        return currentOccupants + additionalOccupants + refugeeCount() <= maxCapacity;
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
    

    public float[] refugeePercentage(){
        try {
            FileInputStream fileIn = new FileInputStream("src/File/RefugeeInfo.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            ArrayList<Refugee> refugeeList = new ArrayList<>();
            Refugee r;

            while (true) {
                try {
                    r = (Refugee) objectIn.readObject();
                    refugeeList.add(r);
                } catch (EOFException e) {
                    break;
                }
            }
            
            int maleCount = 0;
            int femaleCount = 0;

            for (Refugee refugee : refugeeList) {
                if (refugee.getGender().equals("Male")) {
                    maleCount++;
                } else if (refugee.getGender().equalsIgnoreCase("Female")) {
                    femaleCount++;
                }
            }
            
            objectIn.close();
            
            int totalCount;
            totalCount = maleCount + femaleCount;
            float malePercentage = 0.0f;
            float femalePercentage = 0.0f;
            
            malePercentage = maleCount / (float) totalCount * 100;
            femalePercentage = femaleCount / (float) totalCount * 100;

            System.out.println("Male Count: " + maleCount);
            System.out.println("Female Count: " + femaleCount);
            System.out.println("Male Percentage: " + malePercentage + "%");
            System.out.println("Female Percentage: " + femalePercentage + "%");
            
            totalRefugee[0] = malePercentage;
            totalRefugee[1] = femalePercentage;
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
            e.printStackTrace();
        }
        return totalRefugee;
    }
    
    
    private int refugeeCount(){
        try {
            FileInputStream fileIn = new FileInputStream("src/File/RefugeeInfo.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            ArrayList<Refugee> refugeeList = new ArrayList<>();
            Refugee r;

            while (true) {
                try {
                    r = (Refugee) objectIn.readObject();
                    refugeeList.add(r);
                } catch (EOFException e) {
                    break;
                }
            }
            
            
            for (Refugee refugee : refugeeList) {
                totalRefugeeCount++;
            }
            
            objectIn.close();
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
            e.printStackTrace();
        }
        return totalRefugeeCount;
        
    }
    
}
