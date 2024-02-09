import Home from "./Home";
import About from "./About";
import Contact from "./Contact";
import Login from "./login";
import NavigationBar from "./NavigationBar";
import Image from "./Image";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import { Route, Switch} from 'react-router-dom';

function Launcher()
{

    return(
    <div className="container">
        <Image/> 
        <NavigationBar/>
        
        <Switch>
                    <Route exact path="/" component={Home}  />
                    <Route exact path="/home" component={Home}  />
                    <Route exact path="/about" component={About}  />
                    <Route exact path="/login" component={Login}  />
                    <Route exact path="/contact" component={Contact} />
                    <Route path="**" component={Contact}  />
        </Switch>            
    </div>
    );
}

export default Launcher;