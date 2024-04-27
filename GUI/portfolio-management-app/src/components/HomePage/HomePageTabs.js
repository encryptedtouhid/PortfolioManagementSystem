import React, { useState } from 'react';
import { Tabs, Tab } from '@mui/material';
import { Link } from 'react-router-dom';
import PortfolioDetailsPage from '../PortfolioDetailsPage/PortfolioDetailsPage';
import AuditContent from '../AuditPage/AuditPage';

function HomePageTabs() {
  const [value, setValue] = useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div>
      <Tabs value={value} onChange={handleChange}>
        <Tab label="Positions" component={Link} to="/positions" />
        <Tab label="Audit" component={Link} to="/audit" />
      </Tabs>
      {value === 0 && <PortfolioDetailsPage />}
      {value === 1 && <AuditContent />}
    </div>
  );
}

export default HomePageTabs;
