import * as types from '../actions/actionTypes';
import initialState from './initialState';

export default function taskReducer(state=initialState.tasks, action){
    switch(action){
        default:
            return state;

    }
}