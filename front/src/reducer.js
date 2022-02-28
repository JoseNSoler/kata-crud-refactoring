import listReducer from "./reducer/reducer";

const merge = { ...listReducer() };

const  reducer = (state, action) => {
    console.log("dispatched => ", action.type)
    if (merge[action.type]) {
        return merge[action.type][state, action]
    } else {
        return state;
    }
  }

export default reducer;
  