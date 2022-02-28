package co.com.sofka.crud.controllers;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import co.com.sofka.crud.exception.CustomErrorException;
import co.com.sofka.crud.models.ToDo;
import co.com.sofka.crud.models.ToDoList;
import co.com.sofka.crud.models.ToDoListObject;
import co.com.sofka.crud.models.ToDoObject;
import co.com.sofka.crud.services.ToDoService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ToDoController {

    // Service component for to do list
    @Autowired
    private ToDoService service;
/*
    @GetMapping(value = "api/todos")
    public Iterable<ToDo> list(){
        return service.list();
    }
*/

    // GET current ToDo Lists on DB
    @GetMapping(value = "/todolist")
    public Iterable<ToDoListObject> getAllToDoList(){
        return service.getAllToDoList();
    }

    // GET current ToDo Lists by ID on DB
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/{listId}/todo")
    public Set<ToDoObject> getAllToDoById(){
        return service.getAllToDoById();
    }


    // GET current ToDo Lists by ID on DB
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/{listId}/todolist")
    public Set<ToDoObject> getAllToDoListBtId(@PathVariable("listId") Long listId){
        return service.getAllToDoListById(listId);
    }

    // POST new List of to do's
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/todolist")
    public ToDoListObject newListToDo(@RequestBody @Valid ToDoListObject toDoList, BindingResult errors){
        if(errors.hasErrors()){
            // throw exception error if encounter on validation process
            String errorCustom = CustomErrorException.getValidationMessage(errors.getFieldError());
            throw new CustomErrorException(HttpStatus.BAD_REQUEST, errorCustom);
        } else return service.newListTodo(toDoList);
    }

    // POST new ToDo on existing ToDo List on DB
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/{listId}/todolist")
    public ToDoList addNewToDoByListId(@PathVariable("listId") Long listId, @RequestBody @Valid ToDoObject toDoObject, BindingResult errors){
        if(errors.hasErrors()){
            // throw exception error if encounter on validation process
            String errorCustom = CustomErrorException.getValidationMessage(errors.getFieldError());
            throw new CustomErrorException(HttpStatus.I_AM_A_TEAPOT, errorCustom);
        } else return service.addNewToDoByListId(listId, toDoObject);
    }

    @PostMapping(value = "/{listId}/todo")
    public ToDoObject newToDo(@PathVariable("listId") Long listId, @RequestBody @Valid ToDoObject toDoObject, BindingResult errors){
        if(errors.hasErrors()){
            // throw exception error if encounter on validation process
            String errorCustom = CustomErrorException.getValidationMessage(errors.getFieldError());
            throw new CustomErrorException(HttpStatus.BAD_REQUEST, errorCustom);
        } else return service.newToDo(toDoObject, listId);
    }

    // PUT modify element toDo from ID LisToDo
    
    @PutMapping(value = "/todo")
    public ToDo modifyToDo(@RequestBody @Valid ToDoObject toDoObject, BindingResult errors){
        if(errors.hasErrors()){
            // throw exception error if encounter on validation process
            String errorCustom = CustomErrorException.getValidationMessage(errors.getFieldError());
            throw new CustomErrorException(HttpStatus.I_AM_A_TEAPOT, errorCustom);
        } else return service.modifyToDo(toDoObject);
    }


    @CrossOrigin(origins = "*")
    @PutMapping(value = "/{listId}/todo")
    public ToDoList modifyCurrToDoByListId(@PathVariable("listId") Long listId, @RequestBody @Valid ToDoObject toDoObject, BindingResult errors){
        if(errors.hasErrors()){
            // throw exception error if encounter on validation process
            String errorCustom = CustomErrorException.getValidationMessage(errors.getFieldError());
            throw new CustomErrorException(HttpStatus.NOT_FOUND, errorCustom);
        } else return service.modifyCurrToDoByListId(listId, toDoObject);
    }


    // DELETE ToDo List from DB

    @DeleteMapping(value = "/{ListId}/todolist")
    public Optional<ToDoListObject> deleteToDoList(@PathVariable("ListId") Long id){
        return service.deleteToDoList(id);
    }

    // DELETE ToDo  from DB

    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/{toDoId}/todo")
    public Optional<ToDoObject> deleteToDo(@PathVariable("toDoId") Long id){
        return service.deleteToDo(id);
    }




    /*
    
    @PostMapping(value = "api/todo")
    public ToDo save(@RequestBody ToDo todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public ToDo update(@RequestBody ToDo todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public ToDo get(@PathVariable("id") Long id){
        return service.get(id);
    }
    */

}
