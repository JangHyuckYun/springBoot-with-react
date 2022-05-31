import logo from './logo.svg';
import './App.css';
import React from "react";
import {Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import Register from "./pages/Register";

function App() {
    return (
        <div>
            <Routes>
                <Route path="/join" element={<Register/>}/>
                <Route exact path="/" element={<Home/>}/>
            </Routes>
        </div>
    );
}

export default App;

