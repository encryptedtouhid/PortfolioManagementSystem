import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import HomePage from './components/HomePage/HomePage';
// index.js or App.js
import 'bootstrap/dist/css/bootstrap.min.css';

// import PortfolioDetailsPage from './components/PortfolioDetailsPage/PortfolioDetailsPage';
// import AddTradePage from './components/AddTradePage/AddTradePage';
import './App.css'; // Import app.css file


function App() {
  return (
    <Router>
      <Route path="/" component={HomePage} />
    </Router>
  );
}

export default App;
