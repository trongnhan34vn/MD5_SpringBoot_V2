import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { updateProduct } from '../../redux/action';
import { selectedProductSelector } from '../../redux/selector';

const EditModal = () => {
    const selectedProduct = useSelector(selectedProductSelector);
    const dispatch = useDispatch();
    const [inputVal, setInputVal] = useState({
        id: "",
        name: "",
        description: "",
        quantity: "",
        price: ""
    })

    const handleChange = (event) => {
        let key = event.target.name;
        let value = event.target.value;
        setInputVal({ ...inputVal, [key]: value });
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        dispatch(updateProduct(inputVal));
        setInputVal({
            id: "",
            name: "",
            description: "",
            quantity: "",
            price: ""
        })
    }

    useEffect(() => {
         selectedProduct && setInputVal({
            id: selectedProduct.id,
            name: selectedProduct.name,
            description: selectedProduct.description,
            quantity: selectedProduct.quantity,
            price: selectedProduct.price
        })
    },[selectedProduct])

    return (
        <div>
            <div id="editEmployeeModal" className="modal fade">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <form>
                            <div className="modal-header">
                                <h4 className="modal-title">Edit Employee</h4>
                                <button
                                    type="button"
                                    className="close"
                                    data-dismiss="modal"
                                    aria-hidden="true"
                                >
                                    ×
                                </button>
                            </div>
                            <div className="modal-body">
                                <div className="form-group">
                                    <label>Name</label>
                                    <input name='name' onChange={handleChange} value={inputVal.name} type="text" className="form-control" required />
                                </div>
                                <div className="form-group">
                                    <label>Description</label>
                                    <textarea name='description' onChange={handleChange}
                                        value={inputVal.description}
                                        className="form-control"
                                        required
                                    />
                                </div>
                                <div className="form-group">
                                    <label>Price</label>
                                    <input name='price' onChange={handleChange} value={inputVal.price} type="text" className="form-control" required />
                                </div>
                                <div className="form-group">
                                    <label>Quantity</label>
                                    <input name='quantity' onChange={handleChange} value={inputVal.quantity} type="text" className="form-control" required />
                                </div>
                            </div>
                            <div className="modal-footer">
                                <input
                                    type="button"
                                    className="btn btn-default"
                                    data-dismiss="modal"
                                    defaultValue="Cancel"
                                />
                                <input data-dismiss="modal" onClick={handleSubmit} type="submit" className="btn btn-info" defaultValue="Save" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default EditModal;
