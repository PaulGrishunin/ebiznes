import React, {Component} from 'react';
import { Layout, Menu } from 'antd';
import { Link, withRouter } from 'react-router-dom';
import { HomeOutlined, CheckCircleOutlined, PercentageOutlined, ShoppingCartOutlined, HeartOutlined, UserOutlined } from '@ant-design/icons';
import {Table} from "reactstrap";

const { Header, Content } = Layout;

class CustomLayout extends Component{

    constructor () {
        super();
        // menuType = authorized;
        // this.menuType = "";
        // this.iconPath = '/';
        this.state = {
            registred: "",
        };

    }

    componentDidMount() {
        fetch("http://localhost:9000/registred", {credentials:"include"})
            .then(res => res.json())
            .then(
                (result) => {
                    console.log("start")
                    this.setState({registred: "ok"})
                },
                (error) => {
                    console.log("error")
                    this.setState({registred: "not"})
                }
            )
    }


    signOut() {
        fetch("http://localhost:9000/signOut", {credentials:"include"})
        setTimeout(() => {
            window.location.reload(false);
        }, 100)
    }

    nonAuthorizedMenu = () => {
        return(
            <Menu
                theme="light"
                mode="horizontal"
                style={{lineHeight: '64px'}} >
                <Menu.Item
                    key="home"
                    style={{float: 'center', marginLeft: '10%'}}>
                    <Link to="/"><HomeOutlined />Home</Link>
                </Menu.Item>
                <Menu.Item
                    key="discounts"
                    style={{float: 'center', marginLeft: '2%'}}>
                    <Link to="/discounts"><PercentageOutlined />Discounts</Link>
                </Menu.Item>
                <Menu.Item
                    key="register"
                    style={{float: 'right'}}>
                    <a href="http://localhost:9000/authenticate/google">Google</a>
                </Menu.Item>
                <Menu.Item
                    key="register"
                    style={{float: 'right'}}>
                    <a href="http://localhost:9000/authenticate/facebook">Facebook</a>
                </Menu.Item>

            </Menu>
        );
    }

    authorizedMenu = () => {
        return(
            <Menu
                theme="light"
                mode="horizontal"
                style={{lineHeight: '64px'}} >
                <Menu.Item
                    key="home"
                    style={{float: 'center', marginLeft: '10%'}}>
                    <Link to="/"><HomeOutlined />Home</Link>
                </Menu.Item>
                <Menu.Item
                    key="discounts"
                    style={{float: 'center', marginLeft: '2%'}}>
                    <Link to="/discounts">< PercentageOutlined />Discounts</Link>
                </Menu.Item>
                <Menu.Item
                    key="orders"
                    style={{float: 'center', marginLeft: '2%'}}>
                    <Link to="/orders">< CheckCircleOutlined />Orders</Link>
                </Menu.Item>
                <Menu.Item
                    key="basket"
                    style={{float: 'center', marginLeft: '2%'}}>
                    <Link to="/basket">< ShoppingCartOutlined />Basket</Link>
                </Menu.Item>
                <Menu.Item
                    key="favorites"
                    style={{float: 'center', marginLeft: '2%'}}>
                    <Link to="/favorites">< HeartOutlined />Favorites</Link>
                </Menu.Item>

                <Menu.Item
                    key="signout"
                    style={{float: 'right'}}>
                    <a href="#"  onClick={this.signOut}>Sign out</a>
                </Menu.Item>
                <Menu.Item
                    key="userpage"
                    style={{float: 'right'}}>
                    <Link to="/user" >< UserOutlined />Profile</Link>
                </Menu.Item>
            </Menu>
        );
    }

    renderMenu = () => {
        if ( this.state.registred === "ok" )
            return <this.authorizedMenu/>;
        else
        return <this.nonAuthorizedMenu />;
    }

    render(){
        return (
        <Layout className="layout">
            <Header style={{ position: 'fixed', zIndex: 1, width: '100%', background: '#ffffff' }}>
                <div style={{color: "black", float: "left", width: "200px"}}>
                    <Link style={{paddingLeft: '50px', color: "green", float: 'left', fontWeight: "bold", fontSize: "large"}} to={this.iconPath}> <b><i>SHOP LOGO</i></b> </Link>
                </div>
                <this.renderMenu />
            </Header>
            <Content >
                                <div>
                                    {this.props.children}
                                </div>
            </Content>
        </Layout>
    );
    }
}

export default withRouter(CustomLayout);


