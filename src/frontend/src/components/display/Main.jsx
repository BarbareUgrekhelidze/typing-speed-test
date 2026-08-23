import './DisplayStyle.css'
import {useEffect, useState} from "react";

function Main(){
    const [text, setText] = useState("")
    const [level, setLevel] = useState(() => {
        return localStorage.getItem('difficulty') || 'easy'
    })
    const [chars, setChars] = useState(() => {
        return Array(text.length).fill('untyped')
    })
    const [currIndex, setCurrIndex] = useState(0)

    const handleDifficultyChange = async () => {
        const currentLevel = localStorage.getItem('difficulty') || 'easy';
        setLevel(currentLevel);
    };

    const handleRestart = async () => {
        await fetchData()
    };

    const fetchData = async () => {
        try {
            let result;

            if (level === 'easy') {
                result = await fetch('http://localhost:8080/easy')
            } else if (level === 'medium') {
                result = await fetch('http://localhost:8080/medium')
            } else if (level === 'hard') {
                result = await fetch('http://localhost:8080/hard')
            }

            const data = await result.json();
            setText(data.easyText || data.mediumText || data.hardText || data.text || JSON.stringify(data));
        }catch(err){
            console.error("failed to fetch data: ", err)
        }
    }

    useEffect(() => {
        window.addEventListener('difficultyChange', handleDifficultyChange);
        return () => window.removeEventListener('difficultyChange', handleDifficultyChange);
    }, []);

    useEffect(() => {
        window.addEventListener('restart', handleRestart);
        return () => window.removeEventListener('restart', handleRestart)
    })

    useEffect(() => {
        fetchData()
    }, [level])

    useEffect(() => {
        if (text) {
            setChars(Array(text.length).fill('untyped'))
            setCurrIndex(0)
        }
    }, [text])

    const handleTyping = (e) => {
        if (e.key === ' ' || e.code === 'Space'){
            e.preventDefault()
        }

        if (e.key === 'Backspace'){
            if (currIndex > 0){
                updateChar(currIndex-1, 'untyped')
                setCurrIndex((prev) => prev-1)
            }
            return
        }

        if (currIndex < text.length) {
            if ((e.key === text[currIndex])) {
                updateChar(currIndex, 'green')
            }else{
                updateChar(currIndex, 'red')
            }
            setCurrIndex((prev) => prev + 1)
        }
    }

    const updateChar = (index, value) => {
        setChars((prevChars) => prevChars.map((currValue, i) => i === index ? value : currValue))
    }

    useEffect(() => {
        window.addEventListener('keydown', handleTyping)
        return () => window.removeEventListener('keydown', handleTyping)
    }, [chars, currIndex])

    return (
        <div className="main">
            <h1 className="text">
                {chars.map((value, index) => {
                    if (value === 'red'){
                        return (
                            <span key={index} className='text-red'>{text[index]}</span>
                        )
                    }else if (value === 'green'){
                        return (
                            <span key={index} className="text-green">{text[index]}</span>
                        )
                    }else if (index === currIndex){
                        return (
                            <span key={index} className="text-curr">{text[index]}</span>
                        )
                    }else {
                        return (
                            <span key={index}>{text[index]}</span>
                        )
                    }

                })}
            </h1>
        </div>
    )
}

export default Main;