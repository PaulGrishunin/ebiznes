import React, {Component} from 'react';
// import UserAvatar from "./UserAvatar";

class Reviews extends Component {

    constructor() {
        super();
        this.state = {
            opinions: [],
            exists: false,
            addframe: "",
        };
        this.showAdd = this.showAdd.bind(this);
        this.hideAdd = this.hideAdd.bind(this);
    }

    sentOpinion() {
        fetch('http://localhost:9000/addreviewhandle', {
            method: 'POST',
            body: JSON.stringify({
                "stars":parseInt(document.getElementsByName("stars")[0].value),
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
    }

    // updateStars() {
    //     var rate = document.getElementsByName("rate")[0].value
    //     document.getElementsByName('starsDisplayer')[0].setAttribute("src","/img/stars/" + stars + ".png")
    // }

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
                    <h1>Dodaj opinię o sklepie</h1>
                    <h3>
                        Ocena:
                        <input type="number" id="textbox" name="stars" min="0" max="5" defaultValue="5" onChange={this.updateStars}/>
                        <img name="starsDisplayer" id="stars" src="/img/stars/5.png"/>
                    </h3>
                    <h3>
                        Twoja opinia:
                    </h3>
                    <textarea id="fullWidth" name="text"/>
                    <div id="right">
                        <a id="button" href="#" onClick={this.sentOpinion}>Dodaj opinię</a>
                        <a id="button" href="#" onClick={this.hideAdd}>Anuluj</a>
                    </div>
                </div>
            </div>
        this.setState({ addframe: frame });
    }

    componentDidMount() {
        var url = "http://localhost:9000/comments"

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
            let opinions = data.map((op) => {
                this.setState({exists: true})
                let starsDisp = "/img/stars/" + op.stars + ".png";
                return (
                    <div key={op.id}>
                        <table id="opinion">
                            <tr>
                                {/*<td width="250px">*/}
                                {/*    <UserAvatar user={op.user}/>*/}
                                {/*</td>*/}
                                <td>
                                    <div id="opinion">{op.text}</div>
                                </td>
                                <td id="right">
                                    <img id="stars" src={starsDisp}/>
                                </td>
                            </tr>
                        </table>
                    </div>
                )
            })
            this.setState({opinions: opinions})
        })
    }

    render() {
        return (
            <div>
                {this.state.addframe}
                <div id="frame">
                    <table id="fullWidth">
                        <tr>
                            <td>
                                <h3>
                                    <t/><t/>OPINIE O SKLEPIE
                                </h3>
                            </td>
                            <td id="right">
                                <a id="button" href="#" onClick={this.showAdd}>Dodaj swoją opinię</a>
                            </td>
                        </tr>
                    </table>

                </div>
                <div id="frame">
                    {this.state.reviews}
                </div>
            </div>
        )
    }
}

export default Reviews;