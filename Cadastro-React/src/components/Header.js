import React, { Component } from 'react';


class Header extends Component{

        render(){
                return (
          			<div className="head">
                        <div className="content-header-left">
                            <input type="text" className="content-header-left-search" value="buscar" />
                            <input type="text" className="content-header-left-refine" />
                        </div>
                        <div className="content-header-right">
                            <div className="content-header-right-butttons">
                                <div className="content-header-right-icon-one"></div>
                                <div className="content-header-right-icon-two"></div>
                                <div className="content-header-right-icon-three"></div>
                            </div>
                        </div>
        			</div>
                );
            }

}
export default Header;