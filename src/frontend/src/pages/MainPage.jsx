import '../components/display/DisplayStyle.css'
import Buttons from "../components/display/Buttons.jsx";
import Head from "../components/display/Head.jsx";
import Controls from "../components/display/Controls.jsx";
import Main from "../components/display/Main.jsx";

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