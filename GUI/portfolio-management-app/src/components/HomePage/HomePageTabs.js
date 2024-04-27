// components/HomePageTabs.js
import React from 'react';
import { Tabs, Tab } from '@mui/material';
import { Link } from 'react-router-dom';

function HomePageTabs() {
  return (
    <Tabs value={0}>
      <Tab label="Positions" component={Link} to="/positions" />
      <Tab label="Audit" component={Link} to="/audit" />
    </Tabs>
  );
}

export default HomePageTabs;
