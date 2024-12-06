import React from 'react'

import {  FaBuilding } from 'react-icons/fa';
import {  IoConstructSharp } from 'react-icons/io5';
import { Link } from 'react-router-dom';
export default function About() {
  return (
    <>
    <div className="banner abt">ABOUT US
        </div>
        <div className="title">
        <span className="initial">ABOUT</span>
        &nbsp;
        <span className="final">JOBSPHERE</span>
        <div className="decor"></div>
    </div>

<div className="container my-3">
<section class="feature-box mb-5">
      <h2 class="text-center mb-4">Our Mission</h2>
      <p class="text-center">
        Our mission is to empower individuals and organizations by providing a platform that fosters meaningful connections. We aim to transform the way people find jobs and hire talent by leveraging technology to simplify the process and maximize results.
      </p>
    </section>
    <section class="row mb-5">
      <div class="col-md-6 mb-4">
        <div class="feature-box shadow p-4 rounded">
          <i class="fa fa-users fa-3x text-primary mb-3"></i>
          <h4>For Job Seekers</h4>
          <ul class="list-unstyled text-muted">
            <li><i class="fa fa-check-circle me-2 text-success"></i> Browse jobs tailored to your skills</li>
            <li><i class="fa fa-check-circle me-2 text-success"></i> Apply to jobs with ease</li>
            <li><i class="fa fa-check-circle me-2 text-success"></i> Track your applications in real-time</li>
          </ul>
        </div>
      </div>
      <div class="col-md-6 mb-4">
        <div class="feature-box shadow p-4 rounded">
          <i class="fa fa-briefcase fa-3x text-primary mb-3"></i>
          <h4>For Employers</h4>
          <ul class="list-unstyled text-muted">
            <li><i class="fa fa-check-circle me-2 text-success"></i> Post job openings effortlessly</li>
            <li><i class="fa fa-check-circle me-2 text-success"></i> Review and manage applications</li>
            <li><i class="fa fa-check-circle me-2 text-success"></i> Connect with the right candidates</li>
          </ul>
        </div>
      </div>
    </section>

    <section class="text-center mb-5">
      <h2 class="mb-4">Why Choose JobConnect?</h2>
      <div class="row text-center">
        <div class="col-md-4 mb-3">
          <div class="why-box p-4 shadow-sm rounded">
            <i class="fa fa-laptop-code fa-2x text-primary mb-3"></i>
            <h5>User-Friendly</h5>
            <p>Our interface is designed to be intuitive and easy to use for everyone.</p>
          </div>
        </div>
        <div class="col-md-4 mb-3">
          <div class="why-box p-4 shadow-sm rounded">
            <i class="fa fa-search fa-2x text-primary mb-3"></i>
            <h5>Efficient Matching</h5>
            <p>Find the perfect match between job seekers and employers in no time.</p>
          </div>
        </div>
        <div class="col-md-4 mb-3">
          <div class="why-box p-4 shadow-sm rounded">
            <i class="fa fa-lock fa-2x text-primary mb-3"></i>
            <h5>Secure</h5>
            <p>Your data is safe with us. We prioritize your privacy and security.</p>
          </div>
        </div>
      </div>
    </section>


    <section class="text-center">
      <h2 class="text-center mb-4">Join Us Today</h2>
      <p>
        Become part of our growing community of professionals and organizations. Whether you're looking to <strong>find your dream job</strong> or <strong>hire your next great employee</strong>, JobConnect is here to help every step of the way.
      </p>
      <a href="/register" class="btn btn-primary">Get Started</a>
    </section>
    </div>
    </>
  )
}

