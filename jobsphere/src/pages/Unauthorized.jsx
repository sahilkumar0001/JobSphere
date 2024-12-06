import React from 'react';
import { Link } from 'react-router-dom';

const Unauthorized = () => {
  return (
    <div style={{ textAlign: 'center', padding: '2em' }}>
      <h1>403 - Unauthorized</h1>
      <p>You do not have permission to view this page.</p>
      <Link to="/">Go back to home</Link>
    </div>
  );
};

export default Unauthorized;
