import {call, put} from "redux-saga/effects"
import * as locationService from "../api/locationService"
import { getAllLocation } from "../redux/actions";



export const requestLocations = function* () {
    try {
        let listLocation = yield call(locationService.FIND_ALL_LOCATION);
        yield put(getAllLocation(listLocation));
    } catch (error) {
        
    }
}