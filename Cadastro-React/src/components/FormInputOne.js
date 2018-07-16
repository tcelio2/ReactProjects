import React, { Component } from 'react';
import InputOne from './InputOne';


export default class FormInputOne extends Component{


    render(){

        return(
                <div className="form-input-one">
                        <div className="form-input-one-title"><span>Customers</span></div>
                        
                        <div className="form-input-one-left">
                            <div className="form-input-one-left-title">Customer Information</div>
                        
                            {/* INPUTONE -> Primeiro modelo de input criado */}
							<InputOne label="Name" value={this.state.name} type="text" />
                            <InputOne label="Last Name" value={this.state.lastname} type="text" />
                            <InputOne label="City" value={this.state.city} type="text" />
                            




                          
                        </div>
                        
                        <div className="form-input-one-right">
                        
                            <div className="form-input-one-left-title">Contact</div>
                        

                            <InputOne label="Telephone Number" value={this.state.telnumber} type="text" />
                            <InputOne label="City" value={this.state.city} type="text" />
                            <InputOne label="Address" value={this.state.address} type="text" />
                        

                            <div className="form-input-inputGroup">
                                <input type="submit" className="clear" value="Clear" />
                                <input type="submit" className="search" value="Search" />
                        
                            </div>
                        
                        </div>
                
                </div> 


        );


    }







}