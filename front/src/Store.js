import React, { useReducer, createContext } from 'react';

const initialState = {
    list: {
        elements: []
    },
    todo: {
        elements: [],
        item: {}
    }
};

const Store = createContext(initialState);

const StoreProvider = ({ children }) => {
    const [state, dispatch] = useReducer(reducer, Store.initialState);
  
    return <Store.Provider value={{ state, dispatch }}>
      {children}
    </Store.Provider>
  }
  
export default Store;





