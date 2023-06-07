import * as userService from "../api/userService"
import {call, put} from "redux-saga/effects"
import { getLoginDetails } from "../redux/actions"


export const postUser = function* (action) {
    try {
        yield call(userService.REGISTER, action.payload)
    } catch (error) {
        console.log(error)
    }
}

export const login = function* (action) {
    try {
        let loginDetails = yield call(userService.LOGIN, action.payload);
        yield put(getLoginDetails(loginDetails));
    } catch (error) {
        console.log(error)
    }
}