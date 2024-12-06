import React, { useEffect, useState } from 'react';
const ApplicationList = () => {
  const [applications, setApplications] = useState([]);
  const token = localStorage.getItem("token");
  useEffect(() => {
    // Fetch applications for the logged-in employee
    const fetchApplications = async () => {
      const response = await fetch('http://127.0.0.1:8080/api/employee/applications',{
        headers:{
          'Authorization':`Basic ${token}`
        }
      });
      const data = await response.json();
      if(response.ok){
        setApplications(data);
      }
      else{
      
          alert("Unable to fetch jobs")
      
      }
    };

    fetchApplications();
  }, []);

  return (
    <div className='container mt-3'>
      <h2>Your Applications</h2>
      {applications.length > 0 ? (
        <div className="container-app">
       
        <table>
          <thead>
            <tr>
              <th>Application ID</th>
              <th>Job Title</th>
              <th>Job Description</th>
              <th>Salary</th>
              <th>Location</th>
              <th>Employer Name</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {applications.map((app) => (
              <tr key={app.id}>
                <td>{app.id}</td>
                <td>{app.jobDTO.title}</td>
                <td>{app.jobDTO.description}</td>
                <td>{app.jobDTO.salary}</td>
                <td>{app.jobDTO.location}</td>
                <td>{app.jobDTO.employerName}</td>
                <td>
                  <span className={`status ${app.status.toLowerCase()}`}>
                    {app.status}
                  </span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      ) : (
        <p className='text-center'>You have not applied for any jobs yet.</p>
      )}
    </div>
  );
};

export default ApplicationList;
