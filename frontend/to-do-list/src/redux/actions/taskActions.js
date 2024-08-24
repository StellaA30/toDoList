import * as types from './actionTypes';

export function loadTasksSuccess(tasks){
    return { type: types.LOAD_TASKS_SUCCESS, payload: tasks }
}