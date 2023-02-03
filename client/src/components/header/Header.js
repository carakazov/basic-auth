import './header.css'
import {useState} from "react";

const HEADER_CLASS_NAME = 'common-header'
const HEADER_ITEM = 'header-item'
const DIV_BUTTON = 'div-button'

export default function Header() {
    const [logged, setLogged] = useState(false)

    const button = logged && <div className={`${HEADER_ITEM} ${DIV_BUTTON}`}>
        <button>Log Out</button>
    </div>

    return(
        <header className={HEADER_CLASS_NAME}>
            <h1 className={HEADER_ITEM}>Games and developers library</h1>
            {button}
        </header>
    )
}