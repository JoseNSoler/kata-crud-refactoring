package co.com.sofka.crud.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ToDoListObject {
    private Long id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    private Set<ToDoObject> items = new HashSet<>();



    public ToDoListObject(){
        super();
    }
    public ToDoListObject(Long id, String name, Set<ToDoObject> items) {
        this.id = id;
        this.name = name;
        this.items = items;
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

    public Set<ToDoObject> getItems() {
        return items;
    }

    public void setItems(Set<ToDoObject> items) {
        this.items = items;
    }
}
