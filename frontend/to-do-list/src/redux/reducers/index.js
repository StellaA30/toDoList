import { combineReducers } from "redux";
import users from "../reducers/userReducer";
import tasks from "../reducers/taskReducer";

const rootReducer = combineReducers({
    users,
    tasks
});

export default rootReducer;