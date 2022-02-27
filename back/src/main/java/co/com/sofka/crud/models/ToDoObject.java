package co.com.sofka.crud.models;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ToDoObject {
    
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    private boolean completed;
    private Long groupListId;


    public ToDoObject() {
        super();
    }

    public ToDoObject(String name, boolean completed, Long groupListId) {
        this();
        this.name = name;
        this.completed = completed;
        this.groupListId = groupListId;
    }

    public ToDoObject(Long id, String name, boolean completed, Long groupListId) {
        this(name, completed, groupListId);
        this.id = id;
    }



    

    @Override
    public String toString() {
        return "ToDoObject [completed=" + completed + ", id=" + id + ", listId=" + groupListId + ", name=" + name + "]";
    }





    public Long getListId() {
        return groupListId;
    }


    public void setListId(Long groupListId) {
        this.groupListId = groupListId;
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
