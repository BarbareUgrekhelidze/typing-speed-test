import './DisplayStyle.css'
import {useEffect, useState} from "react";

function Main(){
    const [text, setText] = useState("")
    const [level, setLevel] = useState(() => {
        return localStorage.getItem('difficulty') || 'easy'
    })

    const handleDifficultyChange = () => {
        const currentLevel = localStorage.getItem('difficulty') || 'easy';
        setLevel(currentLevel);
    };

    useEffect(() => {
        window.addEventListener('difficultyChange', handleDifficultyChange);
        return () => window.removeEventListener('difficultyChange', handleDifficultyChange);
    }, []);

    const fetchData = async () => {
        let result;

        if (level === 'easy'){
            result = await fetch('http://localhost:8080/easy')
        }else if (level === 'medium'){
            result = await fetch('http://localhost:8080/medium')
        }else if (level === 'hard'){
            result = await fetch('http://localhost:8080/hard')
        }

        const data = await result.json();
        console.log(data)
        setText(data.easyText || data.mediumText || data.hardText || data.text || JSON.stringify(data));
    }

    useEffect(() => {
        fetchData();
    }, [level])

    return (
        <div className="main">
            <h1 className="text">
                {text}
            </h1>
        </div>
    )
}

export default Main;