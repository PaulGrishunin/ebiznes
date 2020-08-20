import React, {Component} from 'react';

class Discounts extends Component {

    constructor() {
        super();
        this.state = {
            products: [],
        };
        this.loadData = this.loadData.bind(this);
    }

    loadData() {
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
                    .then(dis => {
                        if(dis != null)
                            this.setState({ amount: dis.amount });
                        let link = "/product/" + prod.id;
                        let img = "/img/products/" + prod.id + ".png";
                        let priceDisp = (prod.price).toFixed(2) + " usd"
                        if(dis != null) {
                            priceDisp = [<b>
                                <del> {prod.price} usd </del>
                                  { (prod.price * (100 - dis.amount) / 100).toFixed(2)} usd
                                   <br/>
                                Discount - {dis.amount} %</b>]
                            products.push([
                                <a id="clearunderline" href={link} key={prod.id}>
                                    <div id="framebutton">
                                        <table>
                                            <tr>
                                                <td>
                                                    <img src={img} alt='' width="256" height="256"/>

                                                    <div id="productname">{prod.name}</div>
                                                    <div id="discountdescription">{dis.description}</div>
                                                    <div id="productprice">Price: {priceDisp}</div>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </a>
                            ])
                            this.setState({products: products})
                            console.log(prod.name)

                        }
                    })
            })
        })
    }

    componentDidMount() {
        this.loadData()
    }

    render() {
        return (
            <div className="discounts" style={{  alignItems:'top', marginLeft: '10vh', marginTop: '20px', marginRight: '10vh', fontSize: "large"}}>
                <div id="frame">
                    <h3>
                        <t/><t/>DISCOUNTS:
                    </h3>
                    {this.state.products}
                </div>

            </div>
        )
    }
}

export default Discounts;