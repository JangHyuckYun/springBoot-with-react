import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";

const Home = ({ text }) => {
    console.log("connect Home...");

    return (
        <div>
            <h2>Home Page...</h2>
            <p>{text}</p>
            <Link to={"/join"}>Register</Link>
        </div>
    );
}

export default Home;
