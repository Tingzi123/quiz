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

  onClear(){
    this.setState({
        products:''
       })
  }


  render() {
    return (
      <div className="home">
        {this.state.products.forEach(index,product=>{
          <p>{product.name}</p>,
          <p>数量{product.num}</p>,
          <button onClick={()=>onChecked(product)}>立即下单</button>,
          <button onClick={onClear}>清空</button>
        })}
        
      </div>
    );
  }
}

export default Home;
