import React, {Component} from 'react';
import Rater from 'react-rater';
// import 'react-rater/lib/react-rater.css';
import './Reviews.css';
import UserFace from './UserFace';

class Reviews extends Component {

    constructor() {
        super();
        this.state = {
            reviews: [],
            exists: false,
            addframe: "",
        };
        this.sentReview = this.sentReview.bind(this);
        this.showAdd = this.showAdd.bind(this);
        this.hideAdd = this.hideAdd.bind(this);
    }

    sentReview() {
        fetch('http://localhost:9000/addreviewhandle', {
            method: 'POST',
            body: JSON.stringify({
                "product":this.props.product,
                "rate":parseInt(document.getElementsByName("rate")[0].value),
                "text":document.getElementsByName("text")[0].value
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8'
            },
            credentials:"include"
        })
            .then(res => res.json())
            .then(console.log)
        window.location.reload(false);
        console.log(this.props.product)
    }

    updateRate() {
        var rate = document.getElementsByName("rate")[0].value
    //     document.getElementsByName('starsDisplayer')[0].setAttribute("src","/img/stars/" + rate + ".png")
    }

    hideAdd() {
        document.getElementsByClassName("addframe")[0].setAttribute("id","framefloating-fadeout");
        document.getElementsByClassName("darkbcg")[0].setAttribute("id","darken-fadeout");

        setTimeout(() => {
            this.setState({addframe: ""});
        }, 500)
    }


    showAdd() {
        let frame =
            <div>
                <div id="darken" className="darkbcg"/>
                <div id="framefloating" className="addframe">
                    <h1>Add your review</h1>
                    <h3>
                        Rate:
                        <input type="number" id="textbox" name="rate" min="0" max="5" defaultValue="5" onChange={this.updateRate}/>
                    </h3>
                    <h3>
                        Text review:
                    </h3>
                    <textarea className="fullWidth" name="text"/>
                    <div className="productbuttons" >
                        <a className="button blue" href="#" onClick={this.sentReview}>Add review</a>

                        <a className="button red" href="#" onClick={this.hideAdd}>Cancel</a>
                    </div>
                </div>
            </div>
        this.setState({ addframe: frame });
    }

    componentDidMount() {
        var url = "http://localhost:9000/review/" + this.props.product

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
            let reviews = data.map((rev) => {
                this.setState({exists: true})
                return (
                    <div className="review" key={rev.id}>
                        <table id="rev">
                            <tr>
                                <td width="120px">
                                    <UserFace user={rev.user}/>
                                </td>
                                <td>
                                    <tr>
                                    <div className="Rater">
                                        <Rater total={5} rating={parseFloat(rev.rate)} interactive={false}/>
                                    </div>
                                    </tr>
                                    <tr>
                                        <div className="textReview"><i>{rev.text}</i></div>
                                    </tr>
                                </td>
                            </tr>
                        </table>
                    </div>
                )
            })
            this.setState({reviews: reviews})
        })
    }

    render() {
        return (
            <div>
                {this.state.addframe}
                <div id="frame">
                    <table className="fullWidth">
                        <tr>
                            <td className="left">
                                <h1>
                                    Reviews:
                                </h1>
                            </td>
                            <td className="right">
                                <a className="button blue" href="#" onClick={this.showAdd}>Add your review</a>
                            </td>
                        </tr>
                    </table>

                </div>
                <div id="frame">
                    {this.props.reviews}
                </div>
            </div>
        )
    }
}

export default Reviews;