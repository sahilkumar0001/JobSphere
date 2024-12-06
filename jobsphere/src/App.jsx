import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './context/useAuth';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import PrivateRoute from './components/PrivateRoute';
import Login from './pages/Login';
import Register from './pages/Register';
import Unauthorized from './pages/Unauthorized';
import JobList from './components/employer/JobList';
import ApplicationList from './components/employee/ApplicationList';
import ApplicationManagement from './components/employer/ApplicationManagement';
import Contact from './components/Contact';
import About from './components/About';
import Home from './pages/Home';
import JobListing from './components/employee/JobListing';
import JobPost from './components/employer/JobPost';
import JobPostings from './components/employer/JobPostings';


const App = () => {
  return (
    <Router>
    <AuthProvider>
   
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/about" element={<About />} />
          <Route path="/register" element={<Register />} />
          <Route path="/unauthorized" element={<Unauthorized />} />
          {/* Employee Routes */}
          <Route
            path="/employee/dashboard"
            element={
              <PrivateRoute allowedRoles={['ROLE_EMPLOYEE']}>
                <JobListing />
                <ApplicationList />
              </PrivateRoute>
            }
          />
          <Route
            path="/employee/applications"
            element={
              <PrivateRoute allowedRoles={['ROLE_EMPLOYEE']}>
                <ApplicationList />
              </PrivateRoute>
            }
          />
          {/* Employer Routes */}
          <Route
            path="/employer/dashboard"
            element={
              <PrivateRoute allowedRoles={['ROLE_EMPLOYER']}>
                <JobPost />
                <JobPostings/>
              </PrivateRoute>
            }
          />
          <Route
            path="/employer/postings"
            element={
              <PrivateRoute allowedRoles={['ROLE_EMPLOYER']}>
                <JobPostings/>
              </PrivateRoute>
            }
          />
          <Route
            path="/employer/applications"
            element={
              <PrivateRoute allowedRoles={['ROLE_EMPLOYER']}>
                <ApplicationManagement />
              </PrivateRoute>
            }
          />
        </Routes>
        <Footer />
        </AuthProvider>
      </Router>
  
  );
};

export default App;
