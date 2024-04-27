import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import HomePage from './components/HomePage/HomePage';
// import PortfolioDetailsPage from './components/PortfolioDetailsPage/PortfolioDetailsPage';
// import AddTradePage from './components/AddTradePage/AddTradePage';


function App() {
  return (
    <Router>
      <Route path="/" component={HomePage} />
    </Router>
  );
}

export default App;
