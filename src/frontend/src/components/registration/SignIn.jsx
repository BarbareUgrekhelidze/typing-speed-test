import './RegistrationStyle.css'
import {useState} from "react";
import {useNavigate} from "react-router-dom"

function SignIn (){
    const navigate = useNavigate()

    const [formData, setFormData] = useState({
        email: '',
        password: ''
    })

    function handleInputChange(e){
        setFormData((prev) => ({
            ...prev,
            [e.target.name]: e.target.value
        }))
    }

    function handleSignIn(e){
        e.preventDefault()

        const fetchData = async () => {
            try {
                const result = await fetch('http://localhost:8080/users/login', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(formData)
                });

                if (result.ok) {
                    const response = await result.json()
                    localStorage.setItem('username', response.username)
                    navigate("/signedIn")
                } else {
                    console.log("fail: " + result.status);
                }
            }catch (err){
                console.error("failed to sign in: " + err)
            }
        }

        fetchData()
    }

    return (
        <div className="container">
            <div className="sign-in-box">
                <img src="images/logo-light.png" alt=""/>
                <form action="submit">
                    <input onChange={(e)=> handleInputChange(e)} name="email" type="email" placeholder="Enter email"/>
                    <input onChange={(e)=> handleInputChange(e)} name="password" type="password" placeholder="Enter password"/>
                    <button onClick={(e) => handleSignIn(e)} className="sign-in-btn">Sign In</button>
                </form>
            </div>
        </div>
    )
}

export default SignIn