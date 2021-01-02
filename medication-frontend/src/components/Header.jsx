import React, { Component } from 'react';

class Header extends Component {
    constructor(props){
        super(props)
        this.state = {

        }
    }
    render() {
        return (
            <div style={{"text-align": "center"}}>
               <header>
                   <nav className="navbar navbar-expand-md navbar-white bg-primary variant-dark " style={{"fontSize":"30pt"}}>
                        <div>
                          <span style={{"marginLeft":"380px"}} > MEDICATION TRACKER APPLICATION</span> 
                        </div>
                   </nav>
                </header> 
            </div>
        );
    }
}

export default Header;