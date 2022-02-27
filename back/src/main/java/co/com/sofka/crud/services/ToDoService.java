package co.com.sofka.crud.services;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.com.sofka.crud.exception.CustomErrorException;
import co.com.sofka.crud.models.ToDo;
import co.com.sofka.crud.models.ToDoList;
import co.com.sofka.crud.models.ToDoListObject;
import co.com.sofka.crud.models.ToDoObject;
import co.com.sofka.crud.repositories.ToDoListRepository;
import co.com.sofka.crud.repositories.ToDoRepository;
import co.com.sofka.crud.services.interfaces.IToDoService;

@Service
public class ToDoService implements IToDoService {

    private ToDoListRepository toDoListRepository;
    private ToDoRepository toDoRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ToDoService(ToDoListRepository toDoListRepository, ToDoRepository toDoRespository, ModelMapper modelMapper) {
        this.toDoListRepository = toDoListRepository;
        this.toDoRepository = toDoRespository;
        this.modelMapper = modelMapper;
    }

    // GET all current to do lists on DB
    public Iterable<ToDoListObject> getAllToDoList() {
        return StreamSupport
                .stream(toDoListRepository.findAll().spliterator(), false)
                .map(toDoList -> {
                    var listDto = toDoList.getToDos()
                            .stream()
                            .map(item -> new ToDoObject(item.getId(), item.getName(), item.isCompleted(),
                                    toDoList.getId()))
                            .collect(Collectors.toSet());
                    return new ToDoListObject(toDoList.getId(), toDoList.getName(), listDto);
                })
                .collect(Collectors.toSet());
    }

    // GET ListTODO by id
    @Override
    public Set<ToDoObject> getAllToDoListById(Long id) {
        return toDoListRepository.findById(id).
        orElseThrow(() -> new CustomErrorException(HttpStatus.NOT_FOUND,
            String.format("_ERR: Role con ID=%s no fue posible encontrar en la Base de Datos", id)))
        .getToDos()
        .stream()
        .map(item -> new ToDoObject(item.getId(), item.getName(), item.isCompleted(), id))
        .collect(Collectors.toSet());
    }

    // Create new List ToDo tasks
    public ToDoListObject newListTodo(ToDoListObject toDoListModel) {
        try {
            ToDoList toDoListEntity = modelMapper.map(toDoListModel, ToDoList.class);

            var id = toDoListRepository.save(toDoListEntity).getId();
            toDoListModel.setId(id);
            return toDoListModel;
        } catch (Exception e) {
            throw new CustomErrorException(
                    HttpStatus.I_AM_A_TEAPOT,
                    e.getMessage());
        }
    }

    // Create Add ToDo actions to list with id
    public ToDoList addNewToDoByListId(Long listId, ToDoObject toDoObject) {
        Optional<ToDoList> OptoDoListUpdate = toDoListRepository.findById(listId);

        try {
            if (OptoDoListUpdate.isEmpty())
                throw new CustomErrorException(HttpStatus.NOT_FOUND,
                        String.format(
                                "_ERR: Lista To Do con ID=%s no fue posible encontrar y modificar en la Base de Datos",
                                listId));
            else {
                // Create new To do based on use req
                ToDo newToDo = modelMapper.map(toDoObject, ToDo.class);

                // Convert ooptional to real object
                ToDoList toDoListUpdate = OptoDoListUpdate.get();

                // Get to Do set on current To Do list object
                Set<ToDo> newList = toDoListUpdate.getToDos();
                if (newList == null) {
                    newList = new HashSet<ToDo>();
                }

                newList.add(newToDo);

                toDoListUpdate.setToDos(newList);

                var listUpdated = toDoListRepository.save(toDoListUpdate);
                System.out.println("///////////////////////////////////////");

                return toDoListUpdate;
            }
        } catch (Exception e) {
            throw new CustomErrorException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage(), e.getStackTrace());
        }
    }

    // PUT object on id List
    public ToDoList modifyCurrToDoByListId(Long listId, ToDoObject toDoObject) {
        Optional<ToDoList> OptoDoListUpdate = toDoListRepository.findById(listId);

        try {
            if (OptoDoListUpdate.isEmpty())
                throw new CustomErrorException(HttpStatus.NOT_FOUND,
                        String.format(
                                "_ERR: Lista To Do con ID=%s no fue posible encontrar y modificar en la Base de Datos",
                                listId));
            else {
                ToDoList doListUpdate = OptoDoListUpdate.get();
                for(var toDoItem : doListUpdate.getToDos()){
                    if (toDoItem.getId().equals(toDoObject.getId())){
                        System.out.println("asdassssssssssssssss");
                        toDoItem.setCompleted(toDoObject.isCompleted());
                        toDoItem.setName(toDoObject.getName());
                        toDoItem.setId(toDoObject.getId());
                    }
                }

                toDoListRepository.save(doListUpdate);

                return doListUpdate;
            }
                   
        } catch (Exception e) {
            throw new CustomErrorException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage(), e.getStackTrace());
        }
    }

    // DELETE To Do list
    @Override
    public Optional<ToDoListObject> deleteToDoList(Long id) {
        try {
            Optional<ToDoList> oToDoList = toDoListRepository.findById(id);
            if (oToDoList.isEmpty())
                throw new CustomErrorException(HttpStatus.NOT_FOUND,
                        String.format(
                                "_ERR: To Do lista con ID=%s no fue posible encontrar y eliminar en la Base de Datos",
                                id));
            else {
                toDoListRepository.deleteById(id);
                ToDoListObject toDoListEntity = modelMapper.map(oToDoList.get(), ToDoListObject.class);
                toDoListEntity.setName("DELETED -->" + toDoListEntity.getName());
                return Optional.of(toDoListEntity);
            }
        } catch (Exception e) {
            // Default exception
            throw new CustomErrorException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage());
        }
    }


    // DELETE To Do list
    @Override
    public Optional<ToDoObject> deleteToDo(Long id) {
        try {
            Optional<ToDo> oToDo = toDoRepository.findById(id);
            if (oToDo.isEmpty())
                throw new CustomErrorException(HttpStatus.NOT_FOUND,
                        String.format(
                                "_ERR: To Do lista con ID=%s no fue posible encontrar y eliminar en la Base de Datos",
                                id));
            else {
                
                toDoRepository.deleteById(id);
                ToDoObject toDoEntity = modelMapper.map(oToDo.get(), ToDoObject.class);
                toDoEntity.setName("DELETED -->" + toDoEntity.getName());
                return Optional.of(toDoEntity);
            }
        } catch (Exception e) {
            // Default exception
            throw new CustomErrorException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage());
        }
    }

    /*
     * public Iterable<ToDo> list() {
     * return repository.findAll();
     * }
     * 
     * public ToDo save(ToDo todo) {
     * return repository.save(todo);
     * }
     * 
     * public void delete(Long id) {
     * repository.delete(get(id));
     * }
     * 
     * public ToDo get(Long id) {
     * return repository.findById(id).orElseThrow();
     * }
     */

}
