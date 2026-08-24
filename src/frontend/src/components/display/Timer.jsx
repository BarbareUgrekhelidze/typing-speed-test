import Countdown from 'react-countdown';
import {useEffect, useRef} from "react";

function Timer ({duration}) {
    const countdownRef = useRef(null)

    useEffect(() => {
        window.addEventListener('startTimer', handleStartingTimer)
        window.addEventListener('stopTimer', handleStoppingTimer)

        return () => {
            window.removeEventListener('startTimer', handleStartingTimer)
            window.removeEventListener('stopTimer', handleStoppingTimer)
        }
    }, [])

    const handleStartingTimer = () => {
        countdownRef.current?.api?.start();
    }

    const handleStoppingTimer = () => {
        countdownRef.current?.api?.stop();
    }

    const renderer = ({ minutes, seconds, completed }) => {
        if (completed) {
            return <span>timeout</span>;
        } else {
            if (seconds < 10){
                return <span>{minutes}:0{seconds}</span>;
            }else{
                return <span>{minutes}:{seconds}</span>;
            }
        }
    };

    return (
        <>
            <Countdown ref={countdownRef}
                       autoStart={false}
                       renderer={renderer}
                       date={Date.now() + duration * 1000}
                       onComplete={() => window.dispatchEvent(new Event('testEnd'))}
            >

            </Countdown>
        </>
    )
}

export default Timer