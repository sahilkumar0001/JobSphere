import React, { useEffect, useState } from 'react';
import { FaBuilding, FaDollarSign, FaLocationArrow } from 'react-icons/fa';
// import { FaLocationPin, FaMapLocation } from 'react-icons/fa6';

const JobList = () => {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    // Fetch jobs from the backend
    const fetchJobs = async () => {
      const response = await fetch('http://127.0.0.1:8080/api/job/all');
      const data = await response.json();
      if(response.ok){
        setJobs(data);
      }
      else{
      
          alert("Unable to fetch jobs")
      
      }
    };

    fetchJobs();
  }, []);



  return (
    <div className='container mt-3 mb-5'>
      <h2>Available Jobs</h2>
      <div class="container-job">

      {jobs.map((job)=>(
         <div class="job-card">
         <div class="job-card-header">
           <div>
             <h4><FaBuilding/> {job.employerName}</h4>
           </div>
         </div>
         <div class="job-card-body">
           <h5>{job.title}</h5>
           <p>{job.description}</p>
         
           <p><FaLocationArrow/> {job.location}</p>
           <p>No. of Applicants: {job.applications}</p>
         </div>
         <div class="job-card-footer">
           <span class="badge"><FaDollarSign/> {job.salary}</span>
         </div>
       </div>
      ))}

  
    </div>
    </div>
  );
};

export default JobList;
