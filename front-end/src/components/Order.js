import React, {Component} from 'react';
import '../App.css';

class Order extends Component {
  state={
    orders:[]
  }

  componentWillMount(){
    fetch('http://localhost:8080/orders',{
           method:"GET",
           headers:{
               "Content-type":"application/json"
           },
       })
       .then(res =>res.json())
       .then(data =>{
         this.setState({
            orders:data
         })
       })
       .catch(e => console.log("error", e))
  }


  render() {
    return (
      <div className="order">
          <ul>
              <li>名字</li>
              <li>单价</li>
              <li>数量</li>
              <li>单位</li>
              <li>操作</li>
          </ul>

          <ul>
            {this.state.orders.forEach(order=>{
            <li>{order.name}</li>,
            <li>{order.price}</li>,
            <li>{order.num}</li>,
            <li>{order.desc}</li>,
            <button>删除</button>
            })}
          </ul>
       
        
      </div>
    );
  }
}

export default Order;
