import React from "react";
import { Link } from "react-router-dom";
import logo from '../assets/logo.png'
import '../App.css'
import { FaBuilding , FaPhone , FaAt , FaClock , FaInstagram , FaTwitter , FaFacebook} from 'react-icons/fa'
export default function Footer() {
  return (
    <div className="Footer mt-3">
      <div className="logoFooter">
        <img src={logo} alt="" />
      </div>
      <div className="footerMenu">
        <div className="foot" id="footDescription">
            <p><b>JobSphere - For Candidates & Employers</b> </p>
            <p className="ft-item"><FaBuilding />&nbsp;India</p>
            <p className="ft-item"><FaPhone /> &nbsp;(+91)99999xxxxx</p>
            <p className="ft-item"><FaAt/>&nbsp;Contact@jobsphere.in</p>
        </div>
        <div className="foot">
            <h2>Explore</h2><br/>
            <Link to="/" target="_self">&gt;Home</Link>
            <Link to="/about" target="_self">&gt;Find Jobs</Link>
            <Link to="/become-dealer" target="_self">&gt;Find Talent</Link>
            <Link to="/contact" target="_self">&gt;Contact us</Link>
        </div>

        </div>
        <div className="copyright">
            <p>© 2024 JobSphere, Minor Project @ GNA University</p>
            <div className="footIcons">
              <a href="/" className="fb"><FaFacebook/></a>
              <a href="/" className="tw"><FaTwitter/></a>
              <a href="/" className="insta"><FaInstagram/></a>
              
              
            </div>
        </div>
      </div>
    
  );
}
