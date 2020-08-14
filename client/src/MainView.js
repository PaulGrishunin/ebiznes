import React, { Component } from 'react';
import QueueAnim from 'rc-queue-anim';
import { OverPack } from 'rc-scroll-anim';
import logo from '../pictures/MainView_logo.png';

import { DownOutlined, FacebookOutlined, TwitterOutlined, SkypeOutlined, InstagramOutlined } from '@ant-design/icons';

import Product from './Product'
import Products from './Products'
import Categories from './Categories'
import Category from './Category'
import Discounts from './Discounts'
// import Reviews from './Reviews'
// import Orders from './Orders'
import TopBar from './TopBar'
import Basket from './Basket'
import './App.css';

function App() {

    return <Router>
        <Route component={TopBar}/>

        <div id="main">
            <Route exact path="/" component={Discounts}/>
            {/*<Route exact path="/" component={Reviews}/>*/}
            <Route path="/category/:cat" component={Products}/>
            {/*<Route path="/user/:user" component={UserPage}/>*/}
            {/*<Route path="/user/:user" component={Orders}/>*/}
            <Route path="/product/:product" component={Product}/>
            <Route path="/cart" component={Basket}/>
        </div>

    </Router>
}



class MainView extends Component {
  state = {
    show: true
  };


  onClick = () => {
    this.setState({
      show: !this.state.show
    });
  }

  headerDiv = () => {
    return (
        'Hello!'
    );
  }

  introDiv = () => {
    return (
      <OverPack style={{ overflow: 'hidden' }} playScale={0.4} >
        <QueueAnim style={{ backgroundColor: "#ffffff" }}>
          <div key="a" style={{ padding: "2%", fontWeight: "bold", fontSize: "x-large" }}>
            What is Book Review Platform ?
          </div>
          <div key="b" style={{ paddingLeft: "10%", paddingRight: "10%", display: "flex" }}>
            <div style={{ float: "left", fontSize: "larger", textAlign: "left", width: "60vw", margin: "5%" }} >
              Book Review Platform was created to let all bookworms explor world of books. Thanks to our platform
              you can find interesting books, give your opinion about it or read reviews to make sure that book is
              worth to be read.
              <br />
              <br />
              Join to our community and enjoy reading. Many cathegories that you can discover. Thousands of books and even
              more reviews. Do not waste your time for books that are noth worth it. Search for reviews and save your time.
            </div>
            <img alt='intro' src={intro} style={{ float: "right", height: "350px" }} />
          </div>
        </QueueAnim>
      </OverPack>
    );
  }

  socialmediaIcons = () => {
    return ([
      <FacebookOutlined key={1} style={{ fontSize: "35px", margin: "10px" }} />,
      <TwitterOutlined key={2} style={{ fontSize: "35px", margin: "10px" }} />,
      <SkypeOutlined key={3} style={{ fontSize: "35px", margin: "10px" }} />,
      <InstagramOutlined key={4} style={{ fontSize: "35px", margin: "10px" }} />
    ]);
  }

  contactUsDiv = () => {
    return (
      <OverPack style={{ overflow: 'hidden' }} playScale={0.1} >
        <QueueAnim style={{ backgroundColor: "#ffffff" }}>
          <div key="a" style={{ padding: "2%", fontWeight: "bold", fontSize: "x-large" }}>
            Contact us
                </div>
          <div key="b" style={{ paddingLeft: "10%", paddingRight: "10%", display: "flex" }}>
            <img alt='contact' src={contact} style={{ float: "left", height: "350px" }} />
            <div style={{ float: "right", fontSize: "larger", textAlign: "left", width: "60vw", margin: "5%" }} >
              If you have any questions or problems with using our platform please contact us.
                    <br />
              <br />
                    Phone: XXX-XXX-XXX
                    <br />
                    Email: xxx@email.com
                    <br />
              <br />
              <this.socialmediaIcons />
            </div>
          </div>
        </QueueAnim>
      </OverPack>
    );
  }

  render() {
    return (
      <div className="Main" >
        <this.headerDiv />
          <a name="top"/>
          <div id="categoryList">
              <a id="listbutton" href="/">Main page</a>
              <Route component={Categories}/>
          </div>
        <this.introDiv />
        <this.contactUsDiv />
          {/*<a href="#top"><img id="topbutton" src="/img/buttons/up.png" width='50px' height='50px'/></a>*/}
        <div style={{ height: "40vh", backgroundColor: "#ffffff" }} />
      </div>
    );
  }
};

export default MainView;
