import React, {Component} from 'react';
import './User.css';

class UserPage extends Component {

    constructor() {
        super();
        this.state = {
            user: [],
        };
    }

    componentDidMount() {
        var url = "http://localhost:9000/user/" + this.props.match.params.user

        fetch(url, {
            mode: 'cors',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'http://localhost:3000',
            },
            method: 'GET',
        }).then(response => response.json())
            .then(usr => {
                console.log(usr);
                let lnkUserPage = "/user/" + usr.id;
                let lnkImage = "/img/user/" + usr.id + ".png";
                let adminBadge = "";
                if(usr.admin) adminBadge = "[Admin]"
                let user =
                    <div style={{ justifyContent:'center', alignItems:'top',marginLeft: '10vh', marginTop: '20px', marginRight: '10vh'}}>

                        <table id="fullWidth">
                            <tr>
                                <a href={lnkUserPage}>
                                    <div className="userFace">
                                        <img  src={lnkImage} alt='' width='128px' height='128px'/>
                                    </div>
                                </a>
                                <td className="left" >
                                    <h2>
                                        <p ><b> Login:</b> {usr.login}</p>
                                        <b>Email:</b> {usr.email}
                                        <p>{adminBadge}</p>
                                    </h2>
                                </td>
                            </tr>
                        </table>
                    </div>
                this.setState({ user: user });
            });
    }

    render() {
        return (
            <div className="userPage">
                {this.state.user}
            </div>
        )
    }
}

export default UserPage;