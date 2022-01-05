import React from 'react';
import UserService from '../services/UserService';

class UserComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount(){
        UserService.getUsers().then((response) => {
            this.setState({ users: response.data})
        });
    }

    searchBy(e) {
        // e.preventDefault();

        var identifier =  e.target.elements.userId.value;
        var name =  e.target.elements.name.value;
        var byear =  e.target.elements.byear.value;
        var dyear =  e.target.elements.dyear.value;
        var profession =  e.target.elements.profession.value;

        console.log(dyear);

        UserService.getUsersById(identifier, name, byear, dyear, profession).then((response) => {
            this.setState({ users: response.data})
        });
    }

    render (){
        return (
            <div>
                <h1 className = "text-center"> IMDB Persons List</h1>

                <form onSubmit={this.searchBy}>
                    <button className="btn btn-refresh" type="submit">
                        Search
                    </button>
                    <table className = "table table-striped">
                        <thead>
                            <tr>
                                <td> id </td>
                                <td> Person ID <input type="text" name="userId" /> </td>
                                <td> Name <input type="text" name="name" /> </td>
                                <td> Birth Year <input type="text" name="byear" /></td>
                                <td> Death Year <input type="text" name="dyear" /></td>
                                <td> Profession <input type="text" name="profession" /></td>
                            </tr>

                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user =>
                                    <tr key = {user.id}>
                                        <td> {user.id}</td>
                                        <td> {user.identifier}</td>
                                        <td> {user.name}</td>
                                        <td> {user.birthYear}</td>
                                        <td> {user.deathYear}</td>
                                        <td> {user.profession}</td>
                                    </tr>
                                )
                            }

                        </tbody>
                    </table>
                </form>
            </div>
        )
    }
}

export default UserComponent