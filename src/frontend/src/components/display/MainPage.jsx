import './DisplayStyle.css'

function MainPage(){
    return (
        <div className="container">

            <div class="head">
                <img src="images/logo-light.png" alt=""/>
                <div className="personal-best">
                    <img src="images/icon-personal-best.svg" alt=""/>
                    <p>Personal Best: <span>...</span></p>
                </div>
            </div>

            <div className="current-state">
                <div className="box-1">
                    <div className="wpm">
                        <p>Wpm: <span>...</span></p>
                    </div>
                    <div className="accuracy">
                        <p>Accuracy: <span>...</span></p>
                    </div>
                    <div className="time">
                        <p>Time: <span>...</span></p>
                    </div>
                </div>
                <div className="box-2">
                    <div className="difficulty">
                        <p>Difficulty: </p>
                        <button>Easy</button>
                        <button>Medium</button>
                        <button>Hard</button>
                    </div>
                    <select name="Mode: " className="mode">
                        <option value="30">Timed (15s)</option>
                        <option value="15">Timed (30s)</option>
                        <option value="60">Timed (60s)</option>
                        <option value="120">Timed (120s)</option>
                    </select>
                </div>
            </div>

            <div className="main">
                <h1 className="text">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab adipisci architecto
                    ducimus eaque et expedita id in labore minima nemo omnis quae quidem, saepe sapiente vero?
                    Asperiores at dolores facere ipsa magni natus pariatur, voluptatem. A aperiam at distinctio
                    eius esse magni minus nam nisi non obcaecati placeat ratione, similique sit totam vitae. Aperiam,
                    commodi dignissimos dolores illum magnam numquam odit officiis optio voluptates voluptatum. Ad
                    aspernatur commodi culpa cupiditate eius eos error est eveniet explicabo harum impedit itaque,
                    iusto libero maiores minima nisi officia, pariatur porro qui
                    quisquam rem rerum sapiente voluptatibus. Assumenda ea harum ipsum natus, quos saepe?
                </h1>
            </div>

            <div className="restart">
                <button>Restart Test <img src="images/icon-restart.svg" alt=""/></button>
            </div>

        </div>
    )
}

export default MainPage;