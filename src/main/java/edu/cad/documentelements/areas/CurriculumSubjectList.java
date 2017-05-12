package edu.cad.documentelements.areas;

import edu.cad.daos.HibernateDAO;
import edu.cad.daos.IDAO;
import edu.cad.documentelements.columns.semestercolumns.SemesterColumn;
import edu.cad.documentelements.columns.semestercolumns.SemesterLabsColumn;
import edu.cad.documentelements.columns.semestercolumns.SemesterLectionsColumn;
import edu.cad.documentelements.columns.semestercolumns.SemesterPracticesColumn;
import edu.cad.entities.ControlDictionary;
import edu.cad.entities.Curriculum;
import edu.cad.entities.SubjectDictionary;
import java.util.HashSet;
import java.util.Set;
import org.apache.poi.ss.usermodel.Sheet;

public class CurriculumSubjectList extends AbstractSubjectList {
    
    public CurriculumSubjectList(Sheet sheet, int startRow) {
        super(sheet, startRow);
    }
    
    @Override
    public void fill(Curriculum curriculum) {
        super.fill(curriculum, SubjectDictionary::getCurriculumSection);
    }

    @Override
    protected Set<ControlDictionary> getControls() {
        IDAO<ControlDictionary> controlDAO = new HibernateDAO<>(ControlDictionary.class);
        Set<ControlDictionary> controls = new HashSet<>();
        
        controls.add(controlDAO.get(1));
        controls.add(controlDAO.get(2));
        controls.add(controlDAO.get(4));
        controls.add(controlDAO.get(5));
        
        return controls;
    }

    @Override
    protected void addSemesterColumns() {
        int currentColumn = 0;
        
        while(true){
            SemesterColumn column = new SemesterColumn(sheet, currentColumn);
            
            if(column.getColumnNumber() < 0)
                break;
            
            columns.add(column);
            
            currentColumn++;
        }
    }
}