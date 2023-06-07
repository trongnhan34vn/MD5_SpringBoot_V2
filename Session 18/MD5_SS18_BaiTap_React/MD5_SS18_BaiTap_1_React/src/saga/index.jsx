import {all, takeLatest} from "redux-saga/effects"
import * as actionType from "../redux/const/actionType"
import * as locationSaga from "./locationSaga"
import * as userSaga from "./userSaga"


export const rootSaga = function* () {
    yield all(
        [
            takeLatest(actionType.REQUEST_FIND_LOCATION, locationSaga.requestLocations),
            takeLatest(actionType.REGISTER, userSaga.postUser),
            takeLatest(actionType.LOGIN, userSaga.login)
        ]
    )
}