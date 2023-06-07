import * as actionType from "../const/actionType";

const initState = null;

const loginDetails = (state = initState, action) => {
    switch (action.type) {
        case actionType.GET_LOGIN_DETAILS:
            return {...action.payload};
        default:
            return state;
    }
}

export default loginDetails;