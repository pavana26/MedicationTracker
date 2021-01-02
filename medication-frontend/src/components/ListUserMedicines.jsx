import React, { Component } from 'react';
import MedicineService from '../services/MedicineService';
import CreateUserMedicine from './CreateUserMedicine';

class ListUserMedicines extends Component {
    constructor (props){
        super(props)
        this.state = {
            usermedicines : [],
            userId:''
        }
        this.addUserMedicine = this.addUserMedicine.bind(this);
        this.editUserMedicine = this.editUserMedicine.bind(this);
        this.deleteUserMedicine = this.deleteUserMedicine.bind(this);
    }
    componentDidMount(){
       
            MedicineService.getUserMedicines().then((res) => {
                this.setState({ usermedicines: res.data});
            });
      
       
    }
    addUserMedicine(){
        CreateUserMedicine.userId =this.state.userId;
        this.props.history.push(`/addusermedicines/_add`);
    }

    editUserMedicine(userMedicineId){       
        CreateUserMedicine.userId =this.state.userId; 
        this.props.history.push(`/addusermedicines/${userMedicineId}`);
    }

    deleteUserMedicine(userMedicineId){
        MedicineService.deleteUserMedicineById(userMedicineId).then((res) =>{
            this.setState({usermedicines: this.state.usermedicines.filter(usermedicine => usermedicine.userMedicineId !== userMedicineId )});
        });
    }
    render() {
        return (
            <div>
           
               <div className="row">
               <button type="button" class="btn btn-primary" onClick={this.addUserMedicine}>ADD MEDICINES</button>
               </div>

               <div className="row">
                   <table className="table table-striped table-bordered">
                       <thead>
                             <tr>
                                 <th>row1</th>
                                 <th></th>
                                 <th></th>
                                 <th></th>
                                 <th></th>
                                 <th></th>
                                 <th></th>

                            </tr>
                       </thead>
                       <tbody>
                           {
                               this.state.usermedicines.map(
                                  usermedicine =>
                                  <tr key ={usermedicine.userMedicineId}> 
                                    <td>{usermedicine.medicineId}</td>
                                    <td>{usermedicine.startDate}</td>
                                    <td>{usermedicine.endDate}</td>
                                    <td>{usermedicine.instructions}</td>
                                    <td><button onClick= { () => this.editUserMedicine(usermedicine.userMedicineId)} className="btn btn-info">Update</button></td>
                                    <td><button style={{"marginLeft":"10px"}} onClick= { () => this.deleteUserMedicine(usermedicine.userMedicineId)} className="btn btn-danger">Delete</button></td>
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

export default ListUserMedicines;