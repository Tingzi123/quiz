import React, {Component} from 'react';
import '../App.css';
import { Link } from 'react-router-dom';

class AddProduct extends Component {
    state = {
        name: "",
        price: "",
        desc:"",
        img:""
      };
    
      handleFieldChange = (field, e) => {
        this.setState({
          [field]:e.target.value
        })
      };

      handleFormSubmit = (e) => {
        e.preventDefault(e);

        const datas ={
          name:this.state.name,
          price:this.state.price,
          desc:this.state.desc,
          img:this.state.img
       }

       fetch('http://localhost:8080/product',{
           method:"POST",
           headers:{
               "Content-type":"application/json"
           },
           body:JSON.stringify(datas)
       })
       .then(res =>res.json())
       .then(data =>{
           console.log(data)
       })
       .catch(e => console.log("error", e))
      };

      render() {
        return (
          <div className="add-product">
             <div className="container">
        <h1>添加商品</h1>
        <form className="my-profile" onSubmit={this.handleFormSubmit}>

          <div className="form-group">
            <label htmlFor="name">名称：</label>
            <input
              type="text"
              className="form-control"
              id="name"
              value={this.state.name}
              onChange={(e)=>this.handleFieldChange("name",e)}
            ></input>
          </div>

          <div className="form-group">
            <label htmlFor="price">价格：</label>
            <input
              type="text"
              className="form-control"
              id="price"
              value={this.state.price}
              onChange={(e)=>this.handleFieldChange("price",e)}
            ></input>
          </div>

          <div className="form-group">
            <label htmlFor="desc">单位：</label>
            <input
              type="text"
              className="form-control"
              id="desc"
              value={this.state.desc}
              onChange={(e)=>this.handleFieldChange("desc",e)}
            ></input>
          </div>

          <div className="form-group">
            <label htmlFor="img">图片：</label>
            <input
              type="text"
              className="form-control"
              id="img"
              value={this.state.img}
              onChange={(e)=>this.handleFieldChange("img",e)}
            ></input>
          </div>

          <Link to="/home">
              <input type="submit" 
              value="Submit" 
              disabled={!this.state.name || !this.state.price || !this.state.desc || !this.state.img}
              className="btn btn-primary" />
          </Link>

      </form>
      </div>
    </div>
        );
      }  
}

export default AddProduct;