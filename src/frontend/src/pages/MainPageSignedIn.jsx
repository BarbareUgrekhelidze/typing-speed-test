import '../components/display/DisplayStyle.css'
import Head from "../components/display/Head.jsx";
import Controls from "../components/display/Controls.jsx";
import Main from "../components/display/Main.jsx";
import SignedInButtons from "../components/display/SignedInButtons.jsx";
import UserInfo from "../components/display/UserInfo.jsx";
import {useState} from "react";

function MainPageSignedIn(){
    const [username, setUsername] = useState(() => {
        return localStorage.getItem('username') || "No username"
    })

    return (
        <>
            <div className="wrapper">
                <Head />
                <UserInfo username={username} />
                <Controls />
                <Main />
                <SignedInButtons />
            </div>
        </>
    )
}

export default MainPageSignedIn;