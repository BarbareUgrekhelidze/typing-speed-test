import './DisplayStyle.css'

function Head(){
    return (
        <div className="head">
            <img src="images/logo-light.png" alt=""/>
            <div className="personal-best">
                <img src="images/icon-personal-best.svg" alt=""/>
                <p>Personal Best: <span>0 WPM</span></p>
            </div>
        </div>
    )
}

export default Head;