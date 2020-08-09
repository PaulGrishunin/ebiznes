import React from 'react';
import {
  BrowserRouter as Router,
  Route
} from 'react-router-dom';

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
    <a name="top"/>
    <div id="categoryList">
      <a id="listbutton" href="/">Main page</a>
      <Route component={Categories}/>
    </div>
    <div id="main">
      <Route exact path="/" component={Discounts}/>
      {/*<Route exact path="/" component={Reviews}/>*/}
      <Route path="/category/:cat" component={Products}/>
      {/*<Route path="/user/:user" component={UserPage}/>*/}
      {/*<Route path="/user/:user" component={Orders}/>*/}
      <Route path="/product/:product" component={Product}/>
      <Route path="/cart" component={Basket}/>
    </div>
    {/*<a href="#top"><img id="topbutton" src="/img/buttons/up.png" width='50px' height='50px'/></a>*/}
  </Router>
}

export default App;
