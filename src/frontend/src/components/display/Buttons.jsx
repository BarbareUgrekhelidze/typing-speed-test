import './DisplayStyle.css'
import {useNavigate} from "react-router-dom";

function Buttons (){
    const navigate = useNavigate()

    function handleSignIn(){
        navigate("/sign-in")
    }

    function handleSignUp(){
        navigate("/sign-up")
    }

    return (
        <div className="btns">
            <button onClick={handleSignIn} className="go-sign-in">Sign In</button>
            <button onClick={handleSignUp} className="go-sign-up">Sign Up</button>
        </div>
    )
}

export default Buttons