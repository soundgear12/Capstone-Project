import React, { Component } from 'react';
import Header from './HeaderComponent';
import Home from './HomePageComponent';
import FetchAccounts from './FetchAccounts';
import RegisterUser from './RegisterUser';
import Footer from './FooterComponent';
import { Switch, Route, Redirect } from 'react-router-dom';
import CreateAccount from './CreateAccount';





class Main extends Component {

    constructor(props) {
        super(props);
    }


    render() {

        const HomePage = () => {
            return(
                <Home />
            );
        }

        const AccountPage = () => {
            return(
                <FetchAccounts />
            );
        }

        const RegisterPage = () => {
            return(
                <RegisterUser />
            );
        }

        const CreateAccountPage = () => {
            return(
                <CreateAccount />
            );
        }


        return (

            <div>    
                <Header/>    
                <Switch>
                    <Route path="/home" component={HomePage} />
                    <Route path="/create" component={CreateAccountPage} />
                    <Route path="/accounts" component={AccountPage} />
                    <Route path="/register" component={RegisterPage} />
                    <Redirect to="/home" />
                </Switch>
                <Footer />
            </div>
        );
    }
}

export default Main;