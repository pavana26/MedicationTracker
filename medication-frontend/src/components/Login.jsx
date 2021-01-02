import React, { Component } from 'react';
import UserService from '../services/UserService';
class Login extends Component {
    constructor(props){
        super(props)
        this.state = {
            userName: "",
            password: "",
            loginErrors: ""
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);       
    }

    handleChange(event) {
        this.setState({
          [event.target.name]: event.target.value
        });
    }
   

    handleSubmit(event) {        
        let user = { userName: this.state.userName ,password: this.state.password};       
        UserService.getAuthentication(user)
          .then(response => {   
            console.log(response.data); 
            this.props.history.push(`/dashboard/${response.data.id}`);    
                  
          })
          .catch(error => {
            this.props.history.push('/error');
          });
        event.preventDefault();
      }
    render() {
        return (
            <div>
             <div className="card col-md-6 offset-md-3 offset-md-3">
             <h2 className="text-center"> LOGIN</h2>
             <form onSubmit={this.handleSubmit}>
             <div className="form-group">
                <label >User Name</label>
                <input name="userName" placeholder="" value={this.state.userName} onChange={this.handleChange} className="form-control" required />
            </div>
            <div className="form-group">
                <label >Password</label>
                <input type="password" name="password" placeholder="" value={this.state.password} onChange={this.handleChange} className="form-control" required />
            </div>
            <div className="form-group">
                <button className="btn btn-success" type="submit">Login</button>
            </div>
            <div className="form-group">
                <a href={"http://localhost:3000/register"}>Not Registered Yet? Register Here</a>
            </div>
            </form> 
            </div>  
            </div>
        );
    }
}

export default Login;