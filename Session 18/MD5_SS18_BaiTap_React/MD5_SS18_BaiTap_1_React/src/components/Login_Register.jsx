import React from 'react';
import { useEffect, useState } from 'react'
import Login from './Login';
import Register from './Register';


const LoginRegister = () => {
    const [isLogin, setLogin]= useState(true);
    useEffect(() => {
      let container = document.getElementById('container');
      isLogin ? container.classList.remove("right-panel-active") : container.classList.add("right-panel-active");
   },[isLogin])
    return (
        <div>
            <div className="container" id="container">
                {/* SignUp */}
                {/* <div className="form-container sign-up-container">
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
            <input type="text" placeholder="Name" />
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <button>Sign Up</button>
          </form>
        </div> */}
                <Register />
                {/* SignUp */}
                {/* SignIn */}
                {/* <div className="form-container sign-in-container">
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
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <a href="#">Forgot your password?</a>
            <button>Sign In</button>
          </form>
        </div> */}
                <Login />
                {/* SignIn */}
                <div className="overlay-container">
                    <div className="overlay">
                        <div className="overlay-panel overlay-left">
                            <h1>Welcome Back!</h1>
                            <p>To keep connected with us please login with your personal info</p>
                            <button className="ghost" id="signIn" onClick={() => setLogin(!isLogin)}>
                                Sign In
                            </button>
                        </div>
                        <div className="overlay-panel overlay-right">
                            <h1>Hello, Friend!</h1>
                            <p>Enter your personal details and start journey with us</p>
                            <button className="ghost" id="signUp" onClick={() => setLogin(!isLogin)}>
                                Sign Up
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <footer>
                <p>
                    Created with <i className="fa fa-heart" /> by
                    <a target="_blank" href="https://florin-pop.com">
                        Florin Pop
                    </a>
                    - Read how I created this and how you can join the challenge
                    <a
                        target="_blank"
                        href="https://www.florin-pop.com/blog/2019/03/double-slider-sign-in-up-form/"
                    >
                        here
                    </a>
                    .
                </p>
            </footer>
        </div>
    );
}

export default LoginRegister;
