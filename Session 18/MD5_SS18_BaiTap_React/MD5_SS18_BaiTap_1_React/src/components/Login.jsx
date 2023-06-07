import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import * as actions from '../redux/actions';
import { loginDetailsSelector } from '../redux/selector';
import {useNavigate} from 'react-router-dom'

export default function Login() {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const [inputValue, setInputValue] = useState({
        email: '',
        password: ''
    })

    const loginDetails = useSelector(loginDetailsSelector);

    const handleChange = (event) => {
        let key = event.target.name;
        let value = event.target.value;
        setInputValue({...inputValue, [key]: value})
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        dispatch(actions.login(inputValue));
        // nhận thông tin đăng nhập -> điều hướng trang
        // loginDetails.roles.forEach(element => {
        //     if (element.authority === 'ADMIN') {
        //         navigate('/admin');
        //     } else {
        //         navigate('/');
        //     }
        // });
    }

    useEffect (() => {
        loginDetails.roles.forEach(element => {
                if (element.authority === 'ADMIN') {
                    navigate('/admin');
                } else {
                    navigate('/');
                }
            });
    },[loginDetails])
    return (
        <div className="form-container sign-in-container">
            <form action="#">
                <h1>Sign in</h1>
                <div className="social-container">
                    <a href="#" className="social">
                        <i className="fab fa-facebook-f" />
                    </a>
                    <a href="#" className="social">
                        <i className="fab fa-google-plus-g" />
                    </a>
                    <a href="#" className="social">
                        <i className="fab fa-linkedin-in" />
                    </a>
                </div>
                <span>or use your account</span>
                <input onChange={handleChange} value={inputValue.email} name='email' type="email" placeholder="Email" />
                <input onChange={handleChange} value={inputValue.password} name='password' type="password" placeholder="Password" />
                <a href="#">Forgot your password?</a>
                <button onClick={handleSubmit}>Sign In</button>
            </form>
        </div>
    )
}
