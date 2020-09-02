import React, {Component} from 'react';
import { Layout, Menu } from 'antd';
import Categories from '../Categories';
import Orders from '../Orders';
import { Link, withRouter } from 'react-router-dom';
import { HomeOutlined, CheckCircleOutlined, PercentageOutlined, ShoppingCartOutlined, HeartOutlined, UserOutlined } from '@ant-design/icons';
import {Table} from "reactstrap";



const { Header, Content } = Layout;

class CustomLayout extends Component{

    constructor (props) {
        super(props);
        this.menuType = undefined;
        this.iconPath = '/';
    }

    componentDidMount() {
        this.setMenu();
    }

    setMenu() {
        let authorizedMenuPaths = ['/signedin', '/orders', '/basket', '/userpage'];
        let type = authorizedMenuPaths.includes(window.location.pathname)
            || window.location.pathname.startsWith("/user")
            || window.location.pathname.startsWith("/reviews")
            ? "authorized": "non-authorized";

        if (type === "authorized") this.iconPath = '/';
        else this.iconPath = '/';

        this.menuType = type;
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
                    <Link to="/register">Sign up</Link>
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
                    // onClick={() => {authService.logout()}}
                    style={{float: 'right'}}>
                    <Link to="/signout">Sign out</Link>
                </Menu.Item>
                <Menu.Item
                    key="userpage"
                    style={{float: 'right'}}>
                    <Link to="/user/" >< UserOutlined />Profile</Link>
                </Menu.Item>
            </Menu>
        );
    }

    renderMenu = () => {
        // if ( this.menuType === "authorized" )
            return <this.authorizedMenu/>;
        // else
        // return <this.nonAuthorizedMenu />;
    }

    render(){
        this.setMenu();
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


