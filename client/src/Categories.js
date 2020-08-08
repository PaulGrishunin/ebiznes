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
                'Access-Control-Allow-Origin':'http://localhost:3000',
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            method: 'GET',
        })

            .then(results => {
                return results.json();
            })
            .then(data => {
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
            // this.setState({categories: categories})
        })
    }

    render() {
        const tableHeader =  <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>

        let tableObjects = this.setState.categories.map(cat => (
            <tr>
                <th>{cat.id}</th>
                <th>{cat.name}</th>
            </tr>

        ));
        return (

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center', height: '100vh', marginLeft: '10vh', marginRight: '10vh'}}>
                    <Table>
                        <thead>
                        {tableHeader}
                        </thead>
                        <tbody>
                        {tableObjects}
                        </tbody>
                    </Table>
                </div>
        )
    }
}

export default Categories;