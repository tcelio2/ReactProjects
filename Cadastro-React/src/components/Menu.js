import React, { Component } from 'react';

export default class Menu extends Component{

    render(){
            return (
                <div className="menu">
                    <div>
                            <div className="menu-item"><a href="">Customer Information</a></div>
                            <div className="menu-item"><a href="">Located Calls</a></div>
                            <div className="menu-item"><a href="">Callbacks</a></div>
                            <div className="menu-item"><a href="">Incidentes, Calls <br></br> and Callbacks</a></div>
                            <div className="menu-item"><a href="">Dashboard</a></div>
                            <div className="menu-item"><a href="">Map View</a></div>
                    </div>
                </div>
            );
        }
    }
