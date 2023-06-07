import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { createProduct } from '../../redux/action';

const AddModal = () => {

    const dispatch = useDispatch();

    const [inputValue, setInputValue] = useState({
        name: "",
        description: "",
        quantity: "",
        price: ""
    })

    const handleChange = (event) => {
        let key = event.target.name;
        let value = event.target.value
        setInputValue({ ...inputValue, [key]: value })
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        dispatch(createProduct(inputValue));
        setInputValue({
            name: "",
            description: "",
            quantity: "",
            price: ""
        })
    }

    return (
        <div>
            <div id="addEmployeeModal" className="modal fade">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <form>
                            <div className="modal-header">
                                <h4 className="modal-title">Add Employee</h4>
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
                                    <input name='name' onChange={handleChange} value={inputValue.name} type="text" className="form-control" required />
                                </div>

                                <div className="form-group">
                                    <label>Description</label>
                                    <textarea name='description' onChange={handleChange} value={inputValue.description}
                                        className="form-control"
                                        required
                                    />
                                </div>
                                <div className="form-group">
                                    <label>Quantity</label>
                                    <input name='quantity' onChange={handleChange} value={inputValue.quantity} type="text" className="form-control" required />
                                </div>
                                <div className="form-group">
                                    <label>Price</label>
                                    <input name='price' onChange={handleChange} value={inputValue.price} type="text" className="form-control" required />
                                </div>
                            </div>
                            <div className="modal-footer">
                                <input
                                    type="button"
                                    className="btn btn-default"
                                    data-dismiss="modal"
                                    defaultValue="Cancel"
                                />
                                <input
                                    type="submit"
                                    className="btn btn-success"
                                    defaultValue="Add"
                                    data-dismiss="modal"
                                    onClick={handleSubmit}
                                />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AddModal;
