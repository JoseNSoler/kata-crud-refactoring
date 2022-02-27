package co.com.sofka.crud.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    private Set<ToDo> toDos;

/*
    public ToDoList() {
    }

    public ToDoList(String name, Set<ToDo> toDos) {
        this();
        this.name = name;
        this.toDos = toDos;
    }

    public ToDoList(Long id, String name, Set<ToDo> toDos) {
        this(name, toDos);
        this.id = id;
    }
*/
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

    public Set<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(Set<ToDo> toDos) {
        this.toDos = toDos;
    }
}
