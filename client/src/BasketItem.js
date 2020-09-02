import React, {Component} from 'react';
import "./Basket.css"

class BasketItem extends Component {

    constructor() {
        super();
        this.state = {
            basketItem: [],
            amount: [],
        };
        this.removeItem = this.removeItem.bind(this);
    }

    removeItem() {
        var url = "http://localhost:9000/deletefrombasket/" + this.props.id
        fetch(url, {
            mode: 'cors',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'http://localhost:3000',
            },
            method: 'GET',
        })
        window.location.reload(false);
    }

    componentDidMount() {
        var url1 = "http://localhost:9000/discountpr/" + this.props.product
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
                if(pro != null)
                    this.setState({ amount: pro.amount });

                var url = "http://localhost:9000/product/" + this.props.product

                fetch(url, {
                    mode: 'cors',
                    headers:{
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin':'http://localhost:3000',
                    },
                    method: 'GET',
                }).then(response => response.json())
                    .then(product => {
                        let lnkBackToProduct = "/product/" + product.id
                        let basketItem =

                                <table className="fullWidth">
                                    <tr>
                                        <td className="left">
                                                <h3>
                                                <a id="linkh3" href={lnkBackToProduct}>{product.name} </a>
                                                {(product.price * (100 - this.state.amount) / 100).toFixed(2)} usd <br/>
                                                pcs: {this.props.number}<td></td>
                                                total:<b> {(this.props.number * product.price * (100 - this.state.amount) / 100).toFixed(2)} usd</b>
                                            </h3>
                                        </td>
                                        <td className="right">
                                            <t/><t/><t/><a className="button red" href="#" onClick={this.removeItem}>Delete from basket</a>
                                        </td>
                                    </tr>
                                </table>

                        this.setState({ basketItem: basketItem });
                    });
            });
    }

    render() {
        return (
            <div className="basketItem">
                {this.state.basketItem}
            </div>
        )
    }
}

export default BasketItem;