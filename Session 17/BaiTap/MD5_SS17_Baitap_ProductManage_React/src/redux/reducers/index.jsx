import { combineReducers } from "redux";
import listProducts from "./listProductsReducer";
import selectedProduct from "./selectProductReducer";


const rootReducer = combineReducers({listProducts, selectedProduct})

export default rootReducer;