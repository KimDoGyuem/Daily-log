import './App.css';
import PartyList from './PartyList.js';
import Shop from './Shop.js';

function App() {

    const params = new URLSearchParams(window.location.search);
    let logId = params.get("id");
    let load = params.get("load");

    return(
        <>
            {"party" === load && <PartyList id={logId}/>}
            {"shop" === load && <Shop id={logId}/>}
        </>
    );
}
export default App;