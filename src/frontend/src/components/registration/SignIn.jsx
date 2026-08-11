import './RegistrationStyle.css'

function SignIn (){
    return (
        <div className="container">
            <div className="sign-in-box">
                <img src="images/logo-light.png" alt=""/>
                <form action="submit">
                    <input name="email" type="email" placeholder="Enter email"/>
                    <input name="password" type="password" placeholder="Enter password"/>
                    <button type="submit" class="sign-in-btn">Sign In</button>
                </form>
            </div>
        </div>
    )
}

export default SignIn