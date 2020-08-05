import React, {Component} from 'react';
import Category from './Category'
//import Opinions from './Opinions'

class Product extends Component {

    constructor() {
        super();
        this.state = {
            products: [],
            id: 0,
            name: "",
            price: 0,
            discount: 0,
            addToCartFrame: [],
        };
        this.updateNumber = this.updateNumber.bind(this);
        this.addToCart = this.addToCart.bind(this);
        this.hideAddToCartFrame = this.hideAddToCartFrame.bind(this);
        this.showAddToCartFrame = this.showAddToCartFrame.bind(this);
    }

    updateNumber() {
        var finalPrice = document.getElementsByName("number")[0].value * (this.state.price * (100 - this.state.discount) / 100)
        finalPrice = finalPrice.toFixed(2)
        document.getElementById('AddCartPrice').innerHTML = "Cena: " + finalPrice + " zł"
    }

    addToCart() {
        fetch('http://localhost:9000/addtocarthandle', {
            method: 'POST',
            body: JSON.stringify({"product":this.state.id,"count":parseInt(document.getElementsByName("number")[0].value)
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8'
            },
            credentials:"include"
        })
            .then(res => res.json())
            .then(console.log)
        this.hideAddToCartFrame()
    }

    hideAddToCartFrame() {
        document.getElementsByClassName("addToCartFrame")[0].setAttribute("id","framefloating-fadeout");
        document.getElementsByClassName("darkbcg")[0].setAttribute("id","darken-fadeout");

        setTimeout(() => {
            this.setState({addToCartFrame: ""});
        }, 500)
    }

    showAddToCartFrame() {
        let frame =
            <div>
                <div id="darken" className="darkbcg"/>
                <div id="framefloating" className="addToCartFrame">
                    <h1>Dodaj do koszyka</h1>
                    <h2>{this.state.name}</h2>
                    <table id="fullWidth">
                        <tr>
                            <td id="left">
                                <h2>
                                    Podaj ilość:
                                    <input type="number" id="textbox" name="number" min="1" max="100" defaultValue="1" onChange={this.updateNumber}/>
                                </h2>
                            </td>
                            <td id="right">
                                <h2 id="AddCartPrice">Cena: {this.state.price * (100 - this.state.discount) / 100} zł</h2>
                            </td>
                        </tr>
                        <tr>
                            <td/>
                            <td id="right">
                                <a id="button" href="#" onClick={this.addToCart}>Dodaj produkty</a>
                                <a id="button" href="#" onClick={this.hideAddToCartFrame}>Anuluj</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        this.setState({ addToCartFrame: frame });
    }



    componentDidMount() {
        var url1 = "http://localhost:9000/promotionpr/" + this.props.match.params.product
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

                var url = "http://localhost:9000/product/" + this.props.match.params.product

                fetch(url, {
                    mode: 'cors',
                    headers:{
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin':'http://localhost:3000',
                    },
                    method: 'GET',
                }).then(response => response.json())
                    .then(prod => {
                        let lnkBackToCategory = "/category/" + prod.category;
                        let img = "/img/products/" + prod.id + ".png";
                        this.setState({ id: prod.id });
                        this.setState({ name: prod.name });
                        this.setState({ price: prod.price });
                        let priceDisp = (prod.price).toFixed(2) + " zł"
                        if(this.state.discount > 0)
                            priceDisp = [<b><del>{prod.price} zł</del><t/>
                                PROMOCJA - {this.state.discount}%<t/>
                                {(prod.price * (100 - this.state.discount) / 100).toFixed(2)} zł <t/></b>]
                        let products =
                            <div key={prod.id}>
                                <Category beforeText="Inne produkty z kategorii " category={prod.category}/>
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
                                <div id="productbuttons">
                                    <a id="button" href="#" onClick={this.showAddToCartFrame}>Dodaj do koszyka</a>
                                    {/*<a id="button" href="#opinions">Opinie o produkcie</a>*/}
                                </div>
                                <div>{prod.description}</div>
                            </div>
                        this.setState({ products: products });
                    });
                return 0
            });
    }

    // render() {
    //     return (
    //         <div>
    //             <div id="frame">
    //                 {this.state.products}
    //                 <a name="opinions"/>
    //             </div>
    //             <Opinions product={this.props.match.params.product}/>
    //             {this.state.addToCartFrame}
    //         </div>
    //     )
    // }
}

export default Product;