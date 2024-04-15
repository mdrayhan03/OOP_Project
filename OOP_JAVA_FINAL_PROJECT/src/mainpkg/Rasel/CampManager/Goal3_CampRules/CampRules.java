package mainpkg.Rasel.CampManager.Goal3_CampRules;

import java.io.Serializable;


public class CampRules implements Serializable {
    
    String newRule;

    public CampRules(String newRule) {
        this.newRule = newRule;
    }

    public String getNewRule() {
        return newRule;
    }

    public void setNewRule(String newRule) {
        this.newRule = newRule;
    }


    @Override
    public String toString() {
        return newRule + "\n";
    }
    
}
