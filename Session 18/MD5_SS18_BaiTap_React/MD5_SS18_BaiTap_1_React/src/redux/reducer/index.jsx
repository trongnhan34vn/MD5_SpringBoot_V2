import { combineReducers } from 'redux'
import listLocations from './locationReducer';
import loginDetails from './userReducer';

const rootReducer = combineReducers({
    loginDetails, listLocations
});

export default rootReducer;