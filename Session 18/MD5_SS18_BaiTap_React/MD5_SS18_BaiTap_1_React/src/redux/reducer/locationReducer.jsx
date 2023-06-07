import * as actionType from "../const/actionType";

const initState = [];
const listLocations = (state = initState, action) => {
    switch (action.type) {
        case actionType.GET_ALL_LOCATION:
            return action.payload;
        default:
            return state;
    }
}

export default listLocations