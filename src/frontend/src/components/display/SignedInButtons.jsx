import {useNavigate} from "react-router-dom"

function SignedInButtons(){
    const navigate = useNavigate()

    function handleRestart(){
        window.dispatchEvent(new Event('restart'))
    }

    function handleSignOut(){
        localStorage.setItem('username', null)
        navigate("/")
    }

    return (
        <>
            <div className="btns">
                <button onClick={handleSignOut} className="sign-out-btn">Sign Out</button>
                <button className="restart-btn" onClick={handleRestart}>Restart<img src="images/icon-restart.svg" alt=""/></button>
            </div>
        </>
    )
}

export default SignedInButtons