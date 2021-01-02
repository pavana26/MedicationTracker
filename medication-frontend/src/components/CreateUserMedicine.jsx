import React, { Component } from 'react';
import DatePicker from "react-datepicker";
import 'react-datepicker/dist/react-datepicker.css'
import moment from 'moment';
import MedicineService from '../services/MedicineService';

class CreateUserMedicine extends Component {
    constructor(props){
        super(props)
        this.state = {
            usermedicineId:this.props.match.params.id,
            medicines:[],   
            medicineName:'',        
            toDate:'',
            instructions:'',
            fromDate: new Date(),
            userId:this.props.match.params.uid
        }
        this.changemedicineNohandler=this.changemedicineNohandler.bind(this);
        this.changefromDatehandler=this.changefromDatehandler.bind(this);
        this.changetoDatehandler=this.changetoDatehandler.bind(this);
        this.changespecialInhandler=this.changespecialInhandler.bind(this);
        this.saveOrUpdateMedicineInfo=this.saveOrUpdateMedicineInfo.bind(this);
        this.addMedicineInfo=this.addMedicineInfo.bind(this);
    }
    componentDidMount(){
        MedicineService.getMedicines().then( (res) =>{
           this.setState({ medicines: res.data})
       })
       if(this.state.usermedicineId === '_add' && this.state.userId === ''){
            return;
       }else{
        MedicineService.getUserMedicineById(this.state.usermedicineId).then( (res) => {
           
            let usermedicine = res.data;                       
            this.setState({
               
                medicineName: usermedicine.medicineName,
                toDate: moment(usermedicine.endDate).toDate(),
                fromDate: moment(usermedicine.startDate).toDate(),
                instructions: usermedicine.instructions
            })
        });
       }       
    }
    changemedicineNohandler=(event) =>{
        this.setState({medicineName: event.target.value});
    }
    changefromDatehandler=(date) =>{
        this.setState({fromDate: date});
    }
    changetoDatehandler=(date) =>{
        this.setState({toDate: date});
    }
    changespecialInhandler=(event) =>{
        this.setState({instructions: event.target.value});
    }

    addMedicineInfo(){
        console.log(this.state.userId);
        this.props.history.push(`/addmedicine/${this.state.userId}`);
    }
    saveOrUpdateMedicineInfo=(e) =>{
        e.preventDefault();
        let usermedicine ={medicineName: this.state.medicineName,fromDate: this.state.fromDate, toDate: this.state.toDate, instructions: this.state.instructions};
        console.log('usermedicine=>'+JSON.stringify(usermedicine));
        let uid = this.state.userId;
        if(this.state.usermedicineId === '_add'){
            MedicineService.createUserMedicine(usermedicine).then(res =>{
                this.props.history.push(`/dashboard/${uid}`);
            }).catch(error => {
                this.props.history.push('/error');
             })
        
       }else{
            MedicineService.updateUserMedicine( usermedicine,this.state.usermedicineId).then(
                res => {
                    this.props.history.push(`/dashboard/${uid}`);
            }).catch(error => {
                this.props.history.push('/error');
            });
       }
       
    }

    cancel(){
        let uid = this.state.userId;
        this.props.history.push(`/dashboard/${uid}`);
    }
    getTitle(){
        if(this.state.usermedicineId === '_add'){
            return <h3 className="text-center">Add Medicine Info Form</h3>;
       }else{
            return <h3 className="text-center">Update Medicine Info </h3>;
       }
    }
    render() {
        return (
            <div>
               <div className="container">
                    <div className ="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            {
                                this.getTitle()
                            }
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label >Medicine</label>
                                        <select   name="medicineName" className="form-control"
                                        value={this.state.medicineName} onChange={this.changemedicineNohandler}>
                                            {this.state.medicines.map(medicine =>
                                             <option key={medicine.medicineId} >{medicine.medicineName}</option>
                                                )}
                                        </select>
                                        <div className="form-group">
                                        <button className="btn btn-link" onClick={this.addMedicineInfo}>Add Your Medicine Name</button>
                                       
                                        </div>
                                    </div>
                                    <div className="form-group">
                                    <label>From Date</label>
                                    <DatePicker selected={this.state.fromDate} onChange={this.changefromDatehandler} name="fromDate" dateFormat="dd/MM/yyyy" />                                                
                                    </div>
                                    <div className="form-group">   
                                        <label>To Date </label>
                                        <DatePicker selected={this.state.toDate} onChange={this.changetoDatehandler} name="toDate" dateFormat="dd/MM/yyyy" />                                        
              
                                    </div>
                                    <div className="form-group">
                                        <label >Special Instructions</label>
                                      
                                        <input  placeholder="instructions" name="instructions" className="form-control"
                                        value={this.state.instructions} onChange={this.changespecialInhandler}></input>
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveOrUpdateMedicineInfo}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft:"10px"}}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
               </div>
            </div>
        );
    }
}

export default CreateUserMedicine;