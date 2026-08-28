import './DisplayStyle.css'

function UserInfo({username}){
    return (
        <>
            <div className="user-info">
                <img src="images/person.svg" alt=""/>
                <p>{username}</p>
            </div>
        </>
    )
}

export default UserInfo