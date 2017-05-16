package edu.cad.entities;

import javax.persistence.*;
import edu.cad.entities.interfaces.IDatabaseEntity;

@Entity
@Table(name = "academic_group")
public class AcademicGroup implements IDatabaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "cipher")
    private String cipher;
    
    @Column(name = "budgetary_students")
    private int budgetaryStudents;
    
    @Column(name = "contract_students")
    private int contractStudents;
    
    @Column(name = "start_year")
    private int startYear;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_specialization")
    private Specialization specialization;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_qualification")
    private Qualification qualification;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_education_form")
    private EducationForm educationForm;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_workplan")
    private Curriculum workplan;

    public AcademicGroup() {
    }

    public AcademicGroup(int id, String cipher, int budgetaryStudents, 
            int contractStudents, int startYear, Specialization specialization, 
            Qualification qualification, EducationForm educationForm,
            Curriculum workplan) {
        this.id = id;
        this.cipher = cipher;
        this.budgetaryStudents = budgetaryStudents;
        this.contractStudents = contractStudents;
        this.startYear = startYear;
        this.specialization = specialization;
        this.qualification = qualification;
        this.educationForm = educationForm;
        this.workplan = workplan;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public int getBudgetaryStudents() {
        return budgetaryStudents;
    }

    public void setBudgetaryStudents(int budgetaryStudents) {
        this.budgetaryStudents = budgetaryStudents;
    }

    public int getContractStudents() {
        return contractStudents;
    }

    public void setContractStudents(int contractStudents) {
        this.contractStudents = contractStudents;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public EducationForm getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }

    public Curriculum getWorkplan() {
        return workplan;
    }

    public void setWorkplan(Curriculum workplan) {
        this.workplan = workplan;
    }
    
    public int getTotalStudents() {
        return budgetaryStudents + contractStudents;
    }
    
    public boolean isBudgetary(){
        if(budgetaryStudents > 0)
            return true;
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        /*if (getClass() != obj.getClass()) {
            return false;
        }*/
        final AcademicGroup other = (AcademicGroup) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return true;
    }    
}
