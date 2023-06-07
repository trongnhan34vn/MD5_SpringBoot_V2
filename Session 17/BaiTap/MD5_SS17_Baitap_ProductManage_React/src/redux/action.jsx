import * as actionType from "./const/actionType"

export const requestAllProducts = () => {
    return {
        type: actionType.FIND_ALL
    }
}

export const getAllProducts = (data) => {
    return {
        type: actionType.GET_ALL_PRODUCTS,
        payload: data
    }
}

export const createProduct = (data) => {
    return {
        type: actionType.CREATE_PRODUCT,
        payload: data
    }
}

export const selectProduct = (data) => {
    return {
        type: actionType.SELECT_PRODUCT,
        payload: data
    }
}

export const selectedProduct = (data) => {
    return {
        type: actionType.SELECTED_PRODUCT,
        payload: data
    }
}

export const deleteProduct = (data) => {
    return {
        type: actionType.DELETE_PRODUCT,
        payload: data
    }
}

export const updateProduct = (data) => {
    return {
        type: actionType.UPDATE_PRODUCT,
        payload: data
    }
}