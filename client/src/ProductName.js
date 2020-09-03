import React, {Component} from 'react';


class ProductName extends Component {

    constructor() {
        super();
        this.state = {
            products: [],
        };
    }
    componentDidMount() {
        var url = "http://localhost:9000/product/" + this.props.product
        console.log("ProdName:", this.props.product)
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
                this.setState({ products: prod.name });
            });
    }

    render() {
        return this.state.products
    }
}

export default ProductName;