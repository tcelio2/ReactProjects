import React, { Component } from 'react';

import './App.css';
import loading from './img/loader3.gif';

import Menu from './components/Menu';
import Header from './components/Header';
import FormInputOne from './components/FormInputOne';

import InputOne from './components/InputOne';

class App extends Component {

	constructor(){
		super();
		this.state = {};
		this.setNome = this.setNome.bind(this);
		this.setPassword = this.setPassword.bind(this);	
	}

	

setNome(evento){	
	this.setState({nome:evento.target.value});
}	

setPassword(evento){
	//this.setState({password:''});
	this.setState({password:evento.target.value});
}

  render() {
    return (
		<div className="main">

			{/* HEADER */}
			<Header />



		{/* MENU */}	
		<Menu />

		


		
		<div className="content">
			<div className="content-head"></div>

				<div className="content-main">


					<div className="content-left">


										{/* FORMINPUTONE Formulario */}			
									<FormInputOne />



									<div className="form-table">
										<table className="pure‐table">
											<thead>
												<tr>
													<th>Nome</th>
													<th>Sobrenome</th>
													<th>Cidade</th>
													<th>Contato</th>
													<th>Endereco</th>
													<th>Sexo</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Fulano</td>	
													<td>da Silva Souza</td>	
													<td>Campinas</td>	
													<td>19 98812-3322</td>	
													<td>Rua. Dos cansados 222</td>	
													<td>M</td>	
												</tr>
												<tr>
													<td>Maria</td>	
													<td>das Dores</td>	
													<td>Limeira</td>	
													<td>19 99923-4422</td>	
													<td>Avenida dos Aflitos, 1350</td>	
													<td>F</td>	
												</tr>
												<tr>
													<td>Patricia</td>	
													<td>Borges da Silva</td>	
													<td>Rio Claro</td>	
													<td>19 3567-2311</td>	
													<td>Rua Arthur Bernardes, 256</td>	
													<td>F</td>	
												</tr>
												<tr>
													<td>Paulo</td>	
													<td>Garcia Coutinho</td>	
													<td>Campinas</td>	
													<td>19 3242-0098</td>	
													<td>Rua Francisco Glicerio,1236</td>	
													<td>M</td>	
												</tr>
												<tr>
													<td>Macedo</td>	
													<td>Lutier Zamdone</td>	
													<td>	ão Carlos</td>	
													<td>19 99126-3048</td>	
													<td>Rua Willian Carlos Marinho, 310</td>	
													<td>M</td>	
												</tr>
												<tr>
													<td>Bruna</td>	
													<td>Terezinha da Silva</td>	
													<td>Piracicaba</td>	
													<td>19 3567-2311</td>	
													<td>Rua Goncalvez Dias, 256</td>	
													<td>F</td>	
												</tr>
												<tr>
													<td>Fulano</td>	
													<td>da Silva Souza</td>	
													<td>Campinas</td>	
													<td>19 98812-3322</td>	
													<td>Rua. Dos cansados 222</td>	
													<td>M</td>	
												</tr>
												<tr>
													<td>Maria</td>	
													<td>das Dores</td>	
													<td>Limeira</td>	
													<td>19 99923-4422</td>	
													<td>Avenida dos Aflitos, 1350</td>	
													<td>F</td>	
												</tr>
												<tr>
													<td>Patricia</td>	
													<td>Borges da Silva</td>	
													<td>Rio Claro</td>	
													<td>19 3567-2311</td>	
													<td>Rua Arthur Bernardes, 256</td>	
													<td>F</td>	
												</tr>
												<tr>
													<td>Paulo</td>	
													<td>Garcia Coutinho</td>	
													<td>Campinas</td>	
													<td>19 3242-0098</td>	
													<td>Rua Francisco Glicerio,1236</td>	
													<td>M</td>	
												</tr>
												<tr>
													<td>Macedo</td>	
													<td>Lutier Zamdone</td>	
													<td>São Carlos</td>	
													<td>19 99126-3048</td>	
													<td>Rua Willian Carlos Marinho, 310</td>	
													<td>M</td>	
												</tr>
												<tr>
													<td>Bruna</td>	
													<td>Terezinha da Silva</td>	
													<td>Piracicaba</td>	
													<td>19 3567-2311</td>	
													<td>Rua Goncalvez Dias, 256</td>	
													<td>F</td>	
												</tr>
												<tr>
													<td>Fulano</td>	
													<td>da Silva Souza</td>	
													<td>Campinas</td>	
													<td>19 98812-3322</td>	
													<td>Rua. Dos cansados 222</td>	
													<td>M</td>	
												</tr>
												<tr>
													<td>Maria</td>	
													<td>das Dores</td>	
													<td>Limeira</td>	
													<td>19 99923-4422</td>	
													<td>Avenida dos Aflitos, 1350</td>	
													<td>F</td>	
												</tr>
												<tr>
													<td>Patricia</td>	
													<td>Borges da Silva</td>	
													<td>Rio Claro</td>	
													<td>19 3567-2311</td>	
													<td>Rua Arthur Bernardes, 256</td>	
													<td>F</td>	
												</tr>
												<tr>
													<td>Paulo</td>	
													<td>Garcia Coutinho</td>	
													<td>Campinas</td>	
													<td>19 3242-0098</td>	
													<td>Rua Francisco Glicerio,1236</td>	
													<td>M</td>	
												</tr>
												<tr>
													<td>Macedo</td>	
													<td>Lutier Zamdone</td>	
													<td>São Carlos</td>	
													<td>19 99126-3048</td>	
													<td>Rua Willian Carlos Marinho, 310</td>	
													<td>M</td>	
												</tr>
												<tr>
													<td>Bruna</td>	
													<td>Terezinha da Silva</td>	
													<td>Piracicaba</td>	
													<td>19 3567-2311</td>	
													<td>Rua Goncalvez Dias, 256</td>	
													<td>F</td>	
												</tr>
											</tbody>
											
										</table>
										<div className="paginator">
											<span>1</span>
											<span>2</span>
											<span>3</span>

										</div>

									</div>					



			</div>{/*  fim content-left */}



					




					<div className="content-right">

										<div className="loader"><img src={loading} /></div>

									{/* component 1 */}
									<div className="component-customer-detail component-customer-detail-head">
											<div className="form-input-one-title"><span>Customer Details</span></div>
											<div className="form-input-one-left">
												<div className="description"><span className="information-description">First name:</span><span>Fulano</span></div>
												<div className="description"><span className="information-description">Last name:</span><span>Pereira Magalhães</span></div>
											</div>
											<div className="form-input-one-right">
													<span><input className="call-button" type="submit"value="Submit customer call" /></span>
											</div>
									</div>

										{/* 2o component */}
									<div className="component-customer-detail component-customer-detail-information">
										<div className="form-input-one-title"><span>Information</span></div>
										<div className="form-input-one-left">
											<div className="description"><span className="information-description">Account:</span><span></span></div>
											<div className="description"><span className="information-description">Account Number:</span><span>58588</span></div>
											<div className="description"><span className="information-description">Connected Status:</span><span>Connected</span></div>
											<div className="description"><span className="information-description">Priority:</span><span>1</span></div>
										</div>
										<div className="form-input-one-right">
												<div className="description"><span className="information-description">Telephone:</span><span>+1 858 987 9148</span></div>
										</div>
									</div>



									{/* 3o component */}
									<div className="component-customer-detail component-customer-detail-location">
											<div className="form-input-one-title"><span>Location</span></div>
											<div className="form-input-one-left">
												<div className="description"><span className="information-description">Address:</span><span></span></div>
												<div className="description"><span className="information-description">Address Line 1:</span><span>149 Harbinson Av</span></div>
												<div className="description"><span className="information-description">Address Line 2:</span><span></span></div>
												<div className="description"><span className="information-description">ZipCode:</span><span>92115</span></div>
												<div className="description"><span className="information-description">City:</span><span>San Diego</span></div>
												<div className="description"><span className="information-description">State Code:</span><span>CA</span></div>
											</div>
											<div className="form-input-one-right">
													<div className="description"><span className="information-description">Electrical Data:</span><span></span></div>
													<div className="description"><span className="information-description">Region:</span><span>Region 1</span></div>
													<div className="description"><span className="information-description">Subregion:</span><span>Subregion11</span></div>
													<div className="description"><span className="information-description">Substation:</span><span>TSH 4</span></div>
													<div className="description"><span className="information-description">Feeder:</span><span>Feeder 207</span></div>
													<div className="description"><span className="information-description">Feeder Object:</span><span>TSM 283</span></div>
											</div>
									</div>	

									{/* 4a component  */}
									<div className="component-customer-detail">
										<div className="form-input-one-title"><span>Callback availability period</span></div>
										<div className="form-input-one-left">
										</div>
										<div className="form-input-one-right">
										</div>
									</div>



									{/* 5o component */}
									<div className="component-customer-detail">
											<div className="form-input-one-title"><span>Meter details</span></div>
											
											<div className="form-input-one-left">
											
											</div>


											<div className="form-input-one-right">
											

											</div>
									</div>


									{/* 6o component */}
									<div className="component-customer-detail">
											<div className="form-input-one-title"><span>Active</span></div>
											<div className="form-input-one-left">
												<div className="description"><span className="information-description">Account:</span><span></span></div>
												<div className="description"><span className="information-description">Account Number:</span><span>58588</span></div>
												<div className="description"><span className="information-description">Connected Status:</span><span>Connected</span></div>
												<div className="description"><span className="information-description">Priority:</span><span>1</span></div>
											</div>
											<div className="form-input-one-right">
													<div className="description"><span className="information-description">Telephone:</span><span>+1 858 987 9148</span></div>
											</div>
									</div>




					</div>	{/* fim do content-right */}








				</div>	{/* fim do content-main */}






						



				</div>	{/* fim do content */}	


		

      </div>
    );
  }
}

export default App;
