import './DisplayStyle.css'
import {useEffect, useRef, useState} from "react";
import {useNavigate} from "react-router-dom";

function Main(){
    const [attemptedChars, setAttemptedChars] = useState(0)
    const navigate = useNavigate()

    const [text, setText] = useState("")
    const [testEnd, setTestEnd] = useState(false)
    const [level, setLevel] = useState(() => {
        return localStorage.getItem('difficulty') || 'easy'
    })
    const [currIndex, setCurrIndex] = useState(0)
    const [chars, setChars] = useState([])

    {/* Start fetching random text */}
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
    {/* End fetching random text */}

    {/* Start Handling events */}
    useEffect(() => {
        const handleDifficultyChange = async () => {
            const currentLevel = localStorage.getItem('difficulty') || 'easy';
            setLevel(currentLevel);
        };

        const handleTimeChange = async () => {
            await fetchData()
        }

        const handleRestart = async () => {
            await fetchData()
        };

        window.addEventListener('difficultyChange', handleDifficultyChange);
        window.addEventListener('timeChange', handleTimeChange)
        window.addEventListener('restart', handleRestart);

        return () => {
            window.removeEventListener('difficultyChange', handleDifficultyChange)
            window.removeEventListener('timeChange', handleTimeChange)
            window.removeEventListener('restart', handleRestart)
        }
    }, []);
    {/* End Handling events */}

    {/* Start difficulty change logic */}
    useEffect(() => {
        fetchData()
    }, [level])
    {/* End difficulty change logic */}

    {/* Start Typing logic */}
    const handleTyping = (e) => {
        if (testEnd || !text.length) return

        setAttemptedChars((prev) => prev+1)
        window.dispatchEvent(new Event('startTimer'))

        if (e.key === ' '){
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
    {/* End Typing logic */}

    {/* Start Scroll logic */}
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
    {/* End Scroll logic */}

    {/* Start Speed calculation logic */}
    useEffect(() => {
        window.addEventListener('testEnd', handleTestEnd)
        return () => window.removeEventListener('testEnd', handleTestEnd)
    }, [chars, text])

    const handleTestEnd = () => {
        setTestEnd(true)

        if (!chars || chars.length === 0) {
            console.warn("Test ended before characters were initialized.")
            return
        }

        let words = getWords()
        let correctChars = getNumOfCorrectChars(words)
        let overallCorrectChars = getNumGreenChars()
        let result = getResult(correctChars)

        localStorage.setItem('score', result)
        localStorage.setItem('chars', correctChars)
        localStorage.setItem('accuracy', (overallCorrectChars / attemptedChars * 100).toFixed(2))
        navigate("/score")
    }

    function getWords(){
        let words = []
        let word = ""
        for(let c = 0; c < chars.length; c++){
            if (c > 0){
                if (text[c-1] === ' '){
                    words.push(word)
                    word = ""
                }
            }

            if (chars[c] === 'red'){
                word += "r"
            }else if (chars[c] === 'green'){
                word += "g"
            }else if (chars[c] === 'untyped'){
                word += "u"
            }

            if (c === chars.length - 1){
                words.push(word)
            }
        }

        return words
    }

    function getNumOfCorrectChars(words){
        let result = 0
        for(let w = 0; w < words.length; w++){
            if (!words[w].includes("r") && !words[w].includes("u")){
                result += words[w].length
            }else if (!words[w].includes("r")){
                for(let i = 0; i < words[w].length; i++){
                    if (words[w][i] === 'g'){
                        result++
                    }
                }
            }
        }
        return result
    }

    function getNumGreenChars(){
        let result = 0
        for(let i = 0; i < chars.length; i++){
            if (chars[i] === 'green'){
                result++
            }
        }
        return result
    }

    function getResult(correctChars){
        correctChars /= 5
        let time = localStorage.getItem('timeMode')
        let result
        if (time !== null){
            if (time === '15'){
                result = correctChars * 4
            }else if (time === '30'){
                result = correctChars * 2
            }else if (time === '60'){
                result = correctChars
            }else if (time === '120'){
                result = correctChars / 2
            }
        }else{
            console.log("time is null")
        }

        return result
    }
    {/* End Speed calculation logic */}

    {/* Text change reset ---- */}
    useEffect(() => {
        if (text) {
            setChars(Array(text.length).fill('untyped'))
            setCurrIndex(0)
            initialTop.current = null;
            setCurrentLine(0);
            setTestEnd(false)
            setAttemptedChars(0)
            window.dispatchEvent(new Event('stopTimer'))
        }
    }, [text])
    {/* ---- Text change reset */}

    return (
        <div className="main" style={{ height: `${LINE_HEIGHT_REM * 3}rem`, overflow: 'hidden' }}>

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
                                ref={(element) => { positions.current[index] = element }}
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