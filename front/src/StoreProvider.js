import React, { useReducer } from "react";
import  Store  from "./Store";
import reducer from './reducer';


const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, Store.initialState);

  return <Store.Provider value={{ state, dispatch }}>
    {children}
  </Store.Provider>
}

export default  StoreProvider
