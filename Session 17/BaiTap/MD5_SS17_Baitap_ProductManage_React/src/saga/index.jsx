import { all } from "redux-saga/effects"
import * as actionType from "../redux/const/actionType"
import * as productSaga from "./productSaga"
import { takeLatest } from "redux-saga/effects"

export const rootSaga = function* () {

    yield all([
        takeLatest(actionType.FIND_ALL, productSaga.getAllProducts),
        takeLatest(actionType.CREATE_PRODUCT, productSaga.createProducts),
        takeLatest(actionType.SELECT_PRODUCT, productSaga.selectProduct),
        takeLatest(actionType.DELETE_PRODUCT, productSaga.deleteProduct),
        takeLatest(actionType.UPDATE_PRODUCT, productSaga.updateProduct)
    ])
}