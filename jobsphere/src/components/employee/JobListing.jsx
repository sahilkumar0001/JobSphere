import React, { useEffect, useState } from 'react';
import { FaBuilding, FaDollarSign, FaLocationArrow } from 'react-icons/fa';
// import { FaLocationPin, FaMapLocation } from 'react-icons/fa6';

const JobListing = () => {
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

  const applyToJob = async (id)=>{
    const raw = JSON.stringify({
        "resume": "resume-employee1",
        "status": "applied"
      });
    const credentials = localStorage.getItem("token");
        const response = await fetch(`http://127.0.0.1:8080/api/application/${id}`,{
            method: 'Post',
      headers: { 
        'Authorization':`Basic ${credentials}`,
        'Content-Type':'application/json'
       },
       body:raw
        });
        if(response.status === 406){
            alert("Already applied")
        }
        
        else{
            if(response.ok){
                alert("Applied successfully")
            }
            else{
                alert("Error Occured!!")
            }
        }
      }
  


  return (
    <div className = 'container mt-5'>
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
           <button className='btn btn-primary'onClick={()=>applyToJob(job.id)}>Apply</button>
         </div>
       </div>
      ))}

  
    </div>
    </div>
  );
};

export default JobListing;
