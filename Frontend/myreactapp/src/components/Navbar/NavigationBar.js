// components/NavigationBar.js
import React from 'react';
import './navigation.css'
import { Link } from 'react-router-dom';

const NavigationBar = () => {
  return (
    
    <nav class="navbar navbar-expand-lg navbar-light bg-light" >
      <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <ul class ="navbar-nav mr-auto" >
        <li class="nav-item active">
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