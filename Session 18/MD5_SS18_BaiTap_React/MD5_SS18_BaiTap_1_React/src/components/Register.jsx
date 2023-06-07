import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import * as actions from '../redux/actions'
import { listLocationSelector } from '../redux/selector'

export default function Register() {
    const listLocations = useSelector(listLocationSelector)
    const elementLocations = listLocations.map((item, index) => {
        return (<option value={item.id} key={index}>{item.name}</option>)
    })
    const dispatch = useDispatch()
    const [inputValue, setInputValue] = useState({
        email: "",
        password: "",
        locationId: 0,
    })

    const handleChange = (event) => {
        let key = event.target.name;
        let value = event.target.value;
        if(key === "locationId") {
            value = +event.target.value;
        }
        setInputValue({...inputValue, [key]: value});
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(inputValue);
        dispatch(actions.register(inputValue))
    }

    useEffect(() => {
        dispatch(actions.findAllLocation())
    }, [])
    return (
        <div className="form-container sign-up-container">
            <form action="#">
                <h1>Create Account</h1>
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
                <span>or use your email for registration</span>
                <input name='email' onChange={handleChange} value={inputValue.email} type="email" placeholder="Email" />
                <input name='password' onChange={handleChange} value={inputValue.password} type="password" placeholder="Password" />
                {/* <input type="text" placeholder="Name" /> */}
                {/* select location */}
                <div>
                    <p>Location: </p>
                    <select name='locationId' onChange={handleChange} value={inputValue.locationId} id="">
                        {elementLocations}
                    </select>
                </div>
                <button onClick={handleSubmit}>Sign Up</button>
            </form>
        </div>
    )
}
