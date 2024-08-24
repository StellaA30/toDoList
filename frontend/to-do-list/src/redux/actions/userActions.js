import * as types from './actionTypes';
import { USERS_URL } from '../../api/apiUtils';

export function loadUsersSuccess(users){
    return { type: types.LOAD_USERS_SUCCESS, payload: users};
}


export const fetchUserData = () => {
    return async (dispatch) => {
        try {
            const response = await fetch(USERS_URL);
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`)
            }
            const data = await response.json();
            dispatch(loadUsersSuccess(data));
        } catch(error) {
            console.error('API call failed' + error);
            throw error;
        }
    }
}

// export const fetchUserData = () => {
//     return async (dispatch) => {
//         try {
//             const response = await fetch("http://localhost:8080/users");
//             if (!response.ok) {
//                 throw new Error(`HTTP error! status: ${response.status}`);
//             }
//             const data = await response.json();
//             dispatch(loadUsersSuccess(data));
//         } catch (error) {
//             console.error('API call failed:', error.message);
//             throw error;
//         }
//     }
// }