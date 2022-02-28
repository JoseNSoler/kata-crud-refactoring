// Reducer to perform certain action based on actionType
import { actionType } from "../listToDo/events";

export default () => {
    const action = {};

    action[actionType.LIST_FIND] = (state, action) => {
        return { ...state, list: { elements: action.list } }
    };

    action[actionType.LIST_CREATE] = (state, action) => {
        const list = state.list.elements;
        list.push(action.item);
        return { ...state, list: { elements: list } }
    };

    action[actionType.LIST_DELETE] = (state, action) => {
        const list = state.list.elements.filter((element) => {
            return element.id !== action.listId;
        });
        return { ...state, list: { elements: list } }
    }

    return action;

}