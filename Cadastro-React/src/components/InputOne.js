import React, { Component } from 'react';


export default class InputOne extends Component{
    render(){
        return(  
                 <div className="form-input-stand">
                       <div className="form-input-stand-label">{this.props.label}</div>	
                       <input type={this.props.type} className="form-input-stand-input" 
                       label={this.props.label} value={this.props.value} onChange={this.props.onChange} />
                  </div>
        );
    }
}