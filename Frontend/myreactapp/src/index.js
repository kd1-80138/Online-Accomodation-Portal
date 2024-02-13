import React from 'react';
import ReactDOM from 'react-dom/client';
import Launcher from './Launcher';
import {BrowserRouter} from 'react-router-dom';

//import Login from './login';
  
const root = ReactDOM.createRoot(document.getElementById('root'));
//root.render(<Login/>);
root.render(<BrowserRouter>
                <Launcher/>    
            </BrowserRouter>)

