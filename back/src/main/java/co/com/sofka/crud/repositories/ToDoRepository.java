package co.com.sofka.crud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sofka.crud.models.ToDo;


@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

}
