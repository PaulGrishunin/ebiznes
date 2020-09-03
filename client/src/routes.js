import React from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import Product from './Product'
import Products from './Products'
import Categories from './Categories'
import Users from './Users'
import UserPage from './UserPage'
// import Category from './Category'
import Discounts from './Discounts'
import Orders from './Orders'
import Favorites from './Favorites'
import Basket from './Basket'
import './App.css';

const BaseRouter = () => (
   <Switch>
       {/*<Route path="/login" component={LoginView} />*/}
       {/*<Route path="/register" component={RegistrationView} />*/}
       {/*<Route path="/signedin" />*/}
       {/*<Route path="/signedup" />*/}
       {/*<Route path="/resetPassword" component={PasswordResetView} />*/}
       {/*<Route path="/signedout" redirect "http://localhost:9000/signedout" />*/}

          <Route exact path="/categories" component={Categories}/>
          <Route exact path="/" component={Discounts}/>
       <Route path="/category/:cat" component={Products}/>
       <Route path="/products" component={Products}/>
       <Route path="/discounts" component={Discounts}/>
       <Route path="/discount/:id" component={Discounts}/>
       <Route path="/discountpr/:prod" component={Discounts}/>
       <Route path="/users" component={Users}/>
          <Route path="/user" component={UserPage}/>
          <Route path="/user/:user" component={Orders}/>
          <Route path="/product/:product" component={Product}/>
       <Route path="/favorites" component={Favorites}/>
          <Route path="/basket" component={Basket}/>
       <Route path="/orders" component={Orders}/>
       <Redirect from="/signout" to="http://localhost:9000/signout" />

   </Switch>

);

export default BaseRouter;
