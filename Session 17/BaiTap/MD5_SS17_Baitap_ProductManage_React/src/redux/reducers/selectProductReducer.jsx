import * as actionType from "../const/actionType"

const initState = null
const selectedProduct = (state = initState, action) => {
    switch (action.type) {
        case actionType.SELECTED_PRODUCT:
            return {...action.payload};
        default:
            return state;
    }
}

export default selectedProduct;