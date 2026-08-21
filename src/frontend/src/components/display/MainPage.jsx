import './DisplayStyle.css'
import Buttons from "./Buttons.jsx";
import Head from "./Head.jsx";
import Controls from "./Controls.jsx";
import Main from "./Main.jsx";

function MainPage(){
    return (
        <div className="wrapper">
            <Head />
            <Controls />
            <Main />
            <Buttons />
        </div>
    )
}

export default MainPage;