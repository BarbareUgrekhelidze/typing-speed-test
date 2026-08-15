import './DisplayStyle.css'
import {useState} from "react";

function Main(){
    const [text, setText] = useState([])

    return (
        <div className="main">
            <h1 className="text">
                {text}
            </h1>
        </div>
    )
}

export default Main;