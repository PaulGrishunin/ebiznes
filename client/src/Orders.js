import React, {Component} from 'react';
import ProductName from './ProductName'
import Basket from './Basket'
import Payment from './Payment'
import Delivery from './Delivery'
import './Orders.css'

class Orders extends Component {

    constructor() {
        super();
        this.state = {
            orders: [],
            addframe: "",
        };
        this.hideAdd = this.hideAdd.bind(this);
        this.componentDidMount = this.componentDidMount.bind(this);
    }

    hideAdd() {
        document.getElementsByClassName("addframe")[0].setAttribute("id","framefloating-fadeout");
        document.getElementsByClassName("darkbcg")[0].setAttribute("id","darken-fadeout");

        setTimeout(() => {
            this.setState({addframe: ""});
        }, 500)
    }


    componentDidMount() {
        var url = "http://localhost:9000/orders"
        fetch(url, {
            mode: 'cors',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'http://localhost:3000',
            },
            method: 'GET',
            credentials: 'include'
        })
            .then(results => {
                return results.json();
            }).then(data => {
            let orders = data.map((ord) => {
                return (
                    <tr className="left">
                        <td>
                            <t/><t/><t/>
                            {ord.id}
                        </td>
                        <td>
                            <a className="linkh3" href={"/product/"+ord.product}><ProductName product={ord.product}/></a>
                        </td>
                        <td>
                            {ord.quantity}
                        </td>
                        <td>
                            {(ord.price).toFixed(2)} usd
                        </td>
                        <td>
                            {ord.date}
                        </td>
                        <td>
                            <Payment order={ord.id}/>
                        </td>
                        <td>
                            <Delivery order={ord.id}/>
                        </td>
                    </tr>
                )
            })
            this.setState({orders: orders})
        })
    }

    render() {
        return (
            <div>
                {this.state.addframe}
                <div className="orders">
                    <br/>
                    <table className="fullWidth">
                        <tr className="left">
                            <th><t/><t/><t/>ID</th>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Order data</th>
                            <th>Payment data</th>
                            <th>Delivery data</th>
                            {/*<th>Option</th>*/}
                        </tr>
                        {this.state.orders}
                    </table>
                </div>
            </div>
        )
    }
}

export default Orders;