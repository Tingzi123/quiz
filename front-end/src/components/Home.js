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


  render() {
    return (
      <div className="home">
        {this.state.products.forEach(product=>{
          <p>{product.img}</p>,
          <p>{product.name}</p>,
          <p>单价：{product.price}/{product.desc}</p>
        })}
        
      </div>
    );
  }
}

export default Home;
