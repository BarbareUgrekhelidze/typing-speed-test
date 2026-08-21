import './App.css'
import MainPage from "./components/display/MainPage.jsx";
import {Route, Routes} from "react-router-dom";
import SignIn from "./components/registration/SignIn.jsx";
import SignUp from "./components/registration/SignUp.jsx";

function App() {
  return (
    <Routes>
        <Route path={'/'} element={<MainPage />} />
        <Route path={'/sign-in'} element={<SignIn/>}/>
        <Route path={'/sign-up'} element={<SignUp/>}/>
    </Routes>
  )
}

export default App;
