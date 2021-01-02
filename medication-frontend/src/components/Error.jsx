import React, { Component } from "react";


class Error  extends Component {
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
        <h1 style={{ "textAlign":"center"}}>Oops!!!Something Went Wrong  </h1>
        <br/><br/><br/><br/><br/>
        <button className="btn btn-primary mx-auto d-block"  onClick={this.homePage} >Home</button>
      </div>
    );
  }
}

export default Error;