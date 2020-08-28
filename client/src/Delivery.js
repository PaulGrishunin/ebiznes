import React, {Component} from 'react';
import Category from './Category'
import Reviews from './Reviews'

class Delivery extends Component {

    constructor() {
        super();
        this.state = {
            delivery: "-",
        };
    }
    componentDidMount() {
        var url = "http://localhost:9000/deliveryord/" + this.props.order

        fetch(url, {
            mode: 'cors',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'http://localhost:3000',
            },
            method: 'GET',
        }).then(response => response.json())
            .then(del => {
                if(del != null)
                    this.setState({ delivery: del.date });
            });
    }

    render() {
        return this.state.delivery
    }
}

export default Delivery;