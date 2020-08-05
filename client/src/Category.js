import React, {Component} from 'react';

class Category extends Component {

    constructor() {
        super();
        this.state = {
            category: [],
        };
    }

    componentDidMount() {
        var url = "http://localhost:9000/category/" + this.props.category

        fetch(url, {
            mode: 'cors',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'http://localhost:3000',
            },
            method: 'GET',
        }).then(response => response.json())
            .then(cat => {
                let lnkBackToCategory = "/category/" + cat.id;
                let category =
                    <a id="button" href={lnkBackToCategory}>{this.props.beforeText}{cat.name}</a>
                this.setState({ category: category });
            });
    }

    render() {
        return (
            <div className="category">
                {this.state.category}
            </div>
        )
    }
}

export default Category;