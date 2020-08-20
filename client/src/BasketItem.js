import React, {Component} from 'react';

class BasketItem extends Component {

    constructor() {
        super();
        this.state = {
            basketItem: [],
            discount: [],
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
                    this.setState({ discount: pro.discount });
                //console.log("test1  " + this.state.discount)

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
                            <div>
                                <table id="fullWidth">
                                    <tr>
                                        <td>
                                            <h3>
                                                <a id="linkh2" href={lnkBackToProduct}>{product.name}</a>
                                                {(product.price * (100 - this.state.discount) / 100).toFixed(2)} usd, <t/>
                                                pcs: {this.props.number}, <t/>
                                                total: {(this.props.number * product.price * (100 - this.state.discount) / 100).toFixed(2)} usd
                                            </h3>
                                        </td>
                                        {/*<td id="right">*/}
                                        {/*    <a id="button" href="#" onClick={this.removeItem}>Delete from basket</a>*/}
                                        {/*</td>*/}
                                    </tr>
                                </table>
                            </div>
                        this.setState({ basketItem: basketItem });
                    });
            });
    }

    render() {
        return (
            <div id="frame" className="basketItem">
                {this.state.basketItem}
            </div>
        )
    }
}

export default BasketItem;