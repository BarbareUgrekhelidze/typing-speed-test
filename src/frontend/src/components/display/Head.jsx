import './DisplayStyle.css'
import {useEffect, useState} from "react";

function Head(){
    const [personalBest, setPersonalBest] = useState(0)

    useEffect( () => {
        const name = localStorage.getItem('username')?.trim();

        if (!name || name === "null" || name === "undefined") {
            return;
        }

        const fetchMaxScore = async () => {
            const result = await fetch('http://localhost:8080/scores/maxScore/1')

            if (result.ok){
                const data = await result.json()
                console.log(data.wpm)
                setPersonalBest(data.wpm)
            }else{
                console.log("failed to get max score: " + result.status)
            }
        }

        fetchMaxScore()
    })

    return (
        <div className="head">
            <img src="images/logo-light.png" alt=""/>
            <div className="personal-best">
                <img src="images/icon-personal-best.svg" alt=""/>
                <p>Personal Best: <span>{`${personalBest} WPM`}</span></p>
            </div>
        </div>
    )
}

export default Head;