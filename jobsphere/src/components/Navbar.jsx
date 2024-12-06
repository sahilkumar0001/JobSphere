import React from 'react';
import { Link , useLocation} from "react-router-dom";
import { useAuth } from '../context/useAuth';
import logo from '../assets/logo.png'
import { useState } from 'react';
import '../App.css'
const Navbar = () => {
  const { user, logout } = useAuth();
  // For Responsivness of Navbar
  const [Nav , setNav]= useState("topnav");
  const path = useLocation().pathname;

    function myFunction() {
      if (Nav === "topnav") {
        setNav("topnav responsive");
      } else {
        setNav("topnav");
      }
      
    }
    
  //For sliding effect
    var prevScrollpos = window.pageYOffset;
    window.onscroll = function() {
     
      
      var currentScrollPos = window.pageYOffset;
      if(Nav === "topnav"){
        if (prevScrollpos > currentScrollPos) {
          document.getElementById("myTopnav").style.top = "0";
        } else {
          document.getElementById("myTopnav").style.top = "-50px";
        }
        prevScrollpos = currentScrollPos;  
      }
      
    }

  return (
    <>
    <div className="logoFooter display-inline">
        <img src={logo} alt="" />
    </div>
    <div className={Nav} id="myTopnav">

      <Link className={`Link ${(path==="/")?"active":""}`} to="/"> Home</Link>
      {user && user.role === 'ROLE_EMPLOYEE' && <Link to="/employee/dashboard"  className='Link'>Dashboard</Link>}
      {user && user.role === 'ROLE_EMPLOYEE' && <Link to="/employee/applications" className='Link'>My Applications</Link>}
      {user && user.role === 'ROLE_EMPLOYER' && <Link to="/employer/dashboard" className='Link'>Dashboard</Link>}
      {user && user.role === 'ROLE_EMPLOYER' && <Link to="/employer/postings" className='Link'>Posted Jobs</Link>}
      {user && user.role === 'ROLE_EMPLOYER' && <Link to="/employer/applications" className='Link'>Manage Applications</Link>}
      <Link className={`Link ${(path==="/about")?"active":""}`} to="/about">About</Link>
      <Link className={`Link ${(path==="/contact")?"active":""}`} to="/contact">Contact us</Link>
      {user ? (
        <div className='d-flex align-items-center float-end'>
        <p className='text-center mb-0'>{user.email}</p>
        <button className="btn Link" onClick={logout}>Logout</button></div>
      ) : (<>
        <Link className="Link ml-1 sign" to="/login">Login</Link>
        <Link className="Link ml-1 sign" to="/register">Register</Link>
        
        </>
      )}
      <button className="center-item icon"  onClick={myFunction}>
        <i className="fa fa-bars"></i>
      </button>
    </div> 
    </>
  );
};

export default Navbar;
