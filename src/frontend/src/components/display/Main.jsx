import './DisplayStyle.css'

function Main(){
    let text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab ad, consequatur esse excepturi impedit modi nesciunt nobis repellat veniam voluptatem!";

    return (
        <div className="main">
            <h1 className="text">
                {text}
            </h1>
        </div>
    )
}

export default Main;