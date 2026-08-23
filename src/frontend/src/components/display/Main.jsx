import './DisplayStyle.css'
import {useEffect, useRef, useState} from "react";

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
            initialTop.current = null;
            setCurrentLine(0);
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

    const [currentLine, setCurrentLine] = useState(0)
    const positions = useRef([])
    const initialTop = useRef(null)
    const LINE_HEIGHT_REM = 3;

    useEffect(() => {
        const currPosition = positions.current[currIndex]

        if (currPosition) {
            const offset = currPosition.offsetTop

            if (initialTop.current === null) {
                initialTop.current = offset
            }

            const lineHeightPx = LINE_HEIGHT_REM * 16;
            const lineIndex = Math.floor((offset - initialTop.current) / lineHeightPx);

            setCurrentLine(lineIndex);
        }
    }, [currIndex])

    const scrollOffset = currentLine > 1 ? (currentLine - 1) * LINE_HEIGHT_REM : 0;

    return (
        <div className="main" style={{ height: `${LINE_HEIGHT_REM * 3 + 3}rem`, overflow: 'hidden' }}>

            <div
                style={{
                    transform: `translateY(-${scrollOffset}rem)`,
                    transition: 'transform 0.2s ease-out'
                }}
            >
                <h1 className="text" style={{ lineHeight: `${LINE_HEIGHT_REM}rem` }}>
                    {chars.map((value, index) => {
                        let classname = ''
                        if (value === 'red') classname = 'text-red'
                        else if (value === 'green') classname = 'text-green'
                        else if (index === currIndex) classname = 'text-curr'

                        return (
                            <span
                                ref={(el) => { positions.current[index] = el }}
                                key={index}
                                className={classname}
                            >
                                {text[index]}
                            </span>
                        )
                    })}
                </h1>
            </div>

        </div>
    )
}

export default Main;