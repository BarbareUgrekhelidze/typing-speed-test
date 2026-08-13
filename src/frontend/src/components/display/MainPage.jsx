import './DisplayStyle.css'
import Restart from "./Restart.jsx";
import Head from "./Head.jsx";
import Controls from "./Controls.jsx";
import Main from "./Main.jsx";

function MainPage(){
    return (
        <div className="container">
            <Head />
            <Controls />
            <Main />
            <Restart />
        </div>
    )
}

export default MainPage;