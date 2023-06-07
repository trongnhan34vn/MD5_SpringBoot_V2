import * as actionType from "../const/actionType";

const initState = [];
const listProducts = (state = initState, action) => {
    switch (action.type) {
        case actionType.GET_ALL_PRODUCTS:
            return action.payload;
        default:
            return state;
    }
}

export default listProducts;