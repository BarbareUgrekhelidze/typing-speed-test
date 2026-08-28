import './ScoreDetailsStyle.css'
import {useNavigate} from "react-router-dom";

function ScoreDetails({score, accuracy, chars}){
    const navigate = useNavigate()

    function handleAgain(){
        if (localStorage.getItem('username')){
            navigate("/signedIn")
        }else{
            navigate("/")
        }
    }

    return (
     <>
         <img className="icon-completed" src="images/icon-completed.svg" alt=""/>
         <h1 className="completed-title">Test Complete!</h1>
         <div className="test-result">
             <p className="score-wpm">WPM: <span>{score}</span> </p>
             <p className="score-accuracy">Accuracy: <span>{accuracy}%</span></p>
             <p className="score-chars">Characters: <span>{chars} / 5</span></p>
         </div>
         <div className="again-btn-wrapper">
            <button onClick={handleAgain} className="again-btn">Again<img src="images/icon-restart.svg" alt=""/></button>
         </div>
     </>
    )
}

export default ScoreDetails