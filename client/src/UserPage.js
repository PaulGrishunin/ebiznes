import React, {Component} from 'react';

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
                                    <div id="userAvatar">
                                        <img id='circle' src={lnkImage} alt='' width='128px' height='128px'/>
                                    </div>
                                </a>
                                <td id="right" text-align='left'>
                                    <h2>
                                        <p >{adminBadge} Login: {usr.login}</p>
                                       Email: {usr.email}
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
            <div id="frame">
                {this.state.user}
            </div>
        )
    }
}

export default UserPage;