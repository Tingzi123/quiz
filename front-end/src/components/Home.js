import React, {Component} from 'react';
import '../App.css';

class Home extends Component {
  state={
    products:[]
  }

  componentWillMount(){
    fetch('http://localhost:8080/products',{
           method:"GET",
           headers:{
               "Content-type":"application/json"
           },
       })
       .then(res =>res.json())
       .then(data =>{
         this.setState({
          products:data
         })
       })
       .catch(e => console.log("error", e))
  }

  onChecked(product){
    fetch('http://localhost:8080/order',{
           method:"POST",
           headers:{
               "Content-type":"application/json"
           },
           body:JSON.stringify(product)
       })
       .then(res =>res.json())
       .then(data =>{
          console.log(data)
       })
       .catch(e => console.log("error", e))
  }


  render() {
    return (
      <div className="home">
        {this.state.products.forEach(index,product=>{
          <p id={index}>{product.img}</p>,
          <p>{product.name}</p>,
          <p>单价：{product.price}/{product.desc}</p>,
          <button onClick={()=>this.onChecked(product)}>添加购物车</button>
        })}
        
      </div>
    );
  }
}

export default Home;
