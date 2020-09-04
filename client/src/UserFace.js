import React, {Component} from 'react';


class UserFace extends Component {

    constructor() {
        super();
        this.state = {
            user: [],
        };
    }

    componentDidMount() {
        var url = "http://localhost:9000/user/" + this.props.user

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
                let lnkUserPage = "/user/" + usr.id;
                let lnkImage = "/img/user/" + usr.id + ".png";

                let user =
                    <a href={lnkUserPage}>
                        <div className="userFace">
                            <img className="userFace" src={lnkImage} width='64px' height='64px'/>
                            <p> {usr.login}</p>
                        </div>
                    </a>
                this.setState({ user: user });
            });
    }

    render() {
        return (
            <div className="user">
                {this.state.user}
            </div>
        )
    }
}

export default UserFace;
