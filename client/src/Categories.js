import React, {Component} from 'react';
import {Table} from "reactstrap";

class Categories extends Component {

    constructor() {
        super();
        this.state = {
            categories: [],
        };
    }

    componentDidMount() {
        var url = "http://localhost:9000/categories"

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
            let categories = data.map((cat) => {
                let link = "/category/" + cat.id;
                let linkid = "listbutton";
                if(this.props.location.pathname === link) linkid = "listbuttonSelected"
                return (
                    <div key={cat.id}>
                        <div className="name"><a id={linkid} href={link}>{cat.name}</a></div>
                    </div>
                )

            })
            this.setState({categories: categories})
        })
    }

    render() {
        return (
                <div style={{display: 'flex',  justifyContent:'center', alignItems:'top', height: '100vh', marginLeft: '10vh', marginTop: '20px', marginRight: '10vh', fontSize: 'x-large'}}>
                    <Table>
                        <thead>
                        <tr>
                            <th>CATEGORIES:</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th><div className="categories">
                                {this.state.categories}
                            </div>
                            </th>
                        </tr>


                        </tbody>
                    </Table>
                </div>


        )
    }
}

export default Categories;