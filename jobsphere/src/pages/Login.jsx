import React, { useState } from 'react';
import { useAuth } from '../context/useAuth';
import { Link } from 'react-router-dom';

const Login = () => {
  const { login } = useAuth();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState(''); 

  const handleSubmit = (e) => {
    e.preventDefault();
    login(role,email, password);
  };

  return (
    <form onSubmit={handleSubmit} className='container mt-3 w-50'>
      <h2>Login</h2>
<select class="form-select form-select-sm" aria-label="Small select example" onChange={(e)=>{setRole(e.target.value)}}>
  <option selected>--Select Role--</option>
  <option value="ROLE_EMPLOYEE" >Employee</option>
  <option value="ROLE_EMPLOYER" o>Employer</option>
 
</select>

       <div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Email address</label>
  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com" value={email} onChange={(e)=>setEmail(e.target.value)}/>
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Password</label>
  <input type='password' class="form-control" id="exampleFormControlTextarea1" rows="3" value={password} onChange={(e)=>setPassword(e.target.value)}></input>
</div>
<div className='fload-end'>Don't Have an Account? <Link to="/register">Register</Link></div>
<div className="text-center"><input type="submit" value="Login" /></div>
    </form>
  );
};

export default Login;
