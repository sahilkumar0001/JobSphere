import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

const Register = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [name, setName] = useState('');
  const [role, setRole] = useState(''); // Default role
  const navigate = useNavigate();

    
  const handleSubmit = async (e) => {
    e.preventDefault();
    const payload = (role === "ROLE_EMPLOYEE")?({name,email,password}):({companyName:name,email,password})
    // Register API call
    const url = (role === 'ROLE_EMPLOYEE' ? 'http://127.0.0.1:8080/api/employee/register' : 'http://127.0.0.1:8080/api/employer/register')
    const response = await fetch(url, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json'
      },
      body: JSON.stringify(payload),
    });

    if (response.ok) {
      alert('Registration successful!');
      navigate('/login');
    } else {
      alert('Registration failed!');
    }
  };

  return (
    <form onSubmit={handleSubmit} className='container w-50 mt-3'>
<h2>Register</h2>
    <select class="form-select form-select-sm" aria-label="Small select example" onChange={(e)=>{setRole(e.target.value)}}>
      <option selected>--Select Role--</option>
      <option value="ROLE_EMPLOYEE" >Employee</option>
      <option value="ROLE_EMPLOYER" >Employer</option>
     
    </select>
    
    <div class="mb-3">
      <label for="exampleFormControlInput1" class="form-label">Name</label>
      <input type="text" class="form-control" id="exampleFormControlInput1"  value={name} onChange={(e)=>setName(e.target.value)}/>
    </div>
           <div class="mb-3">
      <label for="exampleFormControlInput1" class="form-label">Email address</label>
      <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com" value={email} onChange={(e)=>setEmail(e.target.value)}/>
    </div>
    <div class="mb-3">
      <label for="exampleFormControlTextarea1" class="form-label">Password</label>
      <input type='password' class="form-control" id="exampleFormControlTextarea1" rows="3" value={password} onChange={(e)=>setPassword(e.target.value)}></input>
    </div>
    
  <div className='fload-end'>Already Have an Account? <Link to="/login">Login</Link></div>
    <div className="text-center mt-1"><input type="submit" className='text-center' value="Register" /></div>
        </form>
  );
};

export default Register;
