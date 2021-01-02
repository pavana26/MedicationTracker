import React, { Component } from 'react';
import MedicineService from '../services/MedicineService';
class AddMedicine extends Component {

    constructor(props){
        super(props)
        this.state = {             
            medicineName:'' ,
            userId:this.props.match.params.uid       
        }  
        this.changemedicineName =this.changemedicineName.bind(this);       
        this.saveMedicine=this.saveMedicine.bind(this);
    }

    changemedicineName=(event) =>{
        this.setState({medicineName: event.target.value});
    }

    saveMedicine=(e) =>{
        e.preventDefault();
        let medicine ={medicineName: this.state.medicineName};
        let uid = this.state.userId;
        console.log('medicine=>'+JSON.stringify(medicine));
         
        MedicineService.createMedicine(medicine).then(res =>{
            console.log(res.data);
            this.props.history.push(`/addusermedicines/_add/${uid}`);                
        }).catch(error => {
            this.props.history.push('/error');
          });     
       
    }
    cancel(){
        let uid = this.state.userId;
        this.props.history.push(`/addusermedicines/_add/${uid}`);
    }
    render() {
        return (
            <div>
                <div className="card-body">
                <form>
                    <div className="form-group">
                        <label >Medicine Name</label>        
                        <input  placeholder="medicineName" name="medicineName" className="form-control"
                                        value={this.state.medicineName} onChange={this.changemedicineName}></input>
                    </div>      
                    <button className="btn btn-success" onClick={this.saveMedicine}>Save</button>
                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft:"10px"}}>Cancel</button>
                </form>
                </div>
            </div>
        );
    }
}

export default AddMedicine;