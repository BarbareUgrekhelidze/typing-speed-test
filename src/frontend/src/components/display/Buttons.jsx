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

    function handleRestart(){
        window.dispatchEvent(new Event('restart'))
    }

    return (
        <div className="btns">
            <button onClick={handleSignIn} className="go-sign-in">Sign In</button>
            <button onClick={handleSignUp} className="go-sign-up">Sign Up</button>
            <button className="restart-btn" onClick={handleRestart}>Restart<img src="images/icon-restart.svg" alt=""/></button>
        </div>
    )
}

export default Buttons