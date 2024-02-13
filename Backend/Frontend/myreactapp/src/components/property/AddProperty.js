import React, { useState } from 'react';
import axios from 'axios';
import { toast } from 'react-toastify';
import { BASE_URL } from "../../url";



const AddProperty = () => {

    const [propertyDetails, setPropertyDetails] = useState({
        propertyId: 0,
        userId: 0,
        instruction: "",
        isAvailable: 0,
        deposite: 0,
        rent: 0,
        society: "",
        landmark: "",
        cityName: "",
        area: "",
        state: "",
        pinCode: 0,
        categoryName: "",
        description: ""
    });

    const handleChange = (args) => {
        var copyOfAddPrpperty = { ...propertyDetails };
        copyOfAddPrpperty[args.target.name] = args.target.value;
        setPropertyDetails(copyOfAddPrpperty);
    }

    const handleReset = () => {
        // Reset the form fields to their initial state
        setPropertyDetails({
            propertyId: 0,
            userId: 0,
            instruction: "",
            isAvailable: 0,
            deposite: 0,
            rent: 0,
            society: "",
            landmark: "",
            cityName: "",
            area: "",
            state: "",
            pinCode: 0,
            categoryName: "",
            description: ""
        });
    };

    const submitHandeler = () => {

        if (propertyDetails.userId === 0)
            toast.error("Please enter userID");
        else if (propertyDetails.isAvailable > 1)
            toast.error("Please enter propertyStatus");
        else if (propertyDetails.deposite !== 0)
            toast.error("Please enter deposite");
        else if (propertyDetails.rent === 0)
            toast.error("Please enter rent");
        else if (propertyDetails.cityName === "")
            toast.error("Please enter cityname");
        else if (propertyDetails.categoryName === "")
            toast.error("Please enter categoryName");
        else {

            axios
                .post(`${BASE_URL}/users/addproperty`, propertyDetails)
                .then((response) => {
                    // Handle success, e.g., show a success message
                    toast.success("PropertyDtails Added");
                    console.log('Property added successfully', response.data);
                })
                .catch((error) => {
                    // Handle errors, e.g., show an error message
                    toast.success("Something Error Occure");
                    console.error('Error adding property');
                });

        };
    }

    return (
        <div >
            <div className="container col-8 col-xl-6 my-4 pt-2 pb-5 shadow bg-body rounded">
                <form onSubmit={submitHandeler}>
                    <center>
                        <h4 className="heading">Add Property Details</h4>
                    </center>
                    <div className="form-group">
                        <label>PropertyId:</label>
                        <input
                            type="number"
                            className="form-control"
                            name="propertyId"
                            value={propertyDetails.propertyId}
                            required
                            onChange={handleChange}
                            placeholder="Enter propertyId"
                            disabled
                        />
                    </div>

                    <div className="form-group">
                        <label>UserId:*</label>
                        <input
                            type="text"
                            className="form-control"
                            name="userId"
                            value={propertyDetails.userId}
                            required
                            onChange={handleChange}
                            placeholder="Enter UserId"
                        />
                    </div>

                    <div className="form-group">
                        <label>Property Status:*</label>
                        <input
                            type="number"
                            className="form-control"
                            name="isAvailable"
                            min="0"
                            max="1"
                            value={propertyDetails.isAvailable}
                            required
                            onChange={handleChange}
                            placeholder="Enter Your Rent"
                        />
                    </div>

                    <div className="form-group">
                        <label>Instruction:</label>
                        <input
                            type="text"
                            className="form-control"
                            name="instruction"
                            value={propertyDetails.instruction}
                            required
                            onChange={handleChange}
                            placeholder="Add Instruction"
                        />
                    </div>

                    <div className="form-group">
                        <label>Deposite:*</label>
                        <input
                            type="number"
                            className="form-control"
                            name="deposite"
                            value={propertyDetails.deposite}
                            required
                            onChange={handleChange}
                            placeholder="Add Deposite"
                        />
                    </div>

                    <div className="form-group">
                        <label>Rent:*</label>
                        <input
                            type="number"
                            className="form-control"
                            name="Rent"
                            value={propertyDetails.rent}
                            required
                            onChange={handleChange}
                            placeholder="Enter Your Rent"
                        />
                    </div>

                    <div className="form-group">
                        <label>FlatCatagory:*</label>
                        <input
                            type="text"
                            className="form-control"
                            name="categoryName"
                            value={propertyDetails.categoryName}
                            required
                            onChange={handleChange}
                            placeholder="eg: 1BHK,2BHK,3BHK"
                        />
                    </div>

                    <div className="form-group">
                        <label>Society:</label>
                        <input
                            type="text"
                            className="form-control"
                            name="Society"
                            value={propertyDetails.society}
                            required
                            onChange={handleChange}
                            placeholder="Enter Your Society Name"
                        />
                    </div>

                    <div className="form-group">
                        <label>Landmark:</label>
                        <input
                            type="text"
                            className="form-control"
                            name="landmark"
                            value={propertyDetails.landmark}
                            required
                            onChange={handleChange}
                            placeholder="Enter Your Landmark"
                        />
                    </div>

                    <div className="form-group">
                        <label>Area:</label>
                        <input
                            type="text"
                            className="form-control"
                            name="Area"
                            value={propertyDetails.area}
                            required
                            onChange={handleChange}
                            placeholder="Enter Your Landmark"
                        />
                    </div>

                    <div className="form-group">
                        <label>State:</label>
                        <input
                            type="text"
                            className="form-control"
                            name="State"
                            value={propertyDetails.state}
                            required
                            onChange={handleChange}
                            placeholder="Enter Your State eg:MAHARASHTRA"
                        />
                    </div>

                    <div className="form-group">
                        <label>City Name:*</label>
                        <input
                            type="text"
                            className="form-control"
                            name="City"
                            value={propertyDetails.city}
                            required
                            onChange={handleChange}
                            placeholder="Enter Your City Name eg:PUNE"
                        />
                    </div>

                    <div className="form-group">
                        <label>Pincode:</label>
                        <input
                            type="number"
                            className="form-control"
                            maxLength="6"
                            name="Pincode"
                            value={propertyDetails.city}
                            required
                            onChange={handleChange}
                            placeholder="Enter Your City Name eg:PUNE"
                        />
                    </div>

                    <div className="form-group">
                        <label>Description:</label>
                        <input
                            type="text"
                            className="form-control"
                            name="description"
                            value={propertyDetails.description}
                            required
                            onChange={handleChange}
                            placeholder="Add Instruction"
                        />
                    </div>
                    <br/>
                    <br/>
                    <center>
                        <button type="submit" className="btn btn-info ms-5" >
                            Add Property
                        </button>
                        <button type="reset" className="btn btn-warning ms-2" onClick={handleReset}>
                            Reset
                        </button>
                    </center>
                </form>

            </div>
        </div>
    )
}

export default AddProperty;