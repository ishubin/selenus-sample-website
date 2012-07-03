package models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

@Entity
public class Section extends GenericModel {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    public Long id;
    public String name;
    
    public Section(String name) {
        this.name = name;
    }
}
