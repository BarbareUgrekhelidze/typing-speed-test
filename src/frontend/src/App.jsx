import './App.css'
import MainPage from "./pages/MainPage.jsx";
import {Route, Routes} from "react-router-dom";
import SignIn from "./components/registration/SignIn.jsx";
import SignUp from "./components/registration/SignUp.jsx";
import ScorePage from "./pages/ScorePage.jsx";

function App() {
  return (
    <Routes>
        <Route path={'/'} element={<MainPage />} />
        <Route path={'/sign-in'} element={<SignIn/>}/>
        <Route path={'/sign-up'} element={<SignUp/>}/>
        <Route path={'/score'} element={<ScorePage />}/>
    </Routes>
  )
}

export default App;
