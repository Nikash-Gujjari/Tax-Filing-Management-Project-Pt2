// Example of a simple page component
import React from 'react';
import axios from 'axios';
import { useNavigate } from "react-router";
import{ useRef} from 'react';
import '../css/LoginPage.css';


export const LoginPage = (props) => {

    // Route Navigation
    const navigate = useNavigate();

    // References to HTML elements to change their style
    const userNameElement = useRef(null);
    const passwordElement = useRef(null);
    const  wrongTextRef = useRef(null);

    const goToHome = () => {
        navigate('/home');
    };

    const attemptLogin = async(event) => {
        // Prevent the browser from reloading the page
        event.preventDefault();        

        // getting the form values directly
        const username = event.target.username.value;      
        const password = event.target.password.value;      
   
        await axios.get('http://localhost:8080/cpa/login', {
                   params: {
                   username: `${username}`,
                   password: `${password}`
                   }})
                   .then(response => {
                       if(response.data){
                        // If we have a valid login, get the id of the login
                          axios.get('http://localhost:8080/cpa/username', {
                          params: {
                              username: `${username}`
                          }}).then(response => {
                            {props.setter(parseInt(response.data))};
                          });
                          goToHome();
                      } else {
                        wrongTextRef.current.textContent='Incorrect username or password';
                        userNameElement.current.value='';
                        passwordElement.current.value='';
                       }    
                   }).catch((error) => {
                       // handle error
                       console.log(error);
                     });
   };
  return (
    <div>
      <form onSubmit={attemptLogin} className="loginpage_form">
          <h1 className="loginpage_h1"> Tax Management System </h1>
          <h3 className="loginpage_h3">CPA Login Form</h3>
          <input ref={userNameElement} className="loginpage_input" type="text" class="normal_boxes" name="username" placeholder="Username"/>
          <input ref={passwordElement} className="loginpage_input" type="password" class="normal_boxes" name="password" placeholder="Password"/>
          <h6 className="loginpage_h6" ref={wrongTextRef}></h6>
          <button className="loginpage_button" type="submit">Login </button>
      </form>
    </div>
  );
}
