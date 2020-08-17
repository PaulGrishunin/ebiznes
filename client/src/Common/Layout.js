import React from 'react';
import { Layout, Menu } from 'antd';
import { Link, withRouter } from 'react-router-dom';
// import logo from '../pictures/Common_logo.png';
import { HomeOutlined, UserOutlined, CheckCircleOutlined, PercentageOutlined, ShoppingCartOutlined } from '@ant-design/icons';
// import { authService } from "../Authorization/_auth-services/authentication";


const { Header, Content } = Layout;

class CustomLayout extends React.Component{

    constructor (props) {
        super(props);
        this.menuType = undefined;
        this.iconPath = '/';
    }

    componentDidMount() {
        this.setMenu();
    }

    setMenu() {
        let authorizedMenuPaths = ['/categories'];
        let type = authorizedMenuPaths.includes(window.location.pathname)
            || window.location.pathname.startsWith("/products")
            || window.location.pathname.startsWith("/categories")
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
                    key="register"
                    style={{float: 'right'}}>
                    <Link to="/register">Sign up</Link>
                </Menu.Item>
                <Menu.Item
                    key="login"
                    style={{float: 'right'}}>
                    <Link to="/products">Login</Link>
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
                    <Link to="/categories"><HomeOutlined />Home</Link>
                </Menu.Item>
                <Menu.Item
                    key="discounts"
                    style={{float: 'center', marginLeft: '2%'}}>
                    <Link to="/products"><PercentageOutlined />Discounts</Link>
                </Menu.Item>
                <Menu.Item
                    key="orders"
                    style={{float: 'center', marginLeft: '2%'}}>
                    <Link to="/categories"><CheckCircleOutlined />Orders</Link>
                </Menu.Item>
                <Menu.Item
                    key="basket"
                    style={{float: 'center', marginLeft: '2%'}}>
                    <Link to="/basket">< ShoppingCartOutlined />Basket</Link>
                </Menu.Item>
                {/*<Menu.Item*/}
                {/*    key="favorites"*/}
                {/*    style={{float: 'center', marginLeft: '2%'}}>*/}
                {/*    <Link to="/favorites">< TeamOutlined />Favorites</Link>*/}
                {/*</Menu.Item>*/}
                <Menu.Item
                    key="signout"
                    // onClick={() => {authService.logout()}}
                    style={{float: 'right'}}>
                    <Link to="/discounts">Sign out</Link>
                </Menu.Item>
            </Menu>
        );
    }

    renderMenu = () => {
        if ( this.menuType === "authorized" ) return <this.authorizedMenu/>;
        else return <this.nonAuthorizedMenu />;
    }

    render(){
        this.setMenu();
        return (
        <Layout className="layout">
            <Header style={{ position: 'fixed', zIndex: 1, width: '100%', background: '#ffffff' }}>
                <div style={{color: "black", float: "left", width: "200px"}}>
                    {/*<img src={logo} alt='logo'/>*/}
                    <Link style={{paddingLeft: '100px', color: "green", float: 'left'}} to={this.iconPath}> <b><i>SUPER SHOP</i></b> </Link>
                </div>
                <this.renderMenu />
            </Header>
            <Content style={{ padding: '0px', backgroundColor: 'white', paddingTop: '64px', height: "100%" }}>
                <div>
                {this.props.children}
                </div>
            </Content>
        </Layout>
    );
    }
}

export default withRouter(CustomLayout);
