import * as actionType from "./const/actionType"

export const findAllLocation = () => {
    return {
        type: actionType.REQUEST_FIND_LOCATION
    }
}

export const getAllLocation = (data) => {
    return {
        type: actionType.GET_ALL_LOCATION,
        payload: data
    }
}

export const register = (data) => {
    return {
        type: actionType.REGISTER,
        payload: data
    }
}

export const login = (data) => {
    return {
        type: actionType.LOGIN,
        payload: data
    }
}

export const getLoginDetails = (data) => {
    return {
        type: actionType.GET_LOGIN_DETAILS,
        payload: data
    }
}