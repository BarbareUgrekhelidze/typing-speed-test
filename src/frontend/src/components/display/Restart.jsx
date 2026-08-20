import './DisplayStyle.css'

function Restart (){
    function handleRestart(){
       // todo
    }

    return (
        <div className="restart">
            <button className="go-sign-in">Sign In</button>
            <button className="go-sign-up">Sign Up</button>
            <button  onClick={handleRestart}>Restart Test <img src="images/icon-restart.svg" alt=""/></button>
        </div>
    )
}

export default Restart