// components/HomePage.js
import React, { useState } from 'react';
import Header from '../Header/Header';
import HomePageTabs from './HomePageTabs';
import PortfolioDetailsPage from '../../components/PortfolioDetailsPage/PortfolioDetailsPage';
import AddTradePage from '../../components/AddTradePage/AddTradePage';
import './HomePage.css'

function HomePage() {
  const [selectedTab, setSelectedTab] = useState('positions');

  const handleTabChange = (tab) => {
    setSelectedTab(tab);
  };

  return (
    <div className="container">
      <Header />
      <div className="tabs-container">
        <HomePageTabs selectedTab={selectedTab} onTabChange={handleTabChange} />
      </div>
      <div className="content-container">
        {selectedTab === 'positions' && (
          <div>
            <PortfolioDetailsPage/>
          </div>
        )}
        {selectedTab === 'audit' && (
          <div>
           <AddTradePage/>
          </div>
        )}
      </div>
    </div>
  );
}

export default HomePage;