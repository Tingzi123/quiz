import React, {Component} from 'react';
import { BrowserRouter,Switch,Route } from 'react-router-dom';
import './App.css';
import AddProduct from "./components/AddProduct";
import Home from "./components/Home";

class App extends Component {
  render() {
    return (
      <div className="App">
        <BrowserRouter>
          <AddProduct/>

          <Switch>
            <Route exact path='/' component={Home} />
            <Route exact path='/home' component={Home} />
          </Switch>    
        </BrowserRouter>
      </div>
    );
  }
}

export default App;
