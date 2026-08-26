import './RegistrationStyle.css'
import {useState} from "react";
import {useNavigate} from "react-router-dom";

function SignUp (){
    const navigate = useNavigate()

    const [formData, setFormData] = useState({
        email: '',
        username: '',
        password: ''
    })

    function handleInputChange(e){
        setFormData((prev) => ({
            ...prev,
            [e.target.name]: e.target.value
        }))
    }

    function handleSignUp(e) {
        e.preventDefault();
        console.log("sign up")

        const fetchData = async () => {
            try {
                const result = await fetch('http://localhost:8080/users', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(formData)
                });

                if (result.ok){
                    const response = await result.json()
                    console.log("success")
                    navigate("/signedIn")
                }else{
                    console.error('Registration failed:', result.status);
                }

            }catch (err) {
                console.error("Failed to sign up: " + err)
            }
        }

        fetchData()
    }

    return (
        <div className="container">
            <div className="sign-up-box">
                <img src="images/logo-light.png" alt=""/>
                <form onSubmit={(e) => handleSignUp(e)} action="submit">
                    <input onChange={(e) => handleInputChange(e)} name="email" type="email" placeholder="Enter email"/>
                    <input onChange={(e) => handleInputChange(e)} name="username" type="text" placeholder="Enter username"/>
                    <input onChange={(e) => handleInputChange(e)} name="password" type="password" placeholder="Enter password"/>
                    <button onClick={handleSignUp} className="sign-up-btn">Sign Up</button>
                </form>
            </div>
        </div>
    )
}

export default SignUp