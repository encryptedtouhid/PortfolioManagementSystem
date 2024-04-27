// components/HomePage.js
import React, { useState } from 'react';
import Header from '../Header/Header';
import HomePageTabs from './HomePageTabs';
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
    </div>
  );
}

export default HomePage;