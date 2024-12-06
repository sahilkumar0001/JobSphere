import React from 'react'

export default function 
Contact() {
  return (
    <>
        <div className="banner contact-bnr">CONTACT US
        </div>
        <h2>GET IN TOUCH WITH US</h2>
        <div className="contactContainer">
            
            <div className="contact w-50">
            <form action="">

<label htmlFor="fname">First Name</label>
<input type="text" id="fname" name="firstname" required placeholder="Your name.."/>

<label htmlFor="lname">Last Name</label>
<input type="text" id="lname" name="lastname" required placeholder="Your last name.."/>

<label htmlFor="email">Email</label>
<input type="email" id="email" name="email" required placeholder="Your email name.."/>

<label htmlFor="subject">Subject</label>
<textarea id="subject" name="subject" required placeholder="Write something.." style={{height:"200px"}}></textarea>

<input type="submit" value="Submit" />

</form>

            </div>
            <br/>
        </div>
    </>
  )
}
