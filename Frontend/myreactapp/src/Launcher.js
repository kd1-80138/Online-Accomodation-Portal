'use client'

import Home from "./pages/home/Home";
import About from "./pages/about/About";
import AddProperty from "./components/property/AddProperty";
import Contact from "./pages/contact/Contact";
import Login from "./pages/signin/signin";
import Register  from "./pages/signup";
import Footer from "./components/Footer/Footer";
import NavigationBar from "./components/Navbar/NavigationBar";
import Image from "./Image";
import { ToastContainer} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { Route, Routes} from 'react-router-dom';

function Launcher()
{

    return(
    <div className="container">
        <Image/> 
        <NavigationBar/>
            <Routes>
                        <Route  path="/" element={<Home/>}></Route>
                        <Route exact path="/home" element={<Home/>} ></Route>
                        <Route exact path="/about" element={<About/>}></Route>
                        <Route exact path="/login" element={<Login/>} ></Route>
                        <Route exact path="/contact" element={<Contact/>} ></Route>     
                        <Route exact path="/Register" element={<Register/>} > </Route>                                
                        <Route path="**" component={<Home/>}  />
            </Routes>
            <ToastContainer/>
        <Footer/>            
    </div>
    );
}

export default Launcher;