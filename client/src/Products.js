import React, {Component} from 'react';
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
                        let priceDisp = (prod.price).toFixed(2) + " zł"
                        if(pro != null)
                            priceDisp = [<b><del>{prod.price} zł</del><t/>
                                PROMOCJA - {pro.discount}%<t/>
                                {(prod.price * (100 - pro.discount) / 100).toFixed(2)} zł <t/></b>]

                        products.splice (prod.id,0,[
                            <a id="clearunderline" href={link} key={prod.id}>
                                <div id="framebutton">
                                    <table>
                                        <tr>
                                            <td>
                                                <img src={img} width="256" height="256"/>
                                            </td>
                                            <td>
                                                <div id="productname">{prod.name}</div>
                                                <div id="productprice">Cena: {priceDisp}</div>
                                            </td>
                                        </tr>
                                    </table>
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