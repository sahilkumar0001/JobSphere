import React from 'react'
import JobList from '../components/employer/JobList'
import Contact from '../components/Contact'
import About from '../components/About'

export default function Home() {
  return (
    <div>
        <JobList/>
        <About/>
        <Contact/>
    </div>
  )
}
