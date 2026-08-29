import './DisplayStyle.css'
import {useEffect, useState} from "react";
import Timer from "./Timer.jsx";

function Controls (){

    {/* Start Handle Level */}
    const [level, setLevel] = useState(() => {
      return localStorage.getItem('difficulty') || 'easy'
    })

    useEffect (() => {
        localStorage.setItem('difficulty', level);
        window.dispatchEvent(new Event('difficultyChange'));
    }, [level])
    {/* End Handle Level */}

    {/* Start Handle Time */}
    const[time, setTime] = useState(() => {
        return localStorage.getItem('timeMode') || '30'
    })

    useEffect(() => {
        localStorage.setItem('timeMode', time)
        window.dispatchEvent(new Event('timeChange'))
    }, [time])
    {/* End Handle Level */}

    return (
        <div className="current-state">
            <div className="box-1">
                <div className="time">
                    <p>Time:
                        <Timer duration={time} />
                    </p>
                </div>
            </div>
            <div className="box-2">
                <div className="difficulty">
                    <p>Difficulty: </p>
                    <button className={`easy-btn ${level === 'easy' ? 'button-active' : ''}`} onClick={() => setLevel('easy')}>Easy</button>
                    <button className={`medium-btn ${level === 'medium' ? 'button-active' : ''}`} onClick={() => setLevel('medium')}>Medium</button>
                    <button className={`hard-btn ${level === 'hard' ? 'button-active' : ''}`} onClick={() => setLevel('hard')}>Hard</button>
                </div>
                <select value={time} onChange={(e) => setTime(e.target.value)}>
                    <option value="15">Timed (15s)</option>
                    <option value="30">Timed (30s)</option>
                    <option value="60">Timed (60s)</option>
                    <option value="120">Timed (120s)</option>
                </select>
            </div>
        </div>
    )
}

export default Controls;