package edu.cad.entities;

import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "cycle")
public class Section {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "denotation")
    private String denotation;
    
    @Column(name = "is_optional", columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isOptional;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cycle")
    private Cycle cycle;

    public Section() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final Section other = (Section) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
