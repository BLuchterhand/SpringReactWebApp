import axios from 'axios'

const USERS_REST_API_URL = 'http://localhost:8080/api/people';

// Testing, delete
// const USERS_REST_API_URL_ID = 'http://localhost:8080/api/people?userId=&name=Fred+Astaire&byear=&dyear=&profession=';
const USERS_REST_API_URL_ID = 'http://localhost:8080/api/people?userId=nm0000001&name=Fred+Astaire&byear=1899&dyear=1987&profession=soundtrack,actor,miscellaneous';


class UserService {

    getUsers(){
        return axios.get(USERS_REST_API_URL);
    }

    getUsersById(_identifier, _name, _byear, _dyear, _profession){
        
        return axios.get("http://localhost:8080/api/people", { params: {
            userId: _identifier,
            name: _name,
            byear: _byear,
            dyear: _dyear,
            profession: _profession
        } }); // replace with form data
    }
}

export default new UserService();