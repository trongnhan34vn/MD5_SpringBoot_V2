import React, { useEffect, useState } from 'react';
import {useNavigate} from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import { loginDetailsSelector } from '../redux/selector';

const Admin = () => {
    const loginDetails = useSelector(loginDetailsSelector);
    const navigate = useNavigate()
  
    useEffect (() => {
        if (loginDetails == null ) {
            navigate("/login-register");
        } 
    }, [loginDetails])

    return (
        <div>
            <h1>Đây là trang Admin</h1>
        </div>
    );
}

export default Admin;
