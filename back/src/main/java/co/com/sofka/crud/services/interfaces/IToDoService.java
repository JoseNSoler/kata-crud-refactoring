package co.com.sofka.crud.services.interfaces;

import java.util.Optional;
import java.util.Set;

import co.com.sofka.crud.models.ToDo;
import co.com.sofka.crud.models.ToDoList;
import co.com.sofka.crud.models.ToDoListObject;
import co.com.sofka.crud.models.ToDoObject;

// Interface for services defining all possible methods
public interface IToDoService {
    Set<ToDoObject> getAllToDoListById(Long id);
    Iterable<ToDoListObject> getAllToDoList();

    ToDoListObject newListTodo(ToDoListObject toDoListModel);
    ToDoList addNewToDoByListId(Long listId, ToDoObject toDoObject);
    ToDoList modifyCurrToDoByListId(Long listId, ToDoObject toDoObject);

    Optional<ToDoListObject> deleteToDoList(Long id);
    Optional<ToDoObject> deleteToDo(Long id);


    ToDo modifyToDo(ToDoObject toDo);
    ToDoObject newToDo(ToDoObject toDoList, Long id);

    Set<ToDoObject> getAllToDoById();

    
}
