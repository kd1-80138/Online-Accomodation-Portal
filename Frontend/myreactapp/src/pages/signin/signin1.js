import { useState } from "react";
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import axios from 'axios';
import { BASE_URL } from "../../url";
import { toast } from 'react-toastify'
import {MDBContainer, MDBCard, MDBCardBody, MDBCardImage,MDBRow, MDBCol, MDBInput} from 'mdb-react-ui-kit';

function Login() {

  const [loginCredentials, setLoginCredentialls] = useState({ email: "", password: "" });

  const OnTextChage = (args) => {
    var copyOfLoginCredentials = { ...loginCredentials };
    copyOfLoginCredentials[args.target.name] = args.target.value;
    setLoginCredentialls(copyOfLoginCredentials);
  }
  
  const loginAction = () => {
    fetch("https://localhost:8080/users/signin", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(loginCredentials),
    })
      .then((result) => {
        console.log("result", result);
        result.json().then((res) => {
          console.log(res.mesg);
          
          if (res.mesg === "Successful Authentication!") {
            console.log("Got the success response");

            if (res.jwt != null) {
              sessionStorage.setItem("jwtToken", res.jwt);
              
              sessionStorage.setItem("role",res.role);
            }

            if (res.jwt !== null) {
              toast.success(res.mesg, {
                position: "top-center",
                autoClose: 1000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
              });
              setTimeout(() => {
                window.location.href = "/home";
                 
              }, 1000); 
            } else {
              toast.error(res.mesg, {
                position: "top-center",
                autoClose: 1000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
              });
            }
          
          }
        });
      })
      .catch((error) => {
        console.error(error);
        toast.error("It seems server is down", {
          position: "top-center",
          autoClose: 1000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
        });
      });
    
    
  };

  return (
    <MDBContainer className="my-5">
      <MDBCard>
      <MDBRow className='g-0'>
      <MDBCol md='6'>
            <MDBCardImage src={require("../../assets/logo.png")} alt="logo" className='rounded-start w-100'/>
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
              value={loginCredentials.email}
              onChange={OnTextChage}
              placeholder="Enter your email here"
              name="email"
             className="form-control"
            />
          </div>
          <br/>
          <br/>
          <div>
            <MDBInput
              wrapperClass=""
              id='formControlLg'  
              type="password"
              size="lg"
              value={loginCredentials.password}
              onChange={OnTextChage}
              placeholder="Enter your password here"
              name="password"
              className="form-control"
            />
            <br />
            <br/>
            <button className="btn btn-primary px-5"  onClick={loginAction}>
              LogIn
            </button>
            <br/>
            <a className="small text-muted" href="#!">Forgot password?</a>
              <p className="mb-5 pb-lg-2" style={{color: '#393f81'}}>Don't have an account? <a href="/Register" style={{color: '#393f81'}}>Register here</a></p>
          </div>
          </MDBCardBody>
          </MDBCol>
          </MDBRow>
        </MDBCard>
    </MDBContainer>
    
  );
}

export default Login;




