export const actionType = {
    LIST_CREATE: "list.LIST_CREATE",
    LIST_FIND: "list.LIST_FIND",
    LIST_DELETE: "list.LIST_DELETED"
};

export default {
    save: (item) => ({type: actionType.LIST_CREATE, item}),
    find: (item) => ({type: actionType.LIST_FIND, item}),
    delete: (item) => ({type: actionType.LIST_DELETE, item})
};