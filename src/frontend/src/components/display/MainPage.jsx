import './DisplayStyle.css'
import {useEffect, useState} from "react";

function MainPage(){
    const [level, setLevel] = useState(() => {
        return localStorage.getItem('difficulty') || 'easy';
    });

    useEffect(() => {
       localStorage.setItem('difficulty', level);
    }), [level];

    const [time, setTime] = useState(() => {
       return localStorage.getItem('timeMode') || '30';
    });

    useEffect(() => {
       localStorage.setItem('timeMode', time);
       document.querySelector('.seconds').innerText = `0.${time}`;
    }), [time];

    return (
        <div className="container">

            <div className="head">
                <img src="images/logo-light.png" alt=""/>
                <div className="personal-best">
                    <img src="images/icon-personal-best.svg" alt=""/>
                    <p>Personal Best: <span>0 WPM</span></p>
                </div>
            </div>

            <div className="current-state">
                <div className="box-1">
                    <div className="wpm">
                        <p>WPM: <span>0</span></p>
                    </div>
                    <div className="accuracy">
                        <p>Accuracy: <span>100%</span></p>
                    </div>
                    <div className="time">
                        <p>Time: <span className="seconds">0.15</span></p>
                    </div>
                </div>
                <div className="box-2">
                    <div className="difficulty">
                        <p>Difficulty: </p>
                        <button className={`easy-btn ${level === 'easy' ? 'button-active' : ''}`} onClick={() => setLevel('easy')}>Easy</button>
                        <button className={`medium-btn ${level === 'medium' ? 'button-active' : ''}`} onClick={() => setLevel('medium')}>Medium</button>
                        <button className={`hard-btn ${level === 'hard' ? 'button-active' : ''}`} onClick={() => setLevel('hard')}>Hard</button>
                    </div>
                    <select  value = {time} name="Mode: " className="mode" onChange={(e) => {
                        setTime(e.target.value)
                    }}>
                        <option value="15">Timed (15s)</option>
                        <option value="30">Timed (30s)</option>
                        <option value="60">Timed (60s)</option>
                        <option value="120">Timed (120s)</option>
                    </select>
                </div>
            </div>

            <div className="main">
                <h1 className="text">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab adipisci architecto
                    ducimus eaque et expedita id in labore minima nemo omnis quae quidem, saepe sapiente vero?
                    Asperiores at dolores facere ipsa magni natus pariatur, voluptatem. A aperiam at distinctio
                </h1>
            </div>

            <div className="restart">
                <button className="go-sign-in">Sign In</button>
                <button className="go-sign-up">Sign Up</button>
                <button>Restart Test <img src="images/icon-restart.svg" alt=""/></button>
            </div>

        </div>
    )
}

export default MainPage;