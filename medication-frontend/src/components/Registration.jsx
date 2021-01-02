import React, { Component } from "react";
import UserService from "../services/UserService";

class Registration extends Component {
  constructor(props) {
    super(props);

    this.state = {
      userName: "",
      password: "",
      email: "",
      phone: "",
      address: "",
      registrationErrors: ""
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handleSubmit(event) {
   let user = {userName: this.state.userName,password: this.state.password, email: this.state.email, phone: this.state.phone, address: this.state.address}; 

   UserService.createUser(user)
      .then(response => {
          console.log(response.data);
        if (response.data.message === 'success') {
            this.props.history.push('/success');
        }
      })
      .catch(error => {
        this.props.history.push('/error');
      });
    event.preventDefault();
  }

  cancel(){
    this.props.history.push('/');
  }
  render() {
    return (
      <div>
        <div className ="container">
          <div className ="row">
             <div className="card col-md-6 offset-md-3 offset-md-3">
                <h3 className="text-center">Registration  Form</h3>
                <div className="card-body">
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label >User Name</label>
                        <input name="userName" placeholder="userName" value={this.state.userName} onChange={this.handleChange} className="form-control" required/>
                    </div>  
                    <div className="form-group">
                        <label >Password</label>
                        <input type="password" name="password" placeholder="Password" value={this.state.password} onChange={this.handleChange} className="form-control" required />
                    </div> 
                    <div className="form-group">
                        <label >Email</label>
                        <input type="email" name="email" placeholder="email" value={this.state.email} onChange={this.handleChange} className="form-control"/>
                    </div>   
                    <div className="form-group">
                        <label >Phone</label>
                        <input name="phone" placeholder="phone" value={this.state.phone} onChange={this.handleChange} className="form-control" />                
                    </div>   
                    <div className="form-group">
                        <label >Address</label>
                        <input name="address" placeholder="address" value={this.state.address} onChange={this.handleChange} className="form-control" />
                    </div>                    
                    <button className="btn btn-success"  style={{marginLeft:"105px"}} type="submit">Register</button>
                    <button className="btn btn-danger" style={{marginLeft:"110px"}} onClick={this.cancel.bind(this)} >Cancel</button>
                
                                              
               
                </form>
                </div>
              </div> 
            </div> 
        </div>
      </div>
    );
  }
}

export default Registration;