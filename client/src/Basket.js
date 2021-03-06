import React, {Component} from 'react';
import BasketItem from './BasketItem'
import "./Basket.css"

class Basket extends Component {

    constructor() {
        super();
        this.state = {
            basket: [],
            basketObject: [],
            basketPrice: 0,
            confirmFrame: "",
        };
        this.displayConfirmation = this.displayConfirmation.bind(this);
        this.eraseBasket = this.eraseBasket.bind(this);
        this.buyBasket = this.buyBasket.bind(this);
    }

    displayConfirmation() {
        var frame =
                <div className="framefloat" >
                    <h1>Thank you for your purchase! We will be glad to see you again!</h1>
                </div>
        this.setState({ confirmFrame: frame });
    }

    eraseBasket() {
        for (var i = 0; i < this.state.basketObject.length; i++) {
            var url = "http://localhost:9000/deletefrombasket/" + this.state.basketObject[i].id
            console.log(url)
            fetch(url, {
                mode: 'cors',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': 'http://localhost:3000',
                },
                method: 'GET',
            })
        }
        window.location.reload(false);
    }

    buyBasket() {
        this.displayConfirmation()
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        var today = dd + '/' + mm  + '/' + yyyy

        for(var i=0;i<this.state.basketObject.length;i++) {

            fetch('http://localhost:9000/addorderhandle', {
                method: 'POST',
                body: JSON.stringify({ "user":this.state.basketObject[i].user,
                    "product":this.state.basketObject[i].product,
                    "quantity":this.state.basketObject[i].quantity,
                    "price":this.state.basketObject[i].price * this.state.basketObject[i].quantity,
                    "date":today
                }),
                credentials: "include",
                headers: {
                    'Content-type': 'application/json; charset=UTF-8'
                }

            }).then(results => {
                return results.json();
            }).then(data => {
                console.log(data.id)
               //Add payment fact
                fetch('http://localhost:9000/addpaymenthandle', {
                    method: 'POST',
                    body: JSON.stringify({
                        "order": data.id,
                        "date": today
                    }),
                    headers: {
                        'Content-type': 'application/json; charset=UTF-8'
                    }
                })
                //Add delivery fact
                fetch('http://localhost:9000/adddeliveryhandle', {
                    method: 'POST',
                    body: JSON.stringify({
                        "order": data.id,
                        "date": today
                    }),
                    headers: {
                        'Content-type': 'application/json; charset=UTF-8'
                    }
                })
            })

            //remove item from basket
            var url = "http://localhost:9000/deletefrombasket/" + this.state.basketObject[i].id
            fetch(url, {
                mode: 'cors',
                headers:{
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin':'http://localhost:3000',
                },
                method: 'GET',
            })
        }
        setTimeout(() => {
            window.location.reload(false);
        }, 1000)
    }

    componentDidMount() {
        let url = "http://localhost:9000/basket"
        var basketObjectList = []
        fetch(url, {credentials:"include"})
            .then(results => {
                return results.json();
            }).then(data => {
            let basket = data.map((basket) => {
                var url2 = "http://localhost:9000/product/" + basket.product
                fetch(url2, {
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
                    }).then(product => {
                    var url1 = "http://localhost:9000/discountpr/" + basket.product
                    fetch(url1, {
                        mode: 'cors',
                        headers:{
                            'Accept': 'application/json',
                            'Content-Type': 'application/json',
                            'Access-Control-Allow-Origin':'http://localhost:3000',
                        },
                        method: 'GET',
                    }).then(response => response.json())
                        .then(dis => {
                            var basketObject = basket
                            if (dis != null) {
                                this.setState({basketPrice: this.state.basketPrice + product.price * (100 - dis.amount) / 100 * basket.quantity})
                                basketObject.price = product.price * (100 - dis.amount) / 100 * basket.quantity
                            } else {
                                this.setState({basketPrice: this.state.basketPrice + product.price * basket.quantity})
                                basketObject.price = product.price
                            }
                            basketObjectList.push(basketObject)
                        })
                    return 0
                })

                this.setState({basketObject: basketObjectList})
                console.log("basketObject:", this.state.basketObject)
                return (
                    <div  key={basket.id}>
                        <BasketItem id={basket.id} product={basket.product} number={basket.quantity}/>
                    </div>
                )
            })
            this.setState({basket: basket})
        })
    }

    render() {
        if(this.state.basket.length > 0)
            return (
                <div className="basket">
                    {this.state.confirmFrame}
                    <div >
                        {this.state.basket}
                        <table className="fullWidth">
                            <tr>
                                <td className="left">
                                    <h3>
                                        <t/><t/><t/><b>Total price: {(this.state.basketPrice).toFixed(2)} usd</b>
                                    </h3>
                                </td>
                                <td className="right">
                                    <a className="button red" href="#" onClick={this.eraseBasket}><b>Erase basket</b></a>
                                    <t/><t/>
                                    </td>
                                <td className="right">
                                    <a className="button blue" href="#" onClick={this.buyBasket}><b>Buy</b></a>
                                </td>
                            </tr>
                        </table>
                    </div>

                </div>
            )
        else
            return(
                <div className="basket" >
                    <div >
                    <br/>
                     <br/>
                        <h3>
                            Empty Basket
                        </h3>
                    </div>
                </div>
            )
    }
}

export default Basket;