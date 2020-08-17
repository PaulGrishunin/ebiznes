import React, {Component} from 'react';
import {Table} from "reactstrap";

class Users extends Component {

    constructor() {
        super();
        this.state = {
            users: [],
        };
    }

    componentDidMount() {
        var url = "http://localhost:9000/users"

        fetch(url, {
            mode: 'cors',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'http://localhost:3000',
            },
            method: 'GET',
        })
            .then(results => {
                return results.json();
            }).then(data => {
            let users = data.map((usr) => {
                return (
                    <div key={usr.id} >
                        <div className="name">{usr.id}. <b>{usr.login}</b></div>
                        <div><i>{usr.email}</i></div>
                        <div>{usr.admin}</div>
                    </div>

                )
            })
            this.setState({users: users})
        })
    }

    render() {
        return (
            <div style={{display: 'flex',  justifyContent:'center', alignItems:'top', height: '100vh', marginLeft: '10vh', marginTop: '5vh', marginRight: '10vh'}}>
            <Table>
                <thead>
                <tr>
                    <th>USERS:</th>
                </tr>
                </thead>
                <tbody>
                    <div className="users">
                        {this.state.users}
                    </div>
                </tbody>
            </Table>
                </div>
        )
    }
}

export default Users;