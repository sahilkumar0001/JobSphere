import React, { useState, useEffect } from "react";

const JobApplications = ({ jobId, jobTitle }) => {
  // State for job applications
  const [applications, setApplications] = useState([]);

  // Fetch applications for a job when the component mounts
  useEffect(() => {
    const fetchApplications = async () => {
      try {
        const response = await fetch(`http://127.0.0.1:8080/api/application/job/${jobId}`,{
            headers:{
                'Authorization':`Basic ${localStorage.getItem("token")}`
            }
        });
        if (response.ok) {
          const data = await response.json();
          setApplications(data);
        } else {
          console.error("Failed to fetch applications");
        }
      } catch (error) {
        console.error("Error fetching applications:", error);
      }
    };

    fetchApplications();
  }, [jobId]);

  // Update application status
  const updateStatus = async (applicationId, status) => {
    try {
      const response = await fetch(`http://localhost:8080/api/application/${applicationId}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Basic ${localStorage.getItem("token")}`
        },
        body: JSON.stringify({ status }),
      });

      if (response.ok) {
        alert("Application status updated successfully!");
        // Refresh applications after updating the status
        setApplications((prevApplications) =>
          prevApplications.map((app) =>
            app.id === applicationId ? { ...app, status } : app
          )
        );
      } else {
        alert("Failed to update application status");
      }
    } catch (error) {
      console.error("Error updating status:", error);
    }
  };

  return (
    <div className="container my-4">
      <h2 className="text-center mb-4"><b>{jobTitle}</b></h2>
      {applications.length === 0 ? (
        <p className="text-center">No applications available for this job.</p>
      ) : (
        <table className="table table-bordered">
          <thead className="table-light">
            <tr>
              <th>Applicant Name</th>
              <th>Applicant Email</th>
              <th>Status</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {applications.map((application) => (
              <tr key={application.id}>
                <td>{application.employeeDTO.name}</td>
                <td>{application.employeeDTO.email}</td>
                
                <td>{application.status}</td>
                <td>
                  <select
                    className="form-select"
                    onChange={(e) => updateStatus(application.id, e.target.value)}
                  >
                    <option value="">Update Status</option>
                    <option value="Approved">Approved</option>
                    <option value="Rejected">Rejected</option>
                  </select>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default JobApplications;
