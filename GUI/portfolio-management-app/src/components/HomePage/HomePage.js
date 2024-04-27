// components/HomePage.js
import React, { useState } from 'react';
import Header from '../Header/Header';
import HomePageTabs from './HomePageTabs';
import PortfolioDetailsPage from '../../components/PortfolioDetailsPage/PortfolioDetailsPage';
import AddTradePage from '../../components/AddTradePage/AddTradePage';

function HomePage() {
  const [selectedTab, setSelectedTab] = useState('positions');

  const handleTabChange = (tab) => {
    setSelectedTab(tab);
  };

  return (
    <div>
      <Header />
      <HomePageTabs selectedTab={selectedTab} onTabChange={handleTabChange} />
      <div>
        {selectedTab === 'positions' && <PortfolioDetailsPage />}
        {selectedTab === 'audit' && <AddTradePage />}
      </div>
    </div>
  );
}

export default HomePage;