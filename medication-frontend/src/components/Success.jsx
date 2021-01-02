import React, { Component } from "react";


class Success  extends Component {
  constructor(props) {
    super(props);  
    this.homePage=this.homePage.bind(this);
  }

  homePage(){
    this.props.history.push('/');
  }

  render() {
    return (
      <div>
        <br/><br/><br/>
        <h1 style={{ "textAlign":"center"}}>Registered Successfully !!! </h1>
        <br/><br/><br/><br/><br/>
        <button className="btn btn-primary mx-auto d-block"  onClick={this.homePage} >Home</button>
      </div>
    );
  }
}

export default Success;