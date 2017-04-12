/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import edu.cad.entities.interfaces.IDatabaseEntity;

/**
 *
 * @author Олександр
 */
@Entity
@Table(name = "academic_group")
public class AcademicGroup implements IDatabaseEntity{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
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

    public AcademicGroup() {
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AcademicGroup other = (AcademicGroup) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }    
}
