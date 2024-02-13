// components/NavigationBar.js
import React from 'react';
import './navigation.css'
import { Link } from 'react-router-dom';

const NavigationBar = () => {
  return (
    
    <nav className="navbar navbar-expand-lg navbar-light bg-light" >
      <div className="collapse navbar-collapse" id="navbarTogglerDemo01">
      <ul className ="navbar-nav mr-auto" >
        <li className="nav-item active">
          <Link to="/" >Home</Link>
        </li>
        <li>
          <Link to="/about">About</Link>
        </li>
        <li>
          <Link to="/contact">Contact</Link>
        </li>
        <li>
          <Link to="/login">Login</Link>
        </li>
        
      </ul>
      </div>
</nav>

  );
};

export default NavigationBar;