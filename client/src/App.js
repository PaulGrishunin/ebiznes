import React, { Component } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import './App.css';
import BaseRouter from './routes';
import Layout from './Common/Layout.js';
import 'antd/dist/antd.css';
import { FacebookOutlined, TwitterOutlined, SkypeOutlined, InstagramOutlined } from '@ant-design/icons';
import QueueAnim from 'rc-queue-anim';
import { OverPack } from 'rc-scroll-anim';

class App extends Component {

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
                        <div style={{ float: "right", fontSize: "larger", textAlign: "left", width: "60vw", margin: "1%" }} >
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
        <div className="App" style={{height: "100%"}}>
          <Router>
            <Layout {...this.props}>
              <BaseRouter />
                <this.contactUsDiv />
            </Layout>
          </Router>

        </div>);
  }

}
export default App;

