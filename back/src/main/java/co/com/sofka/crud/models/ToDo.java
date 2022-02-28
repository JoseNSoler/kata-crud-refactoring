package co.com.sofka.crud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String name;

    private boolean completed;



    /*
    public ToDo(Long id, String name, boolean completed, Long groupListId) {
        this(name, completed, groupListId);
        this.id = id;
    }
    
    public ToDo(String name, boolean completed, Long groupListId) {
        this();
        this.name = name;
        this.completed = completed;
        this.groupListId = groupListId;
    }

    public ToDo() {
    }
    */

    

    

    @Override
    public String toString() {
        return "ToDo [completed=" + completed + ", id=" + id + ", name=" + name + "]";
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
