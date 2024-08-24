import * as types from './actionTypes';

export function loadUsersSuccess(users){
    return { type: types.LOAD_USERS_SUCCESS, payload: users};
}