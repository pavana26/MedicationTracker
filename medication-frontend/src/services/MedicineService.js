import axios from 'axios';
const MEDICINE_URL = "http://localhost:8080/api/v1/medicines/";
const USER_MEDICINE_URL = "http://localhost:8080/api/v1/medicines/UserMedicine";

class MedicineService{
    
    getMedicines(){
        return axios.get(MEDICINE_URL);
    }

    createMedicine(medicine){ 
        alert('inside createMedicine')      
        return axios.post(MEDICINE_URL+'addmedicine',medicine);
        
    }
    getUserMedicines(searchrequest,userId){
         return axios.post(USER_MEDICINE_URL+'/search',searchrequest,{
             headers:{
                 'userId':userId
             }
         });
    }

  //  createUserMedicine(usermedicine){
    //    return axios.post(USER_MEDICINE_URL, usermedicine);
    //}

    getUserMedicineById(userMedicineId){
        return axios.get(USER_MEDICINE_URL + '/'+userMedicineId);
    }

    updateUserMedicine(usermedicine , userMedicineId){       
         return axios.put(USER_MEDICINE_URL + '/'+ userMedicineId, usermedicine);
    }
    deleteUserMedicineById(userMedicineId){
         return axios.delete(USER_MEDICINE_URL + '/'+userMedicineId);
    }
}

export default new MedicineService()