const HOST_API = "http://localhost:8080/api/"

export default {
    // Get all list on DB
    findAll: async () => {
        return await fetch(HOST_API + "todolist")
            .catch(error => console.log("__ERROR: ", error))
    },
    // Save current list on DB
    save: async (request) => {
        return await fetch(HOST_API + "todolist", {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                "Content-Type" : "application/json"
            }
        })
        .catch(error => console.log("__ERROR: ", error))
    },
    // Deletes List on DB
    delete: async (listId) => {
        return await fetch(HOST_API + listId + "/todoList", {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        })
        .catch(error => console.log("__ERROR: ", error));
    }
}