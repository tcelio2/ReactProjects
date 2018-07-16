import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import './css/index.css';
import $ from 'jquery';
window.jquery = window.$ = $;
require('./customer/index');

//import Idiota from './Idiota';

ReactDOM.render(
  <App />,
  document.getElementById('root')

);
