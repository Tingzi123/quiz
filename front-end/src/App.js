import React, {Component} from 'react';
import { BrowserRouter,Switch,Route } from 'react-router-dom';
import './App.css';
import AddProduct from "./components/AddProduct";
import Home from "./components/Home";
import Order from "./components/Order";

class App extends Component {
  render() {
    return (
      <div className="App">
        <BrowserRouter>
        
          <Link to="/Home">
            <HiOutlineHome />
            商城
          </Link>
          <Link to="/order">
            <AiOutlineShoppingCart />
            订单
          </Link>
          <Link to="/add-product">
            <BsPlus />
            添加商品
          </Link>
      

          <Switch>
            <Route exact path='/' component={Home} />
            <Route exact path='/home' component={Home} />
            <Route exact path='/order' component={Order} />
            <Route exact path="/add-product" component={AddProduct} />
          </Switch>    
        </BrowserRouter>
      </div>
    );
  }
}

export default App;
