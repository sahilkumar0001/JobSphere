import React, { createContext, useContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();

  // Login function
  const login = async (role,email, password) => {
    const credentials = btoa(`${email}:${password}`);
    // Mock backend login API call
    const url = (role === 'ROLE_EMPLOYEE' ? 'http://127.0.0.1:8080/api/employee/' : 'http://127.0.0.1:8080/api/employer/')
    const response = await fetch(url, {
      method: 'GET',
      headers: { 
        'Authorization':`Basic ${credentials}`
       } 
    });
    const userData = await response.json();
    console.log(userData)
    if (response.ok) {
    
      setUser(userData);
      localStorage.setItem("token",credentials);
      navigate(userData.role === 'ROLE_EMPLOYER' ? '/employer/dashboard' : '/employee/dashboard');
    } else {
      if(response.status ===403){
        alert("unauthorized")
        navigate("/unauthorized")
      }
      else{
        alert("Invalid credentials")
      }
    }
  };

  // Logout function
  const logout = () => {
    setUser(null);
    localStorage.removeItem("token")
    navigate('/login');
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

// Custom hook to use the authentication context
export const useAuth = () => useContext(AuthContext);
