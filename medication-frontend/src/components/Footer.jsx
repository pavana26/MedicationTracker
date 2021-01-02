import React, { Component } from 'react';

class Footer extends Component {
    constructor(props){
        super(props)
        this.state = {
            
        }
    }
    render() {
        return (
            <div>
                <footer className="footer-copyright text-center py-3">              
                    <span className="text-muted " style={{"marginBottom": "0px"}} >All Right Reserved copyright@2020 for Pavana Bhat</span>              
                </footer>
            </div>
        );
    }
}

export default Footer;