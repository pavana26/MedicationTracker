import axios from 'axios';
const USER_URL = "http://localhost:8080/api/v1/user";

class UserService{

    getAuthentication(user){
        return axios.post(USER_URL,user);
    }

    createUser(user){
        return axios.post(USER_URL + '/registration',user);
    }

   
}

export default new UserService()