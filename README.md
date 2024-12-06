
# 🌟 Job Portal System  

_A full-stack web application designed to connect job seekers (employees) with job providers (employers)._  

---

## 📋 Features  

### For Employees:  
- 🔍 View available job postings.    
- 📊 Track application status.  

### For Employers:  
- ✏️ Post job openings.  
- 👀 View applications for posted jobs.  
- ⚙️ Update application status (e.g., Pending, Approved, Rejected).  

---

## 🛠 Tech Stack  

**Frontend:**  
- React.js  
- Bootstrap  

**Backend:**  
- Spring Boot  
- RESTful APIs  

**Database:**  
- MySQL  

---

## 🌐 System Architecture  

The system follows a **3-tier architecture**:  

1. **Frontend (Client-Side):**  
   - React handles the user interface.  
   - Communicates with the backend via APIs.  

2. **Backend (Server-Side):**  
   - Spring Boot manages business logic and data processing.  

3. **Database:**  
   - MySQL stores user, job, and application data.  

---

## 📊 Database Schema  

### Employee Table  

| Column     | Type      | Description                |  
|------------|-----------|----------------------------|  
| `id`       | INT       | Primary Key                |  
| `name`     | VARCHAR   | User's full name           |  
| `email`    | VARCHAR   | User's email address       |  
| `password` | VARCHAR   | Hashed password            |  
| `role`     | VARCHAR   | Role (Employee/Employer)   |  

### Employer Table  

| Column     | Type      | Description                |  
|------------|-----------|----------------------------|  
| `id`       | INT       | Primary Key                |  
| `companyName`     | VARCHAR   | User's full name           |  
| `email`    | VARCHAR   | User's email address       |  
| `password` | VARCHAR   | Hashed password            |  
| `role`     | VARCHAR   | Role (Employee/Employer)   | 

### Jobs Table  

| Column        | Type      | Description                |  
|---------------|-----------|----------------------------|  
| `id`          | INT       | Primary Key                |  
| `title`       | VARCHAR   | Job title                  |  
| `description` | TEXT      | Job description            |  
| `location`    | VARCHAR   | Job location               |  
| `salary`      | DECIMAL   | Job salary                 |  
| `employer_id` | INT       | Foreign Key to Users Table |  

### Applications Table  

| Column         | Type      | Description                |  
|-----------------|-----------|----------------------------|  
| `id`           | INT       | Primary Key                |  
| `job_id`       | INT       | Foreign Key to Jobs Table  |  
| `employee_id`  | INT       | Foreign Key to Users Table |  
| `resume`       | TEXT      | Base64 string of the resume|  
| `status`       | ENUM      | Status of application      |  

---

## 🔑 Authentication Process  

- **Login:**  
  Users log in via Spring Security with Basic Authentication.  

- **Role-Based Access Control:**  
  - `ROLE_EMPLOYEE`: Access to view jobs and apply.  
  - `ROLE_EMPLOYER`: Access to post jobs and manage applications.  

---

## 🚀 How to Run  

### Backend Setup:  
1. Clone the repository:  
   ```bash  
   git clone <repository-url>  
   cd JobSphere  
   ```  

2. Configure the database in `application.properties`:  
   ```properties  
   spring.datasource.url=jdbc:mysql://localhost:3306/job_portal  
   spring.datasource.username=your_username  
   spring.datasource.password=your_password  
   ```  

3. Start the backend server:  
   ```bash  
   ./mvnw spring-boot:run  
   ```  

### Frontend Setup:  
1. Navigate to the frontend folder:  
   ```bash  
   cd jobsphere  
   ```  

2. Install dependencies:  
   ```bash  
   npm install  
   ```  

3. Start the frontend server:  
   ```bash  
   npm run dev  
   ```  

4. Open your browser at `http://localhost:5173`.  
 

---

## 🛑 Challenges Faced  

1. **CORS Errors:**  
   - Solved by proper Spring Security and React configurations.  

2. **Role-Based Access:**  
   - Implemented using Spring Security and frontend route guards.  


---

## 🔮 Future Enhancements  

- 🌟 Advanced job filters (e.g., location, salary range).  
- 🌟 Notifications for application updates (email or in-app).  
- 🌟 Integration with third-party cloud services (e.g., AWS, Google Drive).
- 🌟 Integrate real time chat and video conference

---

## 🤝 Contributing  

Contributions are welcome! Follow these steps:  
1. Fork the repository.  
2. Create a new branch:  
   ```bash  
   git checkout -b feature-name  
   ```  
3. Commit and push your changes:  
   ```bash  
   git push origin feature-name  
   ```  
4. Submit a pull request for review.  

---


## 📞 Contact  

- **Developer:** Sahil Kumar  
- **Email:** sahil.sk6862@gmail.com  
- **GitHub:** [sahilkumar0001](https://github.com/sahilkumar0001)  
- **LinkedIn:** [Sahil Kumar](https://linkedin.com/in/sahilkumar-code)  

---
