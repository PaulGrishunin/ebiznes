import React from 'react';
import {
  BrowserRouter as Router,
  Route
} from 'react-router-dom';

import Product from './Product'
import logo from './logo.svg';
import TopBar from './TopBar'
import Categories from './Categories'
import Category from './Category'
import './App.css';

function App() {

  return <Router>
    <Route component={TopBar}/>
    <a name="top"/>
    <div id="categoryList">
      <a id="listbutton" href="/">Main page</a>
      <Route component={Categories}/>
    </div>
    <div id="main">
      {/*<Route exact path="/" component={Promotions}/>*/}
      {/*<Route exact path="/" component={Comments}/>*/}
      {/*<Route path="/category/:cat" component={Products}/>*/}
      {/*<Route path="/user/:user" component={UserPage}/>*/}
      {/*<Route path="/user/:user" component={Transactions}/>*/}
      <Route path="/product/:product" component={Product}/>
      {/*<Route path="/cart" component={Cart}/>*/}
    </div>
    <a href="#top"><img id="topbutton" src="/img/buttons/up.png" width='50px' height='50px'/></a>
  </Router>
}

export default App;
