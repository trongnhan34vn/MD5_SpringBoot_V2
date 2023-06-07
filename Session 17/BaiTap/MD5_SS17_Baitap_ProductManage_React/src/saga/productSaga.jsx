import * as productService from "../api/productService"
import {call, put} from "redux-saga/effects"
import * as actions from "../redux/action";


export const getAllProducts = function* (){
    try {
        let listProducts = yield call(productService.FIND_ALL);
        yield put(actions.getAllProducts(listProducts));
    } catch (error) {
        console.log(error);
    }
}

export const createProducts = function* (action){
    try {
        yield call(productService.CREATE_PRODUCT, action.payload);
        yield getAllProducts()
    } catch (error) {
        console.log(error);
    }
}

export const selectProduct = function* (action) {
    try {
        let product = yield call(productService.FIND_BY_ID, action.payload);
        yield put(actions.selectedProduct(product))
    } catch(error) {
        console.log(error);
    }
}

export const deleteProduct = function* (action) {
    try {
        yield call(productService.DELETE, action.payload);
        yield getAllProducts();
    } catch(error) {
        console.log(error);
    }
}

export const updateProduct = function* (action) {
    try {
        yield call(productService.UPDATE, action.payload);
        yield getAllProducts();
    } catch(error) {
        console.log(error);
    }
}