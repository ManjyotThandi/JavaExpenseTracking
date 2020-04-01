import React, {Component} from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Category from './Category';
import Home from './Home';
import logo from './logo.svg';
import AppNav from './AppNav'
import Expense from './Expense'
import './App.css';

class App extends Component {
  state = {}

  render(){
    return( 
      <>
      <AppNav />
      <Router>
        <Switch>
          <Route path ="/" exact ={true} component={Home}/>
          <Route path ="/categories" exact ={true} component={Category}/>
          <Route path ="/expenses" exact ={true} component={Expense}/>
        </Switch>
      </Router>
      </>
    )
  }
}

export default App;
