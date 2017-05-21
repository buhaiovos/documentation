package edu.cad.documentelements.k3columns;

import edu.cad.entities.ControlDictionary;
import edu.cad.entities.Subject;

public class ControlK3Column extends AbstractK3Column{
    private final ControlDictionary control;
    
    public ControlK3Column(int columnNumber, ControlDictionary control) {
        super(columnNumber);
        this.control = control;
    }

    @Override
    public String getValue(Subject subject) {
        if(control.getId() == 5){
            if(subject.hasCourseWork()){
                return "3";
            }
        }
        
        if(subject.hasControlOfType(control)){
            return "1";
        }
        
        return "";
    }
    
}