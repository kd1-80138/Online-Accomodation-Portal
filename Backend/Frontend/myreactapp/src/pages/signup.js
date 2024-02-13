import { useState } from "react";
import "../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import axios from 'axios';
import { BASE_URL } from "../url";
import { useNavigate } from "react-router";

import {toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function Register() {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [address, setAddress] = useState("");
    const [mobileNo, setmobileNo] = useState("");
    const [gender, setGender] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [userType, setUserType] = useState("");

    // used to navigate from one component to another
    const navigate = useNavigate();


    const registerPerson = () => {
        debugger
        if (firstName.length === 0) {
            toast.error("Please enter first name");
        } if (lastName.length === 0) {
            toast.error("Please enter last name");
        }else if (email.length === 0) {
            toast.error("Please enter email");
        }else if (mobileNo.length !== 10) {
            toast.error("Please enter phone number");
        } else if (password.length === 0) {
            toast.error("Please enter password");
        } else if (!/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email)) {
            toast.error("Please enter valid Email");
        } else if (confirmPassword.length === 0) {
            toast.error("Please confirm your password");
        } else if (password !== confirmPassword) {
            toast.error("Password does not match");
        }else if (userType == "Select" ) {
                toast.error("Select UserType");}
        else {
            const body = {
                firstName,
                lastName,
                mobileNo,
                address,
                gender,
                email,
                password,
                confirmPassword,
                userType,
            };
            console.log(body);
            axios
                .post(`${BASE_URL}/users/signup`, body)
                .then((response) => {
                    console.log(body);
                    // get the data from the response
                    const result = response.data;
                    console.log(result);
                    console.log(response.status);
                    if (response.status === 200) {
                        toast.success("Successfully signed up new user");

                        // navigate to the signin page
                         navigate("/signin");
                    } else {
                        toast.error(result.error);
                    }
                });
        }
    };

    return (
        <div>
            <div className="regisimage">

                <br></br>
                <div className="container col-8 col-xl-6 my-4 pt-2 pb-5 shadow bg-body rounded">
                    <h4 className="heading">Register</h4>

                    <div className="row mx-auto g-4">
                        <div className="col-md-6">
                            <label htmlFor="inputfirst_name4" className="form-label">
                                FirstName*
                            </label>
                            <input
                                onChange={(e) => {
                                    setFirstName(e.target.value);
                                }}
                                required="required"
                                type="text"
                                className="form-control"
                                id="inputfirst_name4"
                                placeholder="Enter your First Name"
                            />
                        </div>

                        <div className="col-md-6">
                            <label htmlFor="inputlast_name4" className="form-label">
                                LastName*
                            </label>
                            <input
                                onChange={(e) => {
                                    setLastName(e.target.value);
                                }}
                                type="text"
                                className="form-control"
                                id="inputlast_name4"
                                placeholder="Enter your Last Name"
                            />
                        </div>

                        <div className="col-md-6">
                            <label htmlFor="inputAddress4" className="form-label">
                                Address
                            </label>
                            <input
                                onChange={(e) => {
                                    setAddress(e.target.value);
                                }}
                                type="text"
                                className="form-control"
                                id="inputAddress4"
                                placeholder="Enter your Address"
                            />
                        </div>

                        <div className="col-md-6">
                            <label htmlFor="inputEmail4" className="form-label">
                                Email*
                            </label>
                            <input
                                onChange={(e) => {
                                    setEmail(e.target.value);
                                }}
                                required="required"
                                type="email"
                                className="form-control"
                                id="inputEmail4"
                                placeholder="Enter your Email"
                            />
                        </div>

                        <div className="col-md-6">
                            <label htmlFor="inputPhone4" className="form-label">
                                Mobile No*
                            </label>
                            <input
                                onChange={(e) => {
                                    setmobileNo(e.target.value);
                                }}
                                type="tel"
                                className="form-control"
                                id="inputPhone4"
                                placeholder="Enter your Mobile Without Prefix"
                            />
                        </div>
                        <div class="col-md-6">
                            <lable htmlFor="inputPhone4" className="form-label">
                                Gender
                            </lable>
                            <br />
                            <br />
                            <label class="form-check-label" htmlFor="male">
                                Male
                            </label>
                            <input
                                onChange={(e) => {
                                    setGender(e.target.value);
                                }}

                                className="form-check-input"
                                type="radio"
                                name="gender"
                                id="male"
                                value="male"
                            />

                            <label class="form-check-label" htmlFor="Female">
                                Female
                            </label>
                            <input
                                onChange={(e) => {
                                    setGender(e.target.value);
                                }}

                                className="form-check-input"
                                type="radio"
                                name="gender"
                                id="Female"
                                value="Female"
                            />
                        </div>

                        <div className="col-md-6">
                            <label htmlFor="inputPassword4" className="form-label">
                                Password*
                            </label>
                            <input
                                onChange={(e) => {
                                    setPassword(e.target.value);
                                }}
                                required="required"
                                type="password"
                                className="form-control"
                                id="inputPassword4"
                                placeholder="Enter your password"
                            />
                        </div>

                        <div className="col-md-6">
                            <label htmlFor="confirmPassword4" className="form-label">
                                Confirm Password*
                            </label>
                            <input
                                onChange={(e) => {
                                    setConfirmPassword(e.target.value);
                                }}
                                required="required"
                                type="password"
                                className="form-control"
                                id="confirmPassword4"
                                placeholder="Enter your password"
                            />
                        </div>


                        <div className="col-md-6">
                            <label htmlFor="userType" className="form-label">
                                User Type*
                            </label>
                            <select
                                onChange={(e) => {
                                    setUserType(e.target.value);
                                }}
                                value={userType}
                                className="form-select"
                                id="userType"
                                placeholder="Select User Type"
                                >
                                <option value="Select">Select</option>
                                <option value="owner">Owner</option>
                                <option value="customer">Customer</option>
                            </select>
                        </div>
                    </div>
                    <br />
                    <br />
                    <br />
                    <div className="col d-flex justify-content-md-center">
                        <button
                            onClick={registerPerson}
                            className="btn col-6 btn-outline-dark">
                            Sign up
                        </button>
                    </div>
                </div>
            </div>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>

        </div>
    );
}

export default Register;
