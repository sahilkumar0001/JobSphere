import React, { useEffect, useState } from 'react';
import JobApplications from './JobApplications';

const ApplicationManagement = () => {
  const [applications, setApplications] = useState([]);

  useEffect(() => {
    // Fetch applications for the logged-in employer's jobs
    const fetchApplications = async () => {
      const response = await fetch(`http://127.0.0.1:8080/api/employer/jobs`,{
        headers:{
          'Authorization':`Basic ${localStorage.getItem("token")}`
        }
      });
      const data = await response.json();
      if(response.ok){
        setApplications(data);
      }
      else{
        alert("unable to fetch applications!")
      }
    };

    fetchApplications();
  }, []);



  return (
    <div>
      {applications.length > 0 ? (
        
        
        <div className="container-app">
          <h2>Manage Applications</h2>
       
       {
        applications.map((job)=>(
          <JobApplications jobId={job.id} jobTitle={job.title}/>
        ))
       }
      </div>
          
        
        ): (
        <p className='text-center mt-2'>No applications received yet.</p>
      )}
    </div>
  );
};

export default ApplicationManagement;
