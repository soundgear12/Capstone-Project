import React, { Component } from "react";



class FetchAccounts extends Component {

    constructor(props) {
        super(props);

        this.state = {
            error: null,
            isLoaded: false,
            checking: []
        };
    }




    componentDidMount() {
        fetch("http://localhost:8080/AccountHolders/1", {
            method: "GET",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            }


        })
            .then(res => res.json())
            .then(
                result => {
                    console.log(result);
                    this.setState({
                        isLoaded: true,
                        checking: result.personalCheckingAccounts
                    });
                },
                error => {
                    console.log(error);
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            );
    }



    render() {
        return (
            <div>
                <h2 className="text-center">Checking Account Details</h2>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>Account Number</th>
                            <th>interestRate</th>
                            <th>Balance</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.checking.map(check => 
                            <tr key={check.accountNumber}>
                            <td>{check.accountNumber}</td>
                            <td>{check.interestRate}</td>
                            <td>{check.balance}</td>
                        </tr>
                        )
                        } 
            
                    </tbody>
                    </table>
                </div>
                );
        }
    



}

                export default FetchAccounts;