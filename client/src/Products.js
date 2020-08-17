import React, {Component} from 'react';
import './Products.css';
import {Table} from "reactstrap";

class Products extends Component {

    constructor() {
        super();
        this.state = {
            products: [],
        };
    }

    componentDidMount() {
        var url = "http://localhost:9000/products"

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
            let products = data.map((prod) => {
                var url1 = "http://localhost:9000/discountpr/" + prod.id
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
                        let link = "/product/" + prod.id;
                        let img = "/img/products/" + prod.id + ".png";
                        let priceDisp = (prod.price).toFixed(2) + " usd"
                        if(pro != null)
                            priceDisp = [<b><del>{prod.price} usd</del><t/>
                                Discount - {pro.discount}%<t/>
                                {(prod.price * (100 - pro.discount) / 100).toFixed(2)} usd <t/></b>]

                        products.splice (prod.id,0,[
                            <a className="clearunderline" href={link} key={prod.id}>
                                <div className="framebutton">
                                                <img src={img} width="256" height="256"/>
                                                <div className="productname">{prod.name}</div>
                                                <div className="productprice">Price: {priceDisp}</div>
                                </div>
                            </a>
                        ])
                        this.setState({products: products})
                    })
            })
        })
    }

    render() {
        return (
            <div className="products">
                {this.state.products}
            </div>
        )
    }
}

export default Products;