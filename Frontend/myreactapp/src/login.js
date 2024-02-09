import { useState } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import axios from 'axios';

function Login() 
{
    const [email,setEmail] = useState("");
    var [emailError ,setEmailError]=useState("");
    const [password,setPassword]=useState("");
    var [passwordError,setPasswordError]= useState("");  
    const [loginCredentials,setLoginCredentialls]= useState({email:"", password:""}); 

    const url = "http://127.0.0.1:9999/login";


    const OnTextChange= (args)=>{
            setEmail(args.target.value);

    } ;

    const OnTextChangePassword =(args)=>{
        setPassword(args.target.value);
    };
    const Validate=()=>{
        //initially set to empty 
        setEmailError("");
        setPasswordError("");

        if(email===""){
                setEmailError("*Please Enter Your Email")
                return;
        }
        if (!/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(email)) {
            setEmailError("*Please enter a valid email")
            return
        }
        if(""===password)
        {
            setPasswordError("*Please Enter your Password");
            return ;
        }
        if(password.length<8){
            setPasswordError("*Password must be  8 characters or Longer");
            return;
        }
        setLoginCredentialls({email:email, password:password});
        debugger;
        console.log(loginCredentials.email , loginCredentials.password);
        //validating user using data and rendering home page 
        


    };
    
    return (
        <div className="container" >
            <center>
                <div className="container">
                    <h1 className="text-primary"> LogIn </h1>
                    <div> 
                    <input
                value={email}
                onChange={OnTextChange}
                placeholder="Enter your email here"
                name= "email" /> <br/>
            <label className="text-danger">{emailError}</label>
            </div>
            <br/>
            <br/>
                    <div>
                         <input
                           type="password"
                           value={password}
                           onChange={OnTextChangePassword}
                            placeholder="Enter your password here"
                        name= "password" /><br/>
                        <label className="text-danger">{passwordError}</label>
                        <br/>
                        <br/>
                        <button className="btn btn-primary" onClick={Validate}>LogIn</button>
                      
                   </div>



                </div>
                
            </center>
        </div>

     );
}

export default Login;