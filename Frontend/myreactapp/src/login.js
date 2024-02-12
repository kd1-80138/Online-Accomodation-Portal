import { useState } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import axios from 'axios';
import { MDBBtn,MDBContainer, MDBCard, MDBCardBody, MDBCardImage,MDBRow, MDBCol,MDBIcon, MDBInput} from 'mdb-react-ui-kit';
import Home from "./Home";
import { Redirect } from "react-router-dom/cjs/react-router-dom.min";

function Login() {
  const [email, setEmail] = useState("");
  var [emailError, setEmailError] = useState("");
  const [password, setPassword] = useState("");
  var [passwordError, setPasswordError] = useState("");
  const [loginCredentials, setLoginCredentialls] = useState({ email: "", password: "" });
  const [loginMessage,setLoginMessage] = useState("");

  const url = "http://127.0.0.1:8080/user/login";

  const OnTextChange = (args) => {
    setEmail(args.target.value);
  };

  const OnTextChangePassword = (args) => {
    setPassword(args.target.value);
  };

  const Validate = () => {
    //initially set to empty
    setEmailError("");
    setPasswordError("");

    if (email === "") {
      setEmailError("*Please Enter Your Email");
      return;
    }
    if (!/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(email)) {
      setEmailError("*Please enter a valid email");
      return;
    }
    if (password === "") {
      setPasswordError("*Please Enter your Password");
      return;
    }
    if (password.length < 8) {
      setPasswordError("*Password must be  8 characters or Longer");
      return;
    }
    setLoginCredentialls({ email: email, password: password });
    debugger;
    console.log(loginCredentials.email, loginCredentials.password);
    //validating user using data and rendering home page

    axios.post(url, loginCredentials).then((result)=>{
      setLoginMessage("Login Successfull  !!");
   }).catch((error)=>{
    setLoginMessage("Invalid User");
   })
        
  };

  return (
    <MDBContainer className="my-5">
      <MDBCard>
      <MDBRow className='g-0'>
      <MDBCol md='6'>
            <MDBCardImage src={require("./logo.png")} alt="logo" className='rounded-start w-100'/>
          </MDBCol>
          <MDBCol md='6'>
            <MDBCardBody className='d-flex flex-column'>
           
          <div>
          <h5 className="fw-normal my-3 pb-1" style={{letterSpacing: '1px'}}>Sign into your account </h5>
            <MDBInput
              wrapperClass=""
              id='formControlLg'
              type='email' 
              size="lg"
              value={email}
              onChange={OnTextChange}
              placeholder="Enter your email here"
              name="email"
             className="form-control"
            />
            <label className="text-danger">{emailError}</label>
          </div>
          
          <div>
            <MDBInput
              id='formControlLg'  
              type="password"
              size="lg"
              value={password}
              onChange={OnTextChangePassword}
              placeholder="Enter your password here"
              name="password"
              className="form-control"
            />
            <label className="text-danger">{passwordError}</label>
            <br />
            <br/>
            {/* {<MDBBtn className="mb-4" color='dark' size='lg'>Login</MDBBtn> } */}
            <button className="btn btn-primary px-5"  onClick={Validate}>
              LogIn
            </button>
            <br/>
            <a className="small text-muted" href="#!">Forgot password?</a>
              <p className="mb-5 pb-lg-2" style={{color: '#393f81'}}>Don't have an account? <a href="/register" style={{color: '#393f81'}}>Register here</a></p>
             <div>{loginMessage} </div>
             {loginMessage=== "Login Successfull  !!" ? <Redirect to="/Contact"/> : <Redirect  to="/login" />}  
          </div>
          </MDBCardBody>
          </MDBCol>
          </MDBRow>
        </MDBCard>
    </MDBContainer>
    
  );
}

export default Login;
