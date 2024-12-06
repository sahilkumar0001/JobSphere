import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import ApplicationManagement from './ApplicationManagement';
const JobPostings = () => {
  const [jobs, setJobs] = useState([]);
  const token = localStorage.getItem("token");
  useEffect(() => {
    // Fetch applications for the logged-in employee
    const fetchJobs = async () => {
      const response = await fetch('http://127.0.0.1:8080/api/employer/jobs',{
        headers:{
          'Authorization':`Basic ${token}`
        }
      });
      if(response.ok){
        const data = await response.json();
      setJobs(data);
      }
      else{
        alert("Unable to fetch jobs")
      }
    };

    fetchJobs();
  }, []);
  const fetchJobApplications =(jobId)=>{
    return <ApplicationManagement jobId={jobId}/>
  }
  return (
    <div className='container mt-3'>
      <h2>Your Jobs</h2>
      {jobs.length > 0 ? (
        <div className="container-app">
       
        <table>
          <thead>
            <tr>
              <th>Job ID</th>
              <th>Job Title</th>
              <th>Job Description</th>
              <th>Salary</th>
              <th>Location</th>
              <th>Applications</th>
              
            </tr>
          </thead>
          <tbody>
            {jobs.map((job) => (
              <tr key={job.id}>
                <td>{job.id}</td>
                <td>{job.title}</td>
                <td>{job.description}</td>
                <td>{job.salary}</td>
                <td>{job.location}</td>
                <td><button className='status approved' onClick={()=>{fetchJobApplications(job.id)}}>View Applications: {job.applications}</button></td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      ) : (
        <p className='text-center w-auto'>You have not posted any jobs yet.</p>
      )}
    </div>
  );
};

export default JobPostings;
