package mainpkg.Rasel.CampManager.Goal3_CampRules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextArea;


public class CampRules implements Serializable {
    
    String newRule;
    
    ArrayList<String> rulesList = new ArrayList<>();

    public CampRules(String newRule) {
        this.newRule = newRule;
    }

    public String getNewRule() {
        return newRule;
    }

    public void setNewRule(String newRule) {
        this.newRule = newRule;
    }

    public ArrayList<String> getRulesList() {
        return rulesList;
    }

    public void setRulesList(ArrayList<String> rulesList) {
        this.rulesList = rulesList;
    }

    @Override
    public String toString() {
        return "CampRules{" + "newRule=" + newRule + ", rulesList=" + rulesList + '}';
    }

    
    public void addRule(){
        rulesList.add(newRule);
        saveRuleToFile();
        
    }
    
    private void saveRuleToFile() {
        
        File file = new File("src/File/rules.txt");

        try {
            FileWriter fw = new FileWriter(file, true);

            if (!file.exists()) {
                for (String rule : rulesList) {
                    fw.write(rule + "\n");
                }
            }

            fw.write(newRule + "\n");

            fw.close();

            System.out.println("Rule saved successfully to file.");
        } catch (IOException e) {
            System.out.println("Error saving rule to file: " + e.getMessage());
        }
    }
    
}
