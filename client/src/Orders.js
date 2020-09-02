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
        this.showAdd = this.showAdd.bind(this);
        this.hideAdd = this.hideAdd.bind(this);
        this.componentDidMount = this.componentDidMount.bind(this);
    }

    // sentReview(id) {
    //     fetch('http://localhost:9000/addreviewhandle', {
    //         method: 'POST',
    //         body: JSON.stringify({
    //             "product":id,
    //             "rate":parseInt(document.getElementsByName("rate")[0].value),
    //             "text":document.getElementsByName("text")[0].value
    //         }),
    //         headers: {
    //             'Content-type': 'application/json; charset=UTF-8'
    //         },
    //         credentials:"include"
    //     })
    //         .then(res => res.json())
    //         .then(console.log)
    //     window.location.reload(false);
    // }

    // updateRate() {
    //     var rate = document.getElementsByName("rate")[0].value
    // }

    hideAdd() {
        document.getElementsByClassName("addframe")[0].setAttribute("id","framefloating-fadeout");
        document.getElementsByClassName("darkbcg")[0].setAttribute("id","darken-fadeout");

        setTimeout(() => {
            this.setState({addframe: ""});
        }, 500)
    }


    showAdd(id) {
        let frame =
            <div>
                <div id="darken" className="darkbcg"/>
                <div id="framefloating" className="addframe">
                    <h1>Add product review</h1>
                    <h2>
                        <ProductName product={id}/>
                    </h2>
                    <h3>
                        Rate:
                        <input type="number" id="textbox" name="rate" min="0" max="5" defaultValue="5" onChange={this.updateRate}/>
                    </h3>
                    <h3>
                        Text review:
                    </h3>
                    <textarea className="fullWidth" name="text"/>
                    <div id="right">
                        <a className="button blue" href="#" onClick={() => this.sentOpinion(id)}>Add review</a>
                        <a className="button red" href="#" onClick={this.hideAdd}>Cancel</a>
                    </div>
                </div>
            </div>
        this.setState({ addframe: frame });
    }

    componentDidMount() {
        var url = "http://localhost:9000/ordersusr/" + this.props.match.params.user
        console.log("User:",  this.props.id)
        fetch(url, {
            mode: 'cors',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'http://localhost:3000',
            },
            method: 'GET',
        })
            .then(results => {
                return results.json();
            }).then(data => {
            let orders = data.map((ord) => {
                return (
                    <tr id="fontlarger">
                        <td>
                            <t/><t/><t/>
                            {ord.id}
                        </td>
                        <td>
                            <a id="linkh2" href={"/product/"+ord.product}><ProductName product={ord.product}/></a>
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
                        {/*<td>*/}
                        {/*    <a className="button blue" href="#" onClick={() => this.showAdd(ord.product)}>Add review</a>*/}
                        {/*</td>*/}
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
                <div id="frame">
                    <table className="fullWidth">
                        <tr className="left">
                            <th><t/><t/><t/>ID</th>
                            <th>Product</th>
                            <th>Quantity</th>
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