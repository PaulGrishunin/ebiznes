import React, {Component} from 'react';
import BasketItem from './BasketItem'

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
        this.clearBasket = this.clearBasket.bind(this);
        this.buyBasket = this.buyBasket.bind(this);
    }

    displayConfirmation() {
        var frame =
            <div>
                <div id="darken" className="darkbcg"/>
                <div id="framefloating" className="loginFrame">
                    <h1>Przetwarzanie transakcji</h1>
                </div>
            </div>
        this.setState({ confirmFrame: frame });
    }

    clearBasket() {
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

    buyCart() {
        this.displayConfirmation()
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        var today = mm + '/' + dd + '/' + yyyy

        for(var i=0;i<this.state.basketObject.length;i++) {
            //create order from basket item
            fetch('http://localhost:9000/addorderhandle', {
                method: 'POST',
                body: JSON.stringify({ "user":this.state.basketObject[i].user,
                    "product":this.state.basketObject[i].product,
                    "quantity":this.state.basketObject[i].quantity,
                    "price":this.state.basketObject[i].price,
                    "date":today
                }),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8'
                }
            }).then(results => {
                return results.json();
            }).then(data => {
                console.log(data.id)
                //create payment (should be when bank confirms payment is on shop's account
                fetch('http://localhost:9000/addpaymenthandle', {
                    method: 'POST',
                    body: JSON.stringify({
                        "transaction": data.id,
                        "date": today
                    }),
                    headers: {
                        'Content-type': 'application/json; charset=UTF-8'
                    }
                })
            })

            //remove item from cart
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
                    var url1 = "http://localhost:9000/promotionpr/" + basket.product
                    fetch(url1, {
                        mode: 'cors',
                        headers:{
                            'Accept': 'application/json',
                            'Content-Type': 'application/json',
                            'Access-Control-Allow-Origin':'http://localhost:3000',
                        },
                        method: 'GET',
                    }).then(response => response.json())
                        .then(pro => {
                            var basketObject = basket
                            if (pro != null) {
                                this.setState({basketPrice: this.state.basketPrice + product.price * (100 - pro.discount) / 100 * basket.quantity})
                                basketObject.price = product.price * (100 - pro.discount) / 100 * basket.quantity
                            } else {
                                this.setState({basketPrice: this.state.basketPrice + product.price * basket.quantity})
                                basketObject.price = product.price
                            }
                            basketObjectList.push(basketObject)
                        })
                    return 0
                })

                this.setState({basketObject: basketObjectList})
                console.log(this.state.basketObject)
                return (
                    <div key={basket.id}>
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
                    <div id="frame">
                        <table id="fullWidth">
                            <tr>
                                <td id="left">
                                    <h3>
                                        <t/><t/><t/>Łączna kwota: {(this.state.basketPrice).toFixed(2)} zł
                                    </h3>
                                </td>
                                <td id="right">
                                    <a id="button" href="#" onClick={this.clearBasket}>Wyczyść koszyk</a>
                                    <t/><t/><t/>
                                    <a id="button" href="#" onClick={this.buyBasket}>Kupuję</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                    {this.state.basket}
                </div>
            )
        else
            return(
                <div className="basket">
                    <div id="frame">
                        <h3>
                            <t/><t/><t/>Koszyk jest pusty
                        </h3>
                    </div>
                </div>
            )
    }
}

export default Basket;