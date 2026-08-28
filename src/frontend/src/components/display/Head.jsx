import './DisplayStyle.css'
import {useState} from "react";

function Head(){
    const [personalBest, setPersonalBest] = useState(0)

    function calculatePersonalBest(){
        const name = localStorage.getItem('username')?.trim();

        if (!name || name === "null" || name === "undefined") {
            return;
        }

        {/* todo calculate personal best */}
    }

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