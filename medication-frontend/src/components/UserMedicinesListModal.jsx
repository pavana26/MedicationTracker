import React, { Component } from 'react';
import MedicineService from '../services/MedicineService';

import moment from 'moment';

class UserMedicinesListModal extends Component {
    constructor (props){
        super(props)
        this.state = {
            userId:this.props.match.params.uid,
            usermedicineslist : [],
            fromDate: moment().subtract(6, 'days').toDate(),
            toDate:moment().toDate()  ,
            modalShow :false          
        }
        this.addUserMedicine = this.addUserMedicine.bind(this);
        this.editUserMedicine = this.editUserMedicine.bind(this);
             
    }
    componentDidMount(){
       let searchrequest = { fromDate:this.state.fromDate,toDate:this.state.toDate}
       let uid = this.state.userId
       MedicineService.getUserMedicines(searchrequest,this.state.userId).then((res) => {        
            this.setState({ usermedicineslist: res.data.userMedicineList});   
                  
       }).catch(error => {
        this.props.history.push('/error');
      });     
       
    }
   
   
    addUserMedicine(){
       let user =this.state.userId;
       this.props.history.push(`/addusermedicines/_add/${user}`);
    }

    editUserMedicine(userMedicineId){       
        let user =this.state.userId;
        this.props.history.push(`/addusermedicines/${userMedicineId}/${user}`);
    }
    render() {
       
        return (
            
            <div>
                <button type="button" class="btn btn-primary" style ={{"float":"right"}}onClick={this.addUserMedicine}>ADD MEDICINES</button>
               <div className="row">
               
               </div>

               <div className="row">
                   <table className="table table-striped table-bordered">
                       
                       <thead>
                             <tr>
                                 <th>Date</th>                                
                                 <th>Medicines</th>                                                   
                            </tr>
                       </thead>
                       
                        <tbody>
                            {
                                this.state.usermedicineslist.map(
                                usermedicines =>
                                
                                <tr key={usermedicines.dayOfWeek} >
                                <td> {usermedicines.dateOfWeek} {usermedicines.dayOfWeek}</td>                               
                                <td>
                                <div className="row">
                                <table className="table  ">
                                   <tbody>
                                    {
                                        usermedicines.medDetail.map(med =>
                                        
                                        <tr key={med.usermedicineId}>
                                            <td>{med.medicineName}</td>
                                            <td>{med.amount}</td>
                                            <td>{med.userMedicineId}</td>
                                            <td>{med.frequency}</td>
                                            <td>{med.instructions}</td>
                                            <td><button  onClick= { () => this.editUserMedicine(med.usermedicineId)} className="btn btn-info">Update</button></td>
                                        </tr>
                                        )                                                                         
                                    }
                                    </tbody>
                                </table>
                                </div>
                                </td>
                                 <td>
                                </td> 
                                </tr>            
                             )                        
                        }
                              
                        </tbody>               
                      
                   </table>

               </div>
            </div>
        );
    }
}

export default UserMedicinesListModal;