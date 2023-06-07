
import './App.css'

import {Routes, Route} from 'react-router-dom'
import Home from './components/Home'
import Admin from './components/Admin'
import LoginRegister from './components/Login_Register'

function App() {

  return (
    <>
      <Routes>
        <Route path='/' element={<Home/>}></Route>
        <Route path='/login-register' element={<LoginRegister/>}></Route>
        <Route path="/admin" element={<Admin/>}></Route>
      </Routes>
    </>
  )
}

export default App
