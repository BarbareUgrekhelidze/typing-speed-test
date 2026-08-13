import './DisplayStyle.css'

function Restart (){
    return (
        <div className="restart">
            <button className="go-sign-in">Sign In</button>
            <button className="go-sign-up">Sign Up</button>
            <button>Restart Test <img src="images/icon-restart.svg" alt=""/></button>
        </div>
    )
}

export default Restart