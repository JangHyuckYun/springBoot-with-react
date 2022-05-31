import React, {useEffect, useRef, useState} from "react";
import axios from "axios";

const Register = () => {
    const [loginId, setLoginId] = useState("");
    const [loginPassword, setLoginPassword] = useState("");

    const saveUser = async (e) => {
        const api = axios.create({
            baseURL: "/"
        });

        api.post('/saveUser', null, {
            params: {
                loginId, loginPassword
            }
        }).then(res => console.log("response", res));

    };

    return (
        <div>
            <div>
                <span>Login Id</span>
                <input
                    type="text"
                    name="loginId"
                    placeholder="write loginId..."
                    value={loginId}
                    onInput={({target}) => setLoginId(target.value)}
                />
            </div>

            <div>
                <span>Login Password</span>
                <input
                    type="text"
                    name="loginPassword"
                    placeholder="write loginPassword..."
                    value={loginPassword}
                    onInput={({target}) => setLoginPassword(target.value)}
                />
            </div>

            <div>
                <button type={"button"} onClick={saveUser}>submit</button>
            </div>
        </div>
    );
}

export default Register;
