import {useState} from "react";
import Head from "../components/display/Head.jsx";
import ScoreDetails from "../components/score/ScoreDetails.jsx";
import "../components/score/ScoreDetailsStyle.css";

function ScorePage(){
    const [score] = useState(() => {
        return localStorage.getItem('score') || 0
    })

    const [chars] = useState(() => {
        return localStorage.getItem('chars') || 0
    })

    const [accuracy] = useState(() => {
        return localStorage.getItem('accuracy') || 100
    })

    return (
        <div className="wrapper">
            <Head />
            <ScoreDetails score={score} accuracy={accuracy} chars={chars}/>
        </div>
    )
}

export default ScorePage