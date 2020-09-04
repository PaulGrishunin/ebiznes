import React, {Component} from 'react';
import {Menu} from "antd";
import {Link} from "react-router-dom";
import { HomeOutlined, CheckCircleOutlined, PercentageOutlined, ShoppingCartOutlined } from '@ant-design/icons';

class TopBar extends Component {

    constructor() {
        super();
        this.state = {
            loginFrame: "",
            loggedIn: "",
        };

        this.showLogin = this.showLogin.bind(this);
        this.hideLogin = this.hideLogin.bind(this);
    }

    logOut() {
        fetch("http://localhost:9000/signOut", {credentials:"include"})
        setTimeout(() => {
            window.location.reload(false);
        }, 100)
    }

    componentDidMount() {
        fetch("http://localhost:9000/isLogged", {credentials:"include"})
            .then(res => res.json())
            .then(
                (result) => {
                    var userLink = "/user/" + result.id
                    this.setState({loggedIn:[
                            // <a href="/cart"><img id="circlebutton" src="/img/buttons/cart.png" width='38px' height='38px'/></a>,
                            // <a href={userLink}><img id="circlebutton" src="/img/buttons/user.png" width='40px' height='38px'/></a>,
                            // <a id="button" href="#" onClick={this.logOut}>Log Out</a>]})
                },
                (error) => {
                    this.setState({loggedIn:[<a id="button" href="#" onClick={this.showLogin}>Log In</a>]})
                }
            )
    }

    hideLogin() {
        document.getElementsByClassName("loginFrame")[0].setAttribute("id","framefloating-fadeout");
        document.getElementsByClassName("darkbcg")[0].setAttribute("id","darken-fadeout");

        setTimeout(() => {
            this.setState({loginFrame: ""});
        }, 500)
    }


    showLogin() {
        let login =
            <div>
                <div id="darken" className="darkbcg"/>
                <div id="framefloating" className="loginFrame">
                    <h1>Log In</h1>
                    <h3>Log In with:</h3>
                    <div id="center">
                        <t/><t/><t/><t/>
                        <a href="http://localhost:9000/authenticate/google">
                            <img id="circlebutton" src="/img/buttons/google.png" width='64px' height='64px'/>
                        </a>
                        <a href="http://localhost:9000/authenticate/dropbox">
                            <img id="circlebutton" src="/img/buttons/dropbox.png" width='64px' height='64px'/>
                        </a>
                    </div>
                    <br/><br/><br/>
                    <div id="right">
                        <a id="button" href="#" onClick={this.hideLogin}>Cancel</a>
                    </div>
                </div>
            </div>
        this.setState({ loginFrame: login });
    }

    render() {
        return (
            <div id="topBar">
                {this.state.loginFrame}
                <table>
                    <tr>
                        <td id="left">
                        </td>
                        <td id="right">
                            <a href="/"><img id="circlebutton" src="/img/buttons/home.png" width='38px' height='38px'/></a>
                            {this.state.loggedIn}
                        </td>
                    </tr>
                </table>
            </div>
        )
    }
}

export default TopBar;