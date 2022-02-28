  /*


import React, { useContext, useState, useRef } from 'react';
import consumer from "./consumer";
import events from "./events";
import Store from "../Store";


export default () => {
    const formRef = useRef(null);
    const { dispatch, state: { todo } } = useContext(Store);
    const item = todo.item;
    const [state, setState] = useState(item);
  
    const onAdd = (event) => {
      event.preventDefault();
  
      consumer.save({ name: state.name, id: null })
        .then((response) => {
            if(response.ok) {
                response.json().then((newList) => {
                    dispatch(events.save(newList));
                    formRef.current.reset();
                })
            }
        });
    }

    const onEdit = (event) => {
      event.preventDefault();
  
      const request = {
        name: state.name,
        id: item.id,
        isCompleted: item.isCompleted
      };
  
  
      fetch(HOST_API + "/todolist", {
        method: "PUT",
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(response => response.json())
        .then((todo) => {
          dispatch({ type: "update-item", item: todo });
          setState({ name: "" });
          formRef.current.reset();
        });
    }
   
    return <form ref={formRef}>
      <input
        type="text"
        name="name"
        placeholder="¿Qué piensas hacer hoy?"
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value })
        }}  ></input>
   
      <button onClick={onAdd}>Crear</button>
    </form>
  }

   */  