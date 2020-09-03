import React, {Component} from 'react';


class Delivery extends Component {

    constructor() {
        super();
        this.state = {
            delivery: "-",
        };
    }
    componentDidMount() {
        var url = "http://localhost:9000/deliveryord/" + this.props.order
         console.log("deliverry:", this.props.order)
        fetch(url, {
            mode: 'cors',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'http://localhost:3000',
            },
            method: 'GET',
        }).then(response => response.json())
            .then(deliv => {
                if(deliv != null)
                    this.setState({ delivery: deliv.date });
                console.log( deliv.date)
            });
    }

    render() {
        return this.state.delivery
    }
}

export default Delivery;