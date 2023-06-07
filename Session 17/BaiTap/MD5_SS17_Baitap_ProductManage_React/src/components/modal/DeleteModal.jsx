import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { deleteProduct } from '../../redux/action';
import { selectedProductSelector } from '../../redux/selector';

const DeleteModal = () => {
    const selectedProduct = useSelector(selectedProductSelector);
    const dispatch = useDispatch();
    const handleDelete = (event) => {
        event.preventDefault();
        dispatch(deleteProduct(selectedProduct.id));
    }
    return (
        <div>
            <div id="deleteEmployeeModal" className="modal fade">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <form>
                            <div className="modal-header">
                                <h4 className="modal-title">Delete Employee</h4>
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
                                <p>Are you sure you want to delete these Records?</p>
                                <p className="text-warning">
                                    <small>This action cannot be undone.</small>
                                </p>
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
                                    className="btn btn-danger"
                                    defaultValue="Delete"
                                    data-dismiss="modal"
                                    onClick={handleDelete}
                                />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default DeleteModal;
