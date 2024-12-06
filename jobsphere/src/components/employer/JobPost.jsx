import React, { useState } from 'react';

const JobPost = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [location, setLocation] = useState('');
  const [salary, setSalary] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Post job API call
    const response = await fetch('http://127.0.0.1:8080/api/job/', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' ,
        'Authorization':`Basic ${localStorage.getItem("token")}`
      },
      body: JSON.stringify({ title, description ,location,salary}),
    });

   if(response.ok){
    alert('Job posted successfully!');
    setTitle('');
    setDescription('');
    setLocation('');
    setSalary('')
   }else{
    alert("An Error Occured while posting the job!")
   }
  };

  return (
    <div className="container mt-3 w-50">
    <h2 class="form-title">Post a Job</h2>
    <form onSubmit={handleSubmit}>
      

     
      <div class="mb-3">
        <label for="jobTitle" class="form-label">Job Title</label>
        <input
          type="text"
          class="form-control"
          id="jobTitle"
          name="title"
          value={title}
          onChange={(e)=>{setTitle(e.target.value)}}
          placeholder="Enter job title"
          required
        />
      </div>
     
      <div class="mb-3">
        <label for="jobDescription" class="form-label">Job Description</label>
        <textarea
          class="form-control"
          id="jobDescription"
          name="description"
          value={description}
          onChange={(e)=>{setDescription(e.target.value)}}
          rows="4"
          placeholder="Enter job description"
          required
        ></textarea>
      </div>
    
      <div class="mb-3">
        <label for="jobLocation" class="form-label">Location</label>
        <input
          type="text"
          class="form-control"
          id="jobLocation"
          name="location"
          value={location}
          onChange={(e)=>{setLocation(e.target.value)}}
          placeholder="Enter job location"
          required
        />
      </div>
     
      <div class="mb-3">
        <label for="jobSalary" class="form-label">Salary</label>
        <input
          type="text"
          class="form-control"
          id="jobSalary"
          name="salary"
          value={salary}
          onChange={(e)=>{setSalary(e.target.value)}}
          placeholder="Enter salary"
          required
        />
      </div>
      
      <button type="submit" class="btn btn-primary">Post Job</button>
    
    </form>
    </div>
  );
};

export default JobPost;
