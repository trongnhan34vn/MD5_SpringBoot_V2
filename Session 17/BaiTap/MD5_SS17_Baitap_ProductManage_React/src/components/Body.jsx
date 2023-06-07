import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { requestAllProducts, selectProduct } from '../redux/action';
import { productSelector } from '../redux/selector';

const Body = () => {
    const dispatch = useDispatch();
    const listProducts = useSelector(productSelector);
    const handleSelectProduct = (id) => {
        dispatch(selectProduct(id));
    }
    const elementListProducts = listProducts.map((product, index) => {
        return <tr key={product.id}>
            <td>
                <span className="custom-checkbox">
                    <input
                        type="checkbox"
                        id="checkbox1"
                        name="options[]"
                        defaultValue={1}
                    />
                    <label htmlFor="checkbox1" />
                </span>
            </td>
            <td>{product.name}</td>
            <td>{product.description}</td>
            <td>{product.quantity}</td>
            <td>{product.price}</td>
            <td>
                <a
                    href="#editEmployeeModal"
                    className="edit"
                    data-toggle="modal"
                    onClick={() => handleSelectProduct(product.id)}
                >
                    <i
                        className="material-icons"
                        data-toggle="tooltip"
                        title="Edit"
                    >
                        
                    </i>
                </a>
                <a
                    href="#deleteEmployeeModal"
                    className="delete"
                    data-toggle="modal"
                    onClick={() => handleSelectProduct(product.id)}
                >
                    <i
                        className="material-icons"
                        data-toggle="tooltip"
                        title="Delete"
                    >
                        
                    </i>
                </a>
            </td>
        </tr>
    })

    useEffect(() => {
        dispatch(requestAllProducts());
    }, [])
    return (
        <div>
            <table className="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>
                            <span className="custom-checkbox">
                                <input type="checkbox" id="selectAll" />
                                <label htmlFor="selectAll" />
                            </span>
                        </th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {/* <tr>
                        <td>
                            <span className="custom-checkbox">
                                <input
                                    type="checkbox"
                                    id="checkbox1"
                                    name="options[]"
                                    defaultValue={1}
                                />
                                <label htmlFor="checkbox1" />
                            </span>
                        </td>
                        <td>Thomas Hardy</td>
                        <td>thomashardy@mail.com</td>
                        <td>89 Chiaroscuro Rd, Portland, USA</td>
                        <td>(171) 555-2222</td>
                        <td>
                            <a
                                href="#editEmployeeModal"
                                className="edit"
                                data-toggle="modal"
                            >
                                <i
                                    className="material-icons"
                                    data-toggle="tooltip"
                                    title="Edit"
                                >
                                    
                                </i>
                            </a>
                            <a
                                href="#deleteEmployeeModal"
                                className="delete"
                                data-toggle="modal"
                            >
                                <i
                                    className="material-icons"
                                    data-toggle="tooltip"
                                    title="Delete"
                                >
                                    
                                </i>
                            </a>
                        </td>
                    </tr> */}
                    {elementListProducts}
                </tbody>
            </table>
        </div>
    );
}

export default Body;
