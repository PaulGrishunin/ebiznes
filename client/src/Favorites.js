import React, {Component} from 'react';
import './Discounts.css';


class Favorites extends Component {

    constructor() {
        super();
        this.state = {
            products: [],
            id: 0,
        };
        this.deleteFromFavorites = this.deleteFromFavorites.bind(this);
    }

    deleteFromFavorites() {
        var url = "http://localhost:9000/deletefavorites/" + this.props.id   //тут  product_id  который находится в Favorits
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
        let url = "http://localhost:9000/favorites"
        fetch(url, {credentials: "include"})
            .then(results => {
                return results.json();
            }).then(data => {
            let products = data.map((favs) => {

                var url2 = "http://localhost:9000/product/" + favs.product

                fetch(url2, {
                    mode: 'cors',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': 'http://localhost:3000',
                    },
                    method: 'GET',
                })
                .then(response => response.json())
                        .then(prod => {

                            let link = "/product/" + prod.id;
                            let img = "/img/products/" + prod.id + ".png";
                            let priceDisp = (prod.price).toFixed(2) + " usd"

                            products.splice (prod.id,0,[
                                <a className="clearunderline" href={link} key={prod.id}>
                                    <div className="framebutton">
                                        <img src={img} alt='' width="256" height="256"/>
                                        <div className="productname"><b>{prod.name}</b></div>
                                        <div className="productprice">Price: {priceDisp}</div>
                                        <a className="button red" href="#" onClick={this.deleteFromFavorites}>Delete from Favorites</a>
                                    </div>
                                </a>
                            ])
                            this.setState({products: products});
                            console.log(this.props.product);


                        })
                })
            })
    }

    render() {
        return (
            <div className="products" >
                {this.state.products}
            </div>
        )
    }
}

export default Favorites;