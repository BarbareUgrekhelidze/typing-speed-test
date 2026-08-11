import './RegistrationStyle.css'

function SignUp (){
    return (
        <div className="container">
            <div className="sign-up-box">
                <img src="images/logo-light.png" alt=""/>
                <form action="submit">
                    <input name="email" type="email" placeholder="Enter email"/>
                    <input type="text" placeholder="Enter username"/>
                    <input name="password" type="password" placeholder="Enter password"/>
                    <button type="submit" class="sign-up-btn">Sign Up</button>
                </form>
            </div>
        </div>
    )
}

export default SignUp