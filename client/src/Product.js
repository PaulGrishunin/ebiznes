import React, {Component} from 'react';
import Reviews from './Reviews'
import './Product.css';

class Product extends Component {

    constructor() {
        super();
        this.state = {
            products: [],
            id: 0,
            name: "",
            price: 0,
            amount: 0,
            addToBasketFrame: [],
        };
        this.updateNumber = this.updateNumber.bind(this);
        this.addToBasket = this.addToBasket.bind(this);
        this.hideAddToBasketFrame = this.hideAddToBasketFrame.bind(this);
        this.showAddToBasketFrame = this.showAddToBasketFrame.bind(this);
        this.addToFavorites = this.addToFavorites.bind(this);
    }

    updateNumber() {
        var finalPrice = document.getElementsByName("number")[0].value * (this.state.price * (100 - this.state.amount) / 100)
        finalPrice = finalPrice.toFixed(2)
        document.getElementById('AddBasketPrice').innerHTML = "Price: " + finalPrice + " usd"
    }

    addToBasket() {
        fetch('http://localhost:9000/addtobaskethandle', {
            method: 'POST',
            body: JSON.stringify({"product":this.state.id,"quantity":parseInt(document.getElementsByName("number")[0].value)
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8'
            },
            credentials:"include"
        })
            .then(res => res.json())
            .then(console.log)
        this.hideAddToBasketFrame()
    }

    hideAddToBasketFrame() {
        document.getElementsByClassName("addToBasketFrame")[0].setAttribute("id","framefloating-fadeout");
        document.getElementsByClassName("darkbcg")[0].setAttribute("id","darken-fadeout");

        setTimeout(() => {
            this.setState({addToBasketFrame: ""});
        }, 500)
    }

    showAddToBasketFrame() {
        let frame =
            <div>
                <div id="darken" className="darkbcg"/>
                <div id="framefloating" className="addToBasketFrame">
                    <h1>Add to Basket</h1>
                    <h2>{this.state.name}</h2>
                    <table className="fullWidth">
                        <tr>
                            <td >
                                <h2>
                                    Quantity:
                                    <input className="right" type="number" id="textbox" name="number" min="1" max="100" defaultValue="1" onChange={this.updateNumber}/>
                                </h2>
                            </td>
                            <td >
                                <h2 className="left" id="AddBasketPrice">Price: {this.state.price * (100 - this.state.amount) / 100} usd</h2>
                            </td>
                        </tr>
                        <tr>
                            <td/>
                            <td className="productbuttons">
                                <a className="button blue" href="#" onClick={this.addToBasket}><b>Add products</b></a>
                                <a className="button red" href="#" onClick={this.hideAddToBasketFrame}><b>Cancel</b></a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        this.setState({ addToBasketFrame: frame });
    }

    addToFavorites() {
        fetch('http://localhost:9000/addfavoriteshandle', {
            method: 'POST',
            body: JSON.stringify({"product":this.state.id}),
            headers: {
                'Content-type': 'application/json; charset=UTF-8'
            },
            credentials:"include"
        })
            .then(res => res.json())
            .then(console.log)
        window.location.reload(false);
    }

    componentDidMount() {
        var url1 = "http://localhost:9000/discountpr/" + this.props.match.params.product
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
                        let img = "/img/products/" + prod.id + ".png";
                        this.setState({ id: prod.id });
                        this.setState({ name: prod.name });
                        this.setState({ price: prod.price });
                        let priceDisp = (prod.price).toFixed(2) + " usd"
                        if(this.state.amount > 0)
                            priceDisp = [<b style={{color: 'red'}}><del>{prod.price} usd </del>
                                { (prod.price * (100 - this.state.amount) / 100).toFixed(2)} usd
                                <br/>
                                Discount - {this.state.amount} %
                                         </b>]
                        let products =
                            <div className="productPage" key={prod.id}>
                               <div className="Image">
                                            <img src={img} alt='' width="420" height="420"/>
                               </div>
                                <div className="productInfo">
                                            <div className="prodname"><b>{prod.name}</b></div>  <br/>
                                            <div className="prodcategory"><b>Category: </b>{prod.category}</div>  <br/>
                                            <div className="proddescription"><b>Description: </b>{prod.description}</div><br/>
                                            <div className="prodprice"><b>Price: </b>{priceDisp}</div>

                                <div className="productbuttons">
                                    <a className="button blue" href="#" onClick={this.showAddToBasketFrame}><b>Add to Basket</b></a>
                                    <a className="button blue" href="#" onClick={this.addToFavorites}><b>Add to Favorites</b></a>
                                </div>
                                        </div>
                            </div>
                        this.setState({ products: products });
                    });
                return 0
            });
    }

    render() {
        return (
            <div>
                <div >
                    {this.state.products}
                    <a name="reviews"/>
                </div>
                {this.state.addToBasketFrame}
                <Reviews product={this.props.match.params.product}/>

            </div>
        )
    }
}

export default Product;